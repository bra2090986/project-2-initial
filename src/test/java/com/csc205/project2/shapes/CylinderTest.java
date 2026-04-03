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

class CylinderTest {

    // Basic Functionality Tests
    @Test
    void testConstructorAndGetters() {
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        assertEquals(3.0, cylinder.getRadius());
        assertEquals(7.0, cylinder.getHeight());
        assertEquals("Cylinder", cylinder.getName());
        assertEquals("Red", cylinder.getColor());
    }

    @Test
    void testSetters() {
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        cylinder.setRadius(4.0);
        cylinder.setHeight(8.0);
        assertEquals(4.0, cylinder.getRadius());
        assertEquals(8.0, cylinder.getHeight());
    }

    // Calculation Accuracy Tests
    @Test
    void testGetVolume() {
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        double expectedVolume = Math.PI * Math.pow(3.0, 2) * 7.0;
        assertEquals(expectedVolume, cylinder.getVolume());
    }

    @Test
    void testGetSurfaceArea() {
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        double expectedSurfaceArea = (2 * Math.PI * 3.0 * 7.0) + (2 * Math.PI * Math.pow(3.0, 2));
        assertEquals(expectedSurfaceArea, cylinder.getSurfaceArea());
    }

    // Boundary Testing
    @Test
    void testBoundaryValues() {
        Cylinder smallCylinder = new Cylinder(1e-6, 1e-6);
        assertTrue(smallCylinder.getVolume() > 0);
        assertTrue(smallCylinder.getSurfaceArea() > 0);

        Cylinder largeCylinder = new Cylinder(1e6, 1e6);
        assertEquals(Math.PI * Math.pow(1e6, 2) * 1e6, largeCylinder.getVolume());
        assertEquals((2 * Math.PI * 1e6 * 1e6) + (2 * Math.PI * Math.pow(1e6, 2)), largeCylinder.getSurfaceArea());
    }

    // Input Validation Tests
    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(0, 7.0));
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(3.0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(-3.0, 7.0));
        assertThrows(IllegalArgumentException.class, () -> new Cylinder(3.0, -7.0));
    }

    @Test
    void testInvalidSetters() {
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(0));
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(0));
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(-4.0));
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(-8.0));
    }

    // Inheritance Testing
    @Test
    void testPolymorphism() {
        Shape3D cylinder = new Cylinder(3.0, 7.0);
        assertTrue(cylinder instanceof ThreeDimensionalShape);
        assertEquals(Math.PI * Math.pow(3.0, 2) * 7.0, cylinder.getVolume());
        assertEquals((2 * Math.PI * 3.0 * 7.0) + (2 * Math.PI * Math.pow(3.0, 2)), cylinder.getSurfaceArea());
        assertEquals("Cylinder", ((Cylinder) cylinder).getName());
    }

    @Test
    void testToString() {
        Cylinder cylinder = new Cylinder(3.0, 7.0);
        String expected = "Cylinder{" +
                "name='" + "Cylinder" + '\'' +
                ", color='" + "Red" + '\'' +
                ", radius=" + 3.0 +
                ", height=" + 7.0 +
                '}';
        assertEquals(expected, cylinder.toString());
    }
}
