package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

public class SalesPerson extends Employee {
    private int percent;

    protected SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);
        this.percent = percent;
    }

    @Override
    protected void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        if (this.percent > 200) {
            this.bonus = bonus.multiply(new BigDecimal(3));
        } else if (this.percent > 100) {
            this.bonus = bonus.multiply(new BigDecimal(2));
        } else {
            this.bonus = bonus;
        }
    }
}
