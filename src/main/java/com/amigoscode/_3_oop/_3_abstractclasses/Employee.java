package com.amigoscode._3_oop._3_abstractclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Abstract Classes - Employee Hierarchy
 *
 * Build an employee hierarchy using abstract classes. The abstract Employee
 * defines common behavior, while FullTimeEmployee and ContractEmployee
 * provide different pay calculation strategies.
 *
 * Key concepts:
 * - Abstract class with both abstract and concrete methods
 * - Multiple subclasses with different implementations
 * - Polymorphism with a List of the abstract type
 * - Inner classes (classes defined in the same file)
 */

// TODO: 1 - Make the Employee class abstract. Add two protected fields:
//   - name (String)
//   - baseSalary (double)
//   Create a constructor that takes both fields and assigns them.
abstract class Employee {
    protected String name;
    protected double baseSalary;
    Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }
    // TODO: 2 - Declare an abstract method: double calculatePay()
    //   Each subclass will compute pay differently.
    abstract double calculatePay();

    // TODO: 3 - Create a concrete method: String getDetails()
    //   Return: "<name> - Pay: $<calculatePay()>"
    //   Use String.format("%.2f", calculatePay()) for formatting.
    public String getDetails(){
        return name+" - Pay: $"+calculatePay();
    }
}

// TODO: 4 - Create a FullTimeEmployee class that extends Employee.
//   - Constructor takes name and baseSalary, calls super(name, baseSalary)
//   - Implement calculatePay() to simply return baseSalary
    class FullTimeEmployee extends Employee{
    FullTimeEmployee(String name, double baseSalary){
        super(name, baseSalary);
    }
    public double calculatePay(){
        return baseSalary;
    }
}

// TODO: 5 - Create a ContractEmployee class that extends Employee.
//   - Add two private fields: hourlyRate (double) and hoursWorked (int)
//   - Constructor takes name, hourlyRate, and hoursWorked
//     (pass name and 0.0 as baseSalary to super)
//   - Implement calculatePay() to return hourlyRate * hoursWorked
class ContractEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;
    ContractEmployee(String name, double hourlyRate, int hoursWorked){
        super(name,0.0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay(){
        return hourlyRate * hoursWorked;
    }
}


// TODO: 6 - In the EmployeeDemo class below, complete the main method:
//   - Create a List<Employee> with at least one FullTimeEmployee
//     and one ContractEmployee
//   - Iterate over the list and print getDetails() for each employee

// TODO: 7 - Add a method in EmployeeDemo: static Employee getHighestPaid(List<Employee> employees)
//   that returns the employee with the highest calculatePay() value.
//   Call it from main and print the result.

class EmployeeDemo {
        static Employee getHighestPaid(List<Employee> employees){
            Employee highest = null;
            for(Employee emp: employees){
                if(highest != null){
                    if(emp.calculatePay()>highest.calculatePay()){
                        highest = emp;
                    }
                } else{
                    highest = emp;
                }
            }
            return highest;
        }
    public static void main(String[] args) {
        // Complete TODOs 6 and 7 here
        List<Employee> list = new ArrayList<>();
        Employee fullTimeEmployee = new FullTimeEmployee("Adam",20000);
        Employee contractEmployee = new ContractEmployee("Jamal",30,40);
        list.add(fullTimeEmployee);
        list.add(contractEmployee);
        list.forEach((employee)-> System.out.println(employee.getDetails()));
        System.out.println("Highest Paid: "+getHighestPaid(list).getDetails());

    }
}
