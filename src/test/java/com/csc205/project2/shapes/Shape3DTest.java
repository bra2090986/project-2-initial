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
 * 1. "[Refinement prompt 1]" None
 *
 * Manual Modifications:
 * - [List any changes you made to the AI output] None
 * - [Explain why changes were necessary]
 */

package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Shape3DTest {

    // Concrete class for testing purposes
    class TestShape3D extends Shape3D {
        public TestShape3D() {
            super();
        }

        public TestShape3D(String name, String color) {
            super(name, color);
        }

        @Override
        public double getVolume() {
            return 10.0; // Dummy value
        }

        @Override
        public double getSurfaceArea() {
            return 20.0; // Dummy value
        }
    }

    @org.testng.annotations.Test
    void testDefaultConstructor() {
        TestShape3D shape = new TestShape3D();
        assertEquals("Shape3D", shape.getName());
        assertEquals("Gray", shape.getColor());
    }

    @Test
    void testParameterizedConstructor() {
        TestShape3D shape = new TestShape3D("MyShape", "Blue");
        assertEquals("MyShape", shape.getName());
        assertEquals("Blue", shape.getColor());
    }

    @Test
    void testGettersAndSetters() {
        TestShape3D shape = new TestShape3D();
        shape.setName("NewName");
        shape.setColor("Red");
        assertEquals("NewName", shape.getName());
        assertEquals("Red", shape.getColor());
    }

    @Test
    void testGetVolume() {
        TestShape3D shape = new TestShape3D();
        assertEquals(10.0, shape.getVolume());
    }

    @Test
    void testGetSurfaceArea() {
        TestShape3D shape = new TestShape3D();
        assertEquals(20.0, shape.getSurfaceArea());
    }

    @Test
    void testToString() {
        TestShape3D shape = new TestShape3D("MyShape", "Blue");
        String expected = "Shape3D{" +
                "name='" + "MyShape" + '\'' +
                ", color='" + "Blue" + '\'' +
                '}';
        assertEquals(expected, shape.toString());
    }
}
