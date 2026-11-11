package payrollmanagementsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class  PayrollManagementSystem {

    public static void main(String[] args) {

        
        List<Employee> employees = new ArrayList<>();

      
        employees.add(new FullTimeEmployee(
                "E01",
                "Abrar",
                5000,
                LocalDate.of(2022, 3, 10),
                1000
        ));

        employees.add(new FullTimeEmployee(
                "E02",
                "Sara",
                4000,
                LocalDate.of(2020, 5, 15),
                800
        ));

        
        employees.add(new ContractorEmployee(
                "E03",
                "Ali",
                LocalDate.of(2023, 1, 20),
                50,
                100
        ));

        employees.add(new ContractorEmployee(
                "E04",
                "Omar",
                LocalDate.of(2019, 7, 1),
                60,
                100
        ));

        
        double[] performanceScores = {4.5, 3.5, 4.2, 3.0};

        
        Collections.sort(employees);

        System.out.println("===== Employees Sorted by Net Salary =====");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        double totalTaxes = 0;
        double totalBonuses = 0;

        for (int i = 0; i < employees.size(); i++) {

            Employee employee = employees.get(i);

            totalTaxes += employee.calculateTax();

            totalBonuses += employee.calculateBonus(
                    performanceScores[i]
            );
        }

        System.out.println();
        System.out.println("===== Payroll Summary =====");

        System.out.printf("Total Taxes: %.2f%n", totalTaxes);
        System.out.printf("Total Bonuses: %.2f%n", totalBonuses);

        employees.sort(
                Comparator.comparing(Employee::getJoinDate)
        );

        System.out.println();
        System.out.println("===== Employees Sorted by Join Date =====");

        for (Employee employee : employees) {

            System.out.println(
                    employee.getName()
                    + " - "
                    + employee.getJoinDate()
            );
        }
    }
}