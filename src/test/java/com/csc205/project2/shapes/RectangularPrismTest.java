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

class RectangularPrismTest {

    // Basic Functionality Tests
    @Test
    void testConstructorAndGetters() {
        RectangularPrism prism = new RectangularPrism(3.0, 4.0, 5.0);
        assertEquals(3.0, prism.getLength());
        assertEquals(4.0, prism.getWidth());
        assertEquals(5.0, prism.getHeight());
        assertEquals("Rectangular Prism", prism.getName());
        assertEquals("Purple", prism.getColor());
    }

    @Test
    void testSetters() {
        RectangularPrism prism = new RectangularPrism(3.0, 4.0, 5.0);
        prism.setLength(6.0);
        prism.setWidth(7.0);
        prism.setHeight(8.0);
        assertEquals(6.0, prism.getLength());
        assertEquals(7.0, prism.getWidth());
        assertEquals(8.0, prism.getHeight());
    }

    // Calculation Accuracy Tests
    @Test
    void testGetVolume() {
        RectangularPrism prism = new RectangularPrism(3.0, 4.0, 5.0);
        assertEquals(60.0, prism.getVolume());
    }

    @Test
    void testGetSurfaceArea() {
        RectangularPrism prism = new RectangularPrism(3.0, 4.0, 5.0);
        assertEquals(94.0, prism.getSurfaceArea());
    }

    // Boundary Testing
    @Test
    void testBoundaryValues() {
        RectangularPrism smallPrism = new RectangularPrism(1e-6, 1e-6, 1e-6);
        assertTrue(smallPrism.getVolume() > 0);
        assertTrue(smallPrism.getSurfaceArea() > 0);

        RectangularPrism largePrism = new RectangularPrism(1e6, 1e6, 1e6);
        assertEquals(1e18, largePrism.getVolume(), 1e-9);
        assertEquals(6e12, largePrism.getSurfaceArea(), 1e-9);
    }

    // Input Validation Tests
    @Test
    void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism(0, 4.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism(3.0, 0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism(3.0, 4.0, 0));
        assertThrows(IllegalArgumentException.class, () -> new RectangularPrism(-3.0, 4.0, 5.0));
    }

    @Test
    void testInvalidSetters() {
        RectangularPrism prism = new RectangularPrism(3.0, 4.0, 5.0);
        assertThrows(IllegalArgumentException.class, () -> prism.setLength(0));
        assertThrows(IllegalArgumentException.class, () -> prism.setWidth(0));
        assertThrows(IllegalArgumentException.class, () -> prism.setHeight(0));
        assertThrows(IllegalArgumentException.class, () -> prism.setLength(-6.0));
    }

    // Inheritance Testing
    @Test
    void testPolymorphism() {
        Shape3D prism = new RectangularPrism(3.0, 4.0, 5.0);
        assertTrue(prism instanceof ThreeDimensionalShape);
        assertEquals(60.0, prism.getVolume());
        assertEquals(94.0, prism.getSurfaceArea());
        assertEquals("Rectangular Prism", ((RectangularPrism) prism).getName());
    }

    @Test
    void testToString() {
        RectangularPrism prism = new RectangularPrism(3.0, 4.0, 5.0);
        String expected = "RectangularPrism{" +
                "name='" + "Rectangular Prism" + '\'' +
                ", color='" + "Purple" + '\'' +
                ", length=" + 3.0 +
                ", width=" + 4.0 +
                ", height=" + 5.0 +
                '}';
        assertEquals(expected, prism.toString());
    }
}
