package com.amigoscode._3_oop._4_polymorphism;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Polymorphism - Shape Calculator
 *
 * Use polymorphism to write methods that work with any Shape.
 * Because Circle and Rectangle both extend Shape, a single method
 * can handle both — and any future Shape subclass — without modification.
 *
 * Key concepts:
 * - Methods that accept a supertype parameter
 * - Polymorphic collections (List<Shape>)
 * - instanceof with pattern matching (Java 16+)
 * - Open/closed principle in practice
 *
 * Prerequisites: Complete Shape.java, Circle.java, and Rectangle.java first.
 */
public class ShapeCalculator {

    // TODO: 1 - Create a method: void printShapeArea(Shape shape)
    //   Print: "The <className> has an area of <area>"
    //   Use shape.getClass().getSimpleName() to get the class name.
    //   Use String.format("%.2f", shape.area()) for formatting.
    public void printShapeArea(Shape shape){
        System.out.println("The "+shape.getClass().getSimpleName()+" has an area of "+String.format("%.2f",shape.area()));
    }

    // TODO: 2 - Create a method: double totalArea(List<Shape> shapes)
    //   Iterate over all shapes and return the sum of their areas.
    public double totalArea(List<Shape> shapes){
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }


    // TODO: 3 - Create a method: Shape largestShape(List<Shape> shapes)
    //   Return the shape with the largest area.
    //   If the list is empty, return null.
    public Shape largestShape(List<Shape> shapes){
        Shape largest = null;
        for (Shape shape : shapes) {
           if(largest!=null){
               if(largest.area()<shape.area()){
                   largest = shape;
               }
           } else {
               largest = shape;
           }
        }
        return largest;
    }


    // TODO: 4 - Create a method: String describeShape(Shape shape)
    //   Use instanceof with pattern matching (Java 16+) to return
    //   specific descriptions:
    //   - If shape is a Circle c: return "Circle with radius info"
    //     (just return "Circle detected with area: " + c.area())
    //   - If shape is a Rectangle r: return "Rectangle detected with area: " + r.area()
    //   - Otherwise: return "Unknown shape with area: " + shape.area()
    public String describeShape(Shape shape){
        if(shape instanceof Circle){
            return "Circle detected with area: " + shape.area();
        }
        if(shape instanceof Rectangle){
            return "Rectangle detected with area: " + shape.area();
        }
        return "Unknown shape with area: " + shape.area();
    }


    // TODO: 5 - Create a method: String formatSummary(List<Shape> shapes)
    //   Return a formatted summary string like:
    //   "Summary: <N> shapes, total area: <totalArea>, largest area: <largestArea>"
    //   Use the totalArea() and largestShape() methods you already wrote.
    public String formatSummary(List<Shape> shapes){
        return "Summary: "+shapes.size()+" shapes, total area: "+totalArea(shapes)+", largest area: "+largestShape(shapes).toString();
    }


    // TODO: 6 - In main, create a List<Shape> with at least two Circles
    //   and two Rectangles. Call all the methods above and print results.
    //   This demonstrates polymorphism: the same method handles
    //   different shape types seamlessly.

    public static void main(String[] args) {
        // Complete TODO 6 here.
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(33));
        shapes.add(new Circle(50));
        shapes.add(new Rectangle(25,15));
        shapes.add(new Rectangle(77,45));

        ShapeCalculator shapeCalculator = new ShapeCalculator();
        shapes.forEach(shape -> {
            System.out.println(shapeCalculator.describeShape(shape));
            shapeCalculator.printShapeArea(shape);
        });
        System.out.println(shapeCalculator.formatSummary(shapes));
    }
}
