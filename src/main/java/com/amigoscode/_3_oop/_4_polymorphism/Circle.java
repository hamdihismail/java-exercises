package com.amigoscode._3_oop._4_polymorphism;

public class Circle extends Shape{
    private double radius;
    Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * (Math.pow(radius,2));
    }
}
