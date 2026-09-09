package com.amigoscode._2_developers._10_exceptions;

/**
 * Custom Exception Exercises
 *
 * Practice creating custom checked and unchecked exceptions, throwing them
 * from methods, catching them, and using exception chaining.
 */
public class CustomException {

    // TODO: 1 - Create a custom CHECKED exception class called InsufficientFundsException.
    //  It should:
    //  - Extend Exception (making it a checked exception)
    //  - Have a private final double 'amount' field (the amount that was short)
    //  - Have a constructor that takes a String message and double amount,
    //    calls super(message), and stores the amount
    //  - Have a getter: double getAmount()
    //  Define it as a static inner class here, or as a separate class in this package.
    static class InsufficientFundsException extends Exception{
        private final double amount;

        public double getAmount() {
            return amount;
        }

        InsufficientFundsException(String message, double amount) {
            super(message);
            this.amount = amount;
        }
    }


    // TODO: 2 - Create a custom UNCHECKED exception class called InvalidAgeException.
    //  It should:
    //  - Extend RuntimeException (making it an unchecked exception)
    //  - Have a constructor that takes a String message and calls super(message)
    //  - Have a constructor that takes a String message and a Throwable cause,
    //    and calls super(message, cause)
    //  Define it as a static inner class here.

    static class InvalidAgeException extends RuntimeException{
        InvalidAgeException(String message){
            super(message);
        }
        InvalidAgeException(String message, Throwable cause){
            super(message,cause);
        }
    }


    // TODO: 3 - Create a static inner class BankAccount with:
    //  - A private double 'balance' field
    //  - A constructor that takes an initial balance
    //  - A method: void withdraw(double amount) throws InsufficientFundsException
    //    If amount > balance, throw new InsufficientFundsException with an appropriate
    //    message and the shortfall amount (amount - balance).
    //    Otherwise, subtract amount from balance.
    //  - A method: double getBalance()
    static class BankAccount{
        private double balance;

        public double getBalance() {
            return balance;
        }

        BankAccount(double balance){
            this.balance = balance;
        }

        public void withdraw(double amount) throws InsufficientFundsException{
            if(amount > balance){
                throw new InsufficientFundsException("Amount requested exceeds balance!",(amount - balance));
            }
            balance -= amount;
        }
    }


    // TODO: 4 - Create a static method: void validateAge(int age)
    //  If age < 0 or age > 150, throw a new InvalidAgeException with an appropriate message.
    //  Otherwise, print "Age " + age + " is valid."
    static void validateAge(int age){
        if(age < 0 || age > 150){
            throw  new InvalidAgeException("Age entered is invalid!");
        }
        System.out.println("Age " + age + " is valid.");
    }


    public static void main(String[] args) {
        System.out.println("=== Custom Checked Exception (InsufficientFundsException) ===");
        // TODO: 5 - Create a BankAccount with balance 100.
        //  Try to withdraw 50 (should succeed, print remaining balance).
        //  Try to withdraw 75 (should throw InsufficientFundsException).
        //  Catch the exception and print its message and the shortage amount.
        //  Also try validateAge with valid (25) and invalid (-5) values,
        //  catching InvalidAgeException.
        BankAccount bankAccount = new BankAccount(100);
        try {
            bankAccount.withdraw(50);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            bankAccount.withdraw(75);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            validateAge(25);
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
        try {
            validateAge(-5);
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }


        System.out.println("\n=== Exception Chaining ===");
        // TODO: 6 - Demonstrate exception chaining:
        //  In a try block, parse an invalid string like "abc" with Integer.parseInt().
        //  In the catch block for NumberFormatException, create a new InvalidAgeException
        //  with the original exception as the cause (using the two-arg constructor
        //  or initCause()). Throw the new exception.
        //  In an outer try-catch, catch the InvalidAgeException and print:
        //  - The exception message
        //  - The cause (using getCause())
        try {
            try {
                Integer.parseInt("abc");
            } catch (NumberFormatException e){
                throw new InvalidAgeException(e.getMessage(),e.initCause(e.getCause()));
            }
        } catch (InvalidAgeException e){
            System.out.println("Message: "+e.getMessage()+"\nCause: "+e.getCause());
        }

    }
}
