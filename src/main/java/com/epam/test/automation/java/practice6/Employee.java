package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

public abstract class Employee {

    private String name;
    private BigDecimal salary = BigDecimal.ZERO;
    protected BigDecimal bonus = BigDecimal.ZERO;

    protected Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    protected abstract void setBonus(BigDecimal bonus);


    public BigDecimal toPay() {
        return this.salary.add(this.bonus);
    }
}