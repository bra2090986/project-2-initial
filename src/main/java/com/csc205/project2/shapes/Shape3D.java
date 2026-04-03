/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: Gemini 2.5 Pro
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * Create `Shape3D.java` with these requirements:
 *
 * **Must Include:**
 * - Implements the `ThreeDimensionalShape` interface
 * - Concrete implementations of `getVolume()` and `getSurfaceArea()` that call the abstract methods
 * - Common properties: `name` (String), `color` (String)  (Properties in Java are typically private fields with public getters and setters)
 * - Constructor(s) for initialization
 * - `toString()` method that formats output consistently
 * - Getter/setter methods as appropriate
 *
 * Gemerate complete JUnit tests
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]"
 * 2. "[Refinement prompt 2]"
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output] None
 * - [Explain why changes were necessary]
 */

package com.csc205.project2.shapes;

public abstract class Shape3D implements ThreeDimensionalShape {

    private String name;
    private String color;

    public Shape3D() {
        this.name = "Shape3D";
        this.color = "Gray";
    }

    public Shape3D(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();

    @Override
    public String toString() {
        return "Shape3D{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
