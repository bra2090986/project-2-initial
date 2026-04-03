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
 * - Volume formula verified against: [source] https://www.geeksforgeeks.org/maths/sphere-formulas/
 * - Surface area formula verified against: [source] https://www.geeksforgeeks.org/maths/sphere-formulas/
 */

package com.csc205.project2.shapes;

public class Sphere extends Shape3D {

    private double radius;

    public Sphere(double radius) {
        super("Sphere", "Green");
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    public Sphere(double radius, String name) {
        super(name, "Green");
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
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

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", radius=" + radius +
                '}';
    }
}
