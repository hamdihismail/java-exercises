package com.amigoscode._2_developers._12_classes;

/**
 * Enum Exercises
 *
 * Practice creating and using enums in Java. Enums are special classes that
 * represent a fixed set of constants. They can have fields, constructors,
 * and methods just like regular classes.
 */
public class EnumExercises {

    // TODO: 1 - Create an enum called Season with four constants:
    //  SPRING, SUMMER, AUTUMN, WINTER
    //  For now, just declare them without any fields or methods.
    enum Season{
        SPRING("Flowers bloom"),
        SUMMER("Sun shines"),
        AUTUMN("Leaves fall"),
        WINTER("Snow falls");

        private final String description;
        Season(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }
    }

    // TODO: 2 - Modify the Season enum to add:
    //  - A private final String 'description' field
    //  - A constructor that takes a String description and assigns it
    //  - Update each constant to pass a description, e.g.:
    //    SPRING("Flowers bloom"), SUMMER("Sun shines"),
    //    AUTUMN("Leaves fall"), WINTER("Snow falls")
    //  Note: Enum constructors are always private (even without the keyword).


    // TODO: 3 - Add a method getDescription() to the Season enum that
    //  returns the description field.


    // TODO: 4 - Create an enum called Priority with three constants:
    //  LOW(1), MEDIUM(2), HIGH(3)
    //  Each constant has a numeric level.
    //  Add:
    //  - A private final int 'level' field
    //  - A constructor that takes an int level
    //  - A getter getLevel()
    enum Priority{
        LOW(1),
        MEDIUM(2),
        HIGH(3);
        private final int level;

        public int getLevel() {
            return level;
        }

        Priority(int level) {
            this.level = level;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Season Switch ===");
        // TODO: 5 - Use a switch statement (or switch expression) with a Season value.
        //  For each season, print a message like "Spring: Flowers bloom"
        //  using the getDescription() method.
        //  Test with Season.SUMMER.
        switch (Season.SUMMER){
            case AUTUMN -> System.out.println("Autumn: "+Season.AUTUMN.getDescription());
            case WINTER -> System.out.println("Winter: "+Season.WINTER.getDescription());
            case SPRING -> System.out.println("Spring: "+Season.SPRING.getDescription());
            case SUMMER -> System.out.println("Summer: "+Season.SUMMER.getDescription());
        }

        System.out.println("\n=== Iterate Over Enum Values ===");
        // TODO: 6 - Use Season.values() to get an array of all Season constants.
        //  Loop through them and print each one with its description and ordinal.
        //  Example output: "0: SPRING - Flowers bloom"
        //  Also iterate over Priority.values() and print each with its level.
        for (Season season : Season.values()) {
            System.out.println(season.ordinal()+": "+season.name()+" - "+season.getDescription());
        }
    }
}
