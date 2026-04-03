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
 * - Volume formula verified against: [source] https://www.geeksforgeeks.org/maths/rectangular-prism/
 * - Surface area formula verified against: [source] https://www.geeksforgeeks.org/maths/rectangular-prism/
 */

package com.csc205.project2.shapes;

public class RectangularPrism extends Shape3D {

    private double length;
    private double width;
    private double height;

    public RectangularPrism(double length, double width, double height) {
        super("Rectangular Prism", "Purple");
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Length, width, and height must be positive.");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public RectangularPrism(double length, double width, double height, String name) {
        super(name, "Purple");
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Length, width, and height must be positive.");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive.");
        }
        this.width = width;
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
        return length * width * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * ((width * length) + (height * length) + (height * width));
    }

    @Override
    public String toString() {
        return "RectangularPrism{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
