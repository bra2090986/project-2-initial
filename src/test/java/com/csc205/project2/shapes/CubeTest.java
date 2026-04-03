/**
 * AI GENERATION DOCUMENTATION
 * ===========================
 * AI Tool Used: Gemini Pro 2.5
 * Generation Date: 2/26/2026
 *
 * Original Prompt:
 * Generate complete JUnit tests
 *
 * Follow-up Prompts (if any):
 * 1. "[Refinement prompt 1]" For each shape class, ensure there are at least these 5 test classes including:
 * **Test Categories:**
 * - **Basic Functionality**: Constructor, getters, setters
 * - **Calculation Accuracy**: Volume and surface area with known values
 * - **Boundary Testing**: Zero values, very small/large numbers
 * - **Input Validation**: Negative values, null inputs
 * - **Inheritance Testing**: Polymorphic behavior verification
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output] None
 * - [Explain why changes were necessary]
 *
 * Formula Verification:
 * - Volume formula verified against: [source]
 * - Surface area formula verified against: [source]
 */

package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CubeTest {

    // Basic Functionality Tests
    @Test
    void testConstructorAndGetters() {
        Cube cube = new Cube(4.0);
        assertEquals(4.0, cube.getSideLength());
        assertEquals("Cube", cube.getName());
        assertEquals("Blue", cube.getColor());
    }

    @Test
    void testSetters() {
        Cube cube = new Cube(4.0);
        cube.setSideLength(8.0);
        assertEquals(8.0, cube.getSideLength());
    }

    // Calculation Accuracy Tests
    @Test
    void testGetVolume() {
        Cube cube = new Cube(4.0);
        assertEquals(64.0, cube.getVolume());
    }

    @Test
    void testGetSurfaceArea() {
        Cube cube = new Cube(4.0);
        assertEquals(96.0, cube.getSurfaceArea());
    }

    // Boundary Testing
    @Test
    void testBoundaryValues() {
        Cube smallCube = new Cube(1e-6);
        assertTrue(smallCube.getVolume() > 0);
        assertTrue(smallCube.getSurfaceArea() > 0);

        Cube largeCube = new Cube(1e6);
        assertEquals(Math.pow(1e6, 3), largeCube.getVolume());
        assertEquals(6 * Math.pow(1e6, 2), largeCube.getSurfaceArea());
    }

    // Input Validation Tests
    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Cube(0));
        assertThrows(IllegalArgumentException.class, () -> new Cube(-4.0));
    }

    @Test
    void testInvalidSetter() {
        Cube cube = new Cube(4.0);
        assertThrows(IllegalArgumentException.class, () -> cube.setSideLength(0));
        assertThrows(IllegalArgumentException.class, () -> cube.setSideLength(-8.0));
    }

    // Inheritance Testing
    @Test
    void testPolymorphism() {
        Shape3D cube = new Cube(4.0);
        assertTrue(cube instanceof ThreeDimensionalShape);
        assertEquals(64.0, cube.getVolume());
        assertEquals(96.0, cube.getSurfaceArea());
        assertEquals("Cube", ((Cube) cube).getName());
    }

    @Test
    void testToString() {
        Cube cube = new Cube(4.0);
        String expected = "Cube{" +
                "name='" + "Cube" + '\'' +
                ", color='" + "Blue" + '\'' +
                ", sideLength=" + 4.0 +
                '}';
        assertEquals(expected, cube.toString());
    }
}
