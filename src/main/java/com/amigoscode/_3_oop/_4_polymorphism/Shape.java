package com.amigoscode._3_oop._4_polymorphism;

public abstract class Shape {
    public abstract double area();

    @Override
    public String toString() {
        return "Shape[area="+String.format("%.2f",area())+"]";
    }
}
