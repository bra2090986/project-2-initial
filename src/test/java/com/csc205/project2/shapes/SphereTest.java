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
 */

package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    // Basic Functionality Tests
    @Test
    void testConstructorAndGetters() {
        Sphere sphere = new Sphere(5.0);
        assertEquals(5.0, sphere.getRadius());
        assertEquals("Sphere", sphere.getName());
        assertEquals("Green", sphere.getColor());
    }

    @Test
    void testSetters() {
        Sphere sphere = new Sphere(5.0);
        sphere.setRadius(10.0);
        assertEquals(10.0, sphere.getRadius());
    }

    // Calculation Accuracy Tests
    @Test
    void testGetVolume() {
        Sphere sphere = new Sphere(5.0);
        double expectedVolume = (4.0 / 3.0) * Math.PI * Math.pow(5.0, 3);
        assertEquals(expectedVolume, sphere.getVolume());
    }

    @Test
    void testGetSurfaceArea() {
        Sphere sphere = new Sphere(5.0);
        double expectedSurfaceArea = 4 * Math.PI * Math.pow(5.0, 2);
        assertEquals(expectedSurfaceArea, sphere.getSurfaceArea());
    }

    // Boundary Testing
    @Test
    void testBoundaryValues() {
        Sphere smallSphere = new Sphere(1e-6);
        assertTrue(smallSphere.getVolume() > 0);
        assertTrue(smallSphere.getSurfaceArea() > 0);

        Sphere largeSphere = new Sphere(1e6);
        assertEquals((4.0 / 3.0) * Math.PI * Math.pow(1e6, 3), largeSphere.getVolume());
        assertEquals(4 * Math.PI * Math.pow(1e6, 2), largeSphere.getSurfaceArea());
    }

    // Input Validation Tests
    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Sphere(0));
        assertThrows(IllegalArgumentException.class, () -> new Sphere(-5.0));
    }

    @Test
    void testInvalidSetter() {
        Sphere sphere = new Sphere(5.0);
        assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(0));
        assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(-10.0));
    }

    // Inheritance Testing
    @Test
    void testPolymorphism() {
        Shape3D sphere = new Sphere(5.0);
        assertTrue(sphere instanceof ThreeDimensionalShape);
        assertEquals((4.0 / 3.0) * Math.PI * Math.pow(5.0, 3), sphere.getVolume());
        assertEquals(4 * Math.PI * Math.pow(5.0, 2), sphere.getSurfaceArea());
        assertEquals("Sphere", ((Sphere) sphere).getName());
    }

    @Test
    void testToString() {
        Sphere sphere = new Sphere(5.0);
        String expected = "Sphere{" +
                "name='" + "Sphere" + '\'' +
                ", color='" + "Green" + '\'' +
                ", radius=" + 5.0 +
                '}';
        assertEquals(expected, sphere.toString());
    }
}
