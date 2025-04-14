
package com.example.salary;

import java.util.Scanner;

public class EmployeeSalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter hourly rate: ");
        double hourlyRate = scanner.nextDouble();

        System.out.print("Enter number of hours worked per week: ");
        double hoursWorked = scanner.nextDouble();

        // Calculate weekly salary
        double weeklySalary;
        if (hoursWorked <= 40) {
            weeklySalary = hoursWorked * hourlyRate;
        } else {
            double overtimeHours = hoursWorked - 40;
            weeklySalary = (40 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
        }

        // Monthly salary = weekly salary * 4
        double monthlySalary = weeklySalary * 4;

        // Deduct 10% tax
        double netSalary = monthlySalary - (monthlySalary * 0.10);

        // Output
        System.out.printf("Net Monthly Salary after 10%% tax: ₹%.2f%n", netSalary);

        scanner.close();
    }
}
