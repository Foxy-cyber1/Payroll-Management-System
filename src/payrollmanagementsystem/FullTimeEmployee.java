package payrollmanagementsystem;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {

    private double allowance;

    public FullTimeEmployee(String id, String name,
                            double baseSalary,
                            LocalDate joinDate,
                            double allowance) {

        super(id, name, baseSalary, joinDate);
        this.allowance = allowance;
    }

    @Override
    public double calculateNetSalary() {
        return baseSalary + allowance;
    }

    @Override
    public double calculateBonus(double performanceScore) {

        if (performanceScore < 1.0 || performanceScore > 5.0) {
            throw new IllegalArgumentException(
                    "Performance score must be between 1.0 and 5.0"
            );
        }

        return baseSalary * 0.10 * performanceScore;
    }
}