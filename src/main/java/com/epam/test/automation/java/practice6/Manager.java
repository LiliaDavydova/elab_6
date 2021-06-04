package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

public class Manager extends Employee {
    private int quantity;

    protected Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        this.quantity = clientAmount;
    }

    @Override
    protected void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        if (this.quantity > 150) {
            this.bonus = bonus.add(new BigDecimal(1000));
        } else if (this.quantity > 100) {
            this.bonus = bonus.add(new BigDecimal(500));
        } else {
            this.bonus = bonus;
        }
    }
}
