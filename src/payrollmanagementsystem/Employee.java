package payrollmanagementsystem;

import java.time.LocalDate;

public abstract class Employee
        implements Taxable, BonusCalculable, Comparable<Employee> {

    private String id;
    private String name;
    protected double baseSalary;
    private LocalDate joinDate;

    public Employee(String id, String name,
                    double baseSalary, LocalDate joinDate) {

        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
    }

    public abstract double calculateNetSalary();

    @Override
    public double calculateTax() {
        return calculateNetSalary() * TAX_RATE;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(
                other.calculateNetSalary(),
                this.calculateNetSalary()
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Net Salary: " + calculateNetSalary()
                + ", Tax: " + calculateTax();
    }
}