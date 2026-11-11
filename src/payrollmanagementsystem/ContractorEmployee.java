package payrollmanagementsystem;

import java.time.LocalDate;

public class ContractorEmployee extends Employee {

    private int hourlyRate;
    private int hoursWorked;

    public ContractorEmployee(String id, String name,
                              LocalDate joinDate,
                              int hourlyRate,
                              int hoursWorked) {

        super(id, name, 0, joinDate);

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateNetSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus(double performanceScore) {

        if (performanceScore < 1.0 || performanceScore > 5.0) {
            throw new IllegalArgumentException(
                    "Performance score must be between 1.0 and 5.0"
            );
        }

        if (performanceScore > 4.0) {
            return 500.0;
        }

        return 0.0;
    }
}