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
 * 2. "[Refinement prompt 2]"
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

class ConeTest {

    // Basic Functionality Tests
    @Test
    void testConstructorAndGetters() {
        Cone cone = new Cone(3.0, 4.0);
        assertEquals(3.0, cone.getRadius());
        assertEquals(4.0, cone.getHeight());
        assertEquals("Cone", cone.getName());
        assertEquals("Yellow", cone.getColor());
    }

    @Test
    void testSetters() {
        Cone cone = new Cone(3.0, 4.0);
        cone.setRadius(5.0);
        cone.setHeight(6.0);
        assertEquals(5.0, cone.getRadius());
        assertEquals(6.0, cone.getHeight());
    }

    // Calculation Accuracy Tests
    @Test
    void testGetVolume() {
        Cone cone = new Cone(3.0, 4.0);
        double expectedVolume = Math.PI * Math.pow(3.0, 2) * (4.0 / 3.0);
        assertEquals(expectedVolume, cone.getVolume());
    }

    @Test
    void testGetSurfaceArea() {
        Cone cone = new Cone(3.0, 4.0);
        double slantHeight = Math.sqrt(Math.pow(3.0, 2) + Math.pow(4.0, 2));
        double expectedSurfaceArea = Math.PI * 3.0 * (3.0 + slantHeight);
        assertEquals(expectedSurfaceArea, cone.getSurfaceArea());
    }

    // Boundary Testing
    @Test
    void testBoundaryValues() {
        Cone smallCone = new Cone(1e-6, 1e-6);
        assertTrue(smallCone.getVolume() > 0);
        assertTrue(smallCone.getSurfaceArea() > 0);

        Cone largeCone = new Cone(1e6, 1e6);
        assertEquals(Math.PI * Math.pow(1e6, 2) * (1e6 / 3.0), largeCone.getVolume());
        double slantHeight = Math.sqrt(Math.pow(1e6, 2) + Math.pow(1e6, 2));
        assertEquals(Math.PI * 1e6 * (1e6 + slantHeight), largeCone.getSurfaceArea());
    }

    // Input Validation Tests
    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Cone(0, 4.0));
        assertThrows(IllegalArgumentException.class, () -> new Cone(3.0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Cone(-3.0, 4.0));
    }

    @Test
    void testInvalidSetters() {
        Cone cone = new Cone(3.0, 4.0);
        assertThrows(IllegalArgumentException.class, () -> cone.setRadius(0));
        assertThrows(IllegalArgumentException.class, () -> cone.setHeight(0));
        assertThrows(IllegalArgumentException.class, () -> cone.setRadius(-5.0));
    }

    // Inheritance Testing
    @Test
    void testPolymorphism() {
        Shape3D cone = new Cone(3.0, 4.0);
        assertTrue(cone instanceof ThreeDimensionalShape);
        assertEquals(Math.PI * Math.pow(3.0, 2) * (4.0 / 3.0), cone.getVolume());
        double slantHeight = Math.sqrt(Math.pow(3.0, 2) + Math.pow(4.0, 2));
        assertEquals(Math.PI * 3.0 * (3.0 + slantHeight), cone.getSurfaceArea());
        assertEquals("Cone", ((Cone) cone).getName());
    }

    @Test
    void testToString() {
        Cone cone = new Cone(3.0, 4.0);
        String expected = "Cone{" +
                "name='" + "Cone" + '\'' +
                ", color='" + "Yellow" + '\'' +
                ", radius=" + 3.0 +
                ", height=" + 4.0 +
                '}';
        assertEquals(expected, cone.toString());
    }
}
