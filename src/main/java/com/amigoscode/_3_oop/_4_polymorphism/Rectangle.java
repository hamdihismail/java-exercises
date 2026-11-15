package com.amigoscode._3_oop._4_polymorphism;

public class Rectangle extends Shape{
    private double length;
    private double width;
    Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    @Override
    public double area() {
        return length * width;
    }
}
