package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

public class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus) {
        for (int i = 0; i < this.employees.length; i++) {
            this.employees[i].setBonus(companyBonus);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < this.employees.length; i++) {
            total = total.add(this.employees[i].toPay());
        }
        return total;
    }

    public String nameMaxSalary() {
        BigDecimal maxSalary = BigDecimal.ZERO;
        String name = null;
        for (int i = 0; i < this.employees.length; i++) {
            BigDecimal currentSalary = this.employees[i].toPay();
            if (currentSalary.compareTo(maxSalary) > 0) {
                maxSalary = currentSalary;
                name = this.employees[i].getName();
            }
        }
        return name;
    }
}
