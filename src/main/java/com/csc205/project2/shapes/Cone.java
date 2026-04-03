/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: Gemini Pro 2.5
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * Generate the following shapes using AI assistance:
 *
 * 1. **Sphere** - Properties: radius
 * 2. **Cube** - Properties: sideLength
 * 3. **Cylinder** - Properties: radius, height
 * 4. **RectangularPrism** - Properties: length, width, height
 * 5. **[Your Choice]** - Select any 3D geometric shape (examples: Cone, Pyramid, Torus, Ellipsoid, Octahedron)
 *
 **For Each Shape Class:**
 * - Extends Shape3D (which implements ThreeDimensionalShape)
 * - Implement the abstract methods from ThreeDimensionalShape
 * - Include proper constructors with validation
 * - Override `toString()` with shape-specific formatting
 * - Add any shape-specific methods if needed
 *
 * Generate complete JUnit tests for each shape with mathematical formula testing
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output] None
 * - [Explain why changes were necessary]
 *
 * Formula Verification:
 * - Volume formula verified against: (Math.PI * R * R * H) / 3; https://www.geeksforgeeks.org/java/java-program-to-find-the-surface-area-and-volume-of-a-cone/
 * - Surface area formula verified against: (Math.PI * R * R) + (Math.PI * R * S); same source
 */

package com.csc205.project2.shapes;

public class Cone extends Shape3D {

    private double radius;
    private double height;

    public Cone(double radius, double height) {
        super("Cone", "Yellow");
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be positive.");
        }
        this.radius = radius;
        this.height = height;
    }

    public Cone(double radius, double height, String name) {
        super(name, "Yellow");
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Radius and height must be positive.");
        }
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive.");
        }
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * (height / 3.0);
    }

    @Override
    public double getSurfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public String toString() {
        return "Cone{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", radius=" + radius +
                ", height=" + height +
                '}';
    }
}
