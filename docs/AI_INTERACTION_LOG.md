# AI Interaction Log

This document serves as a log of interactions with AI systems, capturing prompts, responses, and reflections on the outcomes. It is intended to help users track their engagements with AI and improve future interactions.

## Driver

Create a sophisticated `ShapeDriver.java` that demonstrates:

- **Polymorphism**: Array/List of Shape3D references holding different shapes
- **Comparative Analysis**: Which shape has the largest volume for given constraints?
- **Interactive Features**: Allow user to create shapes with custom parameters
- **Performance Timing**: Measure calculation speeds (optional)
- **Formatted Output**: Professional presentation of results

**Sample Output Format:**
```
=== 3D Shape Analysis System ===

Created Shapes:
1. Sphere {name='Red Ball', radius=5.0}
   - Surface Area: 314.16 square units
   - Volume: 523.60 cubic units

2. Cube {name='Blue Box', side=4.0}
   - Surface Area: 96.00 square units
   - Volume: 64.00 cubic units

[... other shapes ...]

- "[Refinement prompt 1]" Repeat to generate additional shapes or quit
- "[Refinement prompt 2]" there shouldn't be any shapes until the user inputs them
- "[Refinement prompt 3]" take a name property from user, then display property of Color Name


## Class 1+
Create `Shape3D.java` with these requirements:

**Must Include:**
- Implements the `ThreeDimensionalShape` interface
- Concrete implementations of `getVolume()` and `getSurfaceArea()` that call the abstract methods
- Common properties: `name` (String), `color` (String)  (Properties in Java are typically private fields with public getters and setters)
- Constructor(s) for initialization
- `toString()` method that formats output consistently
- Getter/setter methods as appropriate

Generate complete JUnit tests

## Class 2

Generate the following shapes using AI assistance:

1. **Sphere** - Properties: radius
2. **Cube** - Properties: sideLength
3. **Cylinder** - Properties: radius, height
4. **RectangularPrism** - Properties: length, width, height
5. **[Your Choice]** - Select any 3D geometric shape (examples: Cone, Pyramid, Torus, Ellipsoid, Octahedron)

**For Each Shape Class:**
- Extends Shape3D (which implements ThreeDimensionalShape)
- Implement the abstract methods from ThreeDimensionalShape
- Include proper constructors with validation
- Override `toString()` with shape-specific formatting
- Add any shape-specific methods if needed

Generate complete JUnit tests for each shape with mathmatical formula testing