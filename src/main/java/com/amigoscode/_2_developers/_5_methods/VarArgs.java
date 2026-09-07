package com.amigoscode._2_developers._5_methods;

import java.util.Arrays;

/**
 * Variable Arguments (Varargs) Exercises
 *
 * Practice using the varargs syntax (Type... name) which allows methods to accept
 * zero or more arguments of the same type. Internally, varargs are treated as arrays.
 */
public class VarArgs {

    // TODO: 1 - Create a method: int sum(int... numbers)
    //  Returns the sum of all provided numbers.
    //  If no arguments are provided, return 0.
    //  Hint: use a for-each loop to iterate over 'numbers'.
    public int sum(int... numbers){
        int result = 0;
        if(numbers.length > 0){
            for (int number : numbers) {
                result += number;
            }
        }
        return result;
    }


    // TODO: 2 - Create a method: String concatenate(String... strings)
    //  Joins all strings with a single space between them.
    //  Example: concatenate("Hello", "World") returns "Hello World"
    //  If no arguments, return an empty string "".
    //  Hint: use StringBuilder or String.join(" ", strings).
    public String concatenate(String... strings){
        String result = "";
        if(strings.length > 0){
            result = String.join(" ",strings);
        }
        return result;
    }


    // TODO: 3 - Create a method: int findMax(int... numbers)
    //  Returns the largest value among the arguments.
    //  If no arguments are provided, throw an IllegalArgumentException
    //  with the message "At least one number required".
    public int findMax(int... numbers){
        int result = 0;
        if(numbers.length == 0){
            throw new IllegalArgumentException("At least one number required");
        }
        for (int number : numbers) {
            result = Math.max(result,number);
        }
        return result;
    }

    // TODO: 4 - Create a method: void printAll(Object... items)
    //  Prints each item on a separate line, prefixed with its index.
    //  Example output:
    //    [0] Hello
    //    [1] 42
    //    [2] true
    public void printAll(Object... items){
        for (int i = 0; i < items.length; i++) {
            System.out.println("["+i+"] "+items[i]);
        }
    }

    // TODO: 6 - Create a method: String format(String prefix, int... numbers)
    //  The first parameter is a regular String, followed by varargs.
    //  Returns the prefix followed by the numbers in brackets.
    //  Example: format("Values", 1, 2, 3) returns "Values: [1, 2, 3]"
    //  Hint: varargs must be the LAST parameter in the method signature.
    public String format(String prefix, int... numbers){
        return prefix+": "+ Arrays.toString(numbers);
    }


    public static void main(String[] args) {
        VarArgs va = new VarArgs();

        System.out.println("=== Sum ===");
        // TODO: 5 - Demonstrate calling sum() with different numbers of arguments:
        //  - sum()           -> 0  (zero args)
        //  - sum(5)          -> 5  (one arg)
        //  - sum(1, 2, 3, 4) -> 10 (many args)
        //  Print each result.
        System.out.println("sum()           -> 0  (zero args): "+va.sum());
        System.out.println("sum(5)          -> 5  (one arg): "+va.sum(5));
        System.out.println("sum(1, 2, 3, 4) -> 10 (many args): "+va.sum(1,2,3,4));


        System.out.println("\n=== Concatenate ===");
        // Print: concatenate("Java", "is", "awesome")
        System.out.println(va.concatenate("Java", "is", "awesome"));

        System.out.println("\n=== Find Max ===");
        // Print: findMax(3, 7, 2, 9, 1)
        System.out.println(va.findMax(3,7,2,9,1));

        System.out.println("\n=== Print All ===");
        // Call: printAll("Hello", 42, true, 3.14)
        va.printAll("Hello", 42, true, 3.14);
//
        System.out.println("\n=== Mixed Params ===");
        // TODO: 6 - Create a method: String format(String prefix, int... numbers)
        //  The first parameter is a regular String, followed by varargs.
        //  Returns the prefix followed by the numbers in brackets.
        //  Example: format("Values", 1, 2, 3) returns "Values: [1, 2, 3]"
        //  Hint: varargs must be the LAST parameter in the method signature.
        //  Then call the method and print the result here.
        System.out.println(va.format("Values", 1, 2, 3));

    }
}
