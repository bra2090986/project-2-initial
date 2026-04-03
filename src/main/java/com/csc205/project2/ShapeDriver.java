/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: Gemini 2.5 Pro
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * Create a sophisticated `ShapeDriver.java` that demonstrates:
 *
 * - **Polymorphism**: Array/List of Shape3D references holding different shapes
 * - **Comparative Analysis**: Which shape has the largest volume for given constraints?
 * - **Interactive Features**: Allow user to create shapes with custom parameters
 * - **Performance Timing**: Measure calculation speeds (optional)
 * - **Formatted Output**: Professional presentation of results
 *
 * **Sample Output Format:**
 * ```
 * === 3D Shape Analysis System ===
 *
 * Created Shapes:
 * 1. Sphere {name='Red Ball', radius=5.0}
 *    - Surface Area: 314.16 square units
 *    - Volume: 523.60 cubic units
 *
 * 2. Cube {name='Blue Box', side=4.0}
 *    - Surface Area: 96.00 square units
 *    - Volume: 64.00 cubic units
 *
 * [... other shapes ...]
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]" Repeat to generate additional shapes or quit
 * 2. "[Refinement prompt 2]" there shouldn't be any shapes until the user inputs them
 * 3. "[Refinement prompt 3]" take a name property from user, then display property of Color Name
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output] None
 * - [Explain why changes were necessary]
 */

package com.csc205.project2;

import com.csc205.project2.shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeDriver {

    public static void main(String[] args) {
        System.out.println("=== 3D Shape Analysis System ===");
        System.out.println();

        List<Shape3D> shapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            if (choice == 6) {
                break;
            }

            addNewShape(shapes, scanner, choice);

            if (shapes.isEmpty()) {
                System.out.println("\nThere are currently no shapes.");
            } else {
                System.out.println("\n--- Current Shapes ---");
                printShapes(shapes);

                Shape3D largestVolumeShape = findLargestVolume(shapes);
                System.out.println("\nShape with the largest volume: " + largestVolumeShape.getName());
                System.out.println(largestVolumeShape);
                System.out.printf("   - Volume: %.2f cubic units\n", largestVolumeShape.getVolume());
            }
        }

        System.out.println("\n=== Analysis Complete ===");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Sphere");
        System.out.println("2. Add Cube");
        System.out.println("3. Add Cylinder");
        System.out.println("4. Add Rectangular Prism");
        System.out.println("5. Add Cone");
        System.out.println("6. Quit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        return choice;
    }

    private static void printShapes(List<Shape3D> shapes) {
        for (int i = 0; i < shapes.size(); i++) {
            Shape3D shape = shapes.get(i);
            System.out.println((i + 1) + ". " + shape);
            System.out.printf("   - Surface Area: %.2f square units\n", shape.getSurfaceArea());
            System.out.printf("   - Volume: %.2f cubic units\n", shape.getVolume());
            System.out.println();
        }
    }

    private static Shape3D findLargestVolume(List<Shape3D> shapes) {
        if (shapes.isEmpty()) {
            return null;
        }

        Shape3D largestShape = shapes.get(0);
        for (Shape3D shape : shapes) {
            if (shape.getVolume() > largestShape.getVolume()) {
                largestShape = shape;
            }
        }
        return largestShape;
    }

    private static void addNewShape(List<Shape3D> shapes, Scanner scanner, int choice) {
        Shape3D newShape = null;
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter a name for the shape: ");
        String name = scanner.nextLine();
        System.out.print("Enter a color for the shape: ");
        String color = scanner.nextLine();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    newShape = new Sphere(radius, name);
                    break;
                case 2:
                    System.out.print("Enter side length: ");
                    double sideLength = scanner.nextDouble();
                    newShape = new Cube(sideLength, name);
                    break;
                case 3:
                    System.out.print("Enter radius: ");
                    double cylRadius = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double cylHeight = scanner.nextDouble();
                    newShape = new Cylinder(cylRadius, cylHeight, name);
                    break;
                case 4:
                    System.out.print("Enter length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    newShape = new RectangularPrism(length, width, height, name);
                    break;
                case 5:
                    System.out.print("Enter radius: ");
                    double coneRadius = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double coneHeight = scanner.nextDouble();
                    newShape = new Cone(coneRadius, coneHeight, name);
                    break;
                default:
                    if (choice != -1) { // Don't show for the error case handled in getUserChoice
                        System.out.println("Invalid choice.");
                    }
                    return;
            }

            if (newShape != null) {
                newShape.setColor(color);
                shapes.add(newShape);
                System.out.println("\nSuccessfully added new shape.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating shape: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a number for the dimensions.");
            scanner.next(); // Clear the invalid input
        }
    }
}
