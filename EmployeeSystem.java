// Base Class: The Parent
class Employee {
    double salary;

    // Method to display the salary - shared by all children
    void displaySalary() {
        System.out.println("Salary: " + salary);
    }
}

// Derived Class 1: Inherits from Employee
class FullTimeEmployee extends Employee {
    // Unique method for this class
    void calculateSalary() {
        // Apply a 50% hike (salary * 1.5)
        salary = salary * 1.5; 
    }
}

// Derived Class 2: Also inherits from Employee
class InternEmployee extends Employee {
    // Unique method for this class
    void calculateSalary() {
        // Apply a 25% hike (salary * 1.25)
        salary = salary * 1.25;
    }
}

// Main class to execute the logic
public class EmployeeSystem {
    public static void main(String[] args) {
        
        // 1. Working with the Full-Time Employee
        System.out.println("--- Full-Time Employee Record ---");
        FullTimeEmployee ft = new FullTimeEmployee();
        ft.salary = 50000; // Initializing inherited variable
        
        System.out.print("Before Hike: ");
        ft.displaySalary(); // Calling inherited method
        
        ft.calculateSalary(); // Applying 50% hike
        
        System.out.print("After 50% Hike: ");
        ft.displaySalary();

        System.out.println(); // Just for a clean break in output

        // 2. Working with the Intern Employee
        System.out.println("--- Intern Employee Record ---");
        InternEmployee intern = new InternEmployee();
        intern.salary = 20000; // Initializing inherited variable
        
        System.out.print("Before Hike: ");
        intern.displaySalary(); // Calling inherited method
        
        intern.calculateSalary(); // Applying 25% hike
        
        System.out.print("After 25% Hike: ");
        intern.displaySalary();
    }
}