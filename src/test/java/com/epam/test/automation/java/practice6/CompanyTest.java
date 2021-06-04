package com.epam.test.automation.java.practice6;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CompanyTest {

    @Test
    public void testAmountOfAllBonusesInStaffIfUseGiveEverybodyBonus() {
        Employee employee1 = new Manager("Ivanov", new BigDecimal(8000), 25);
        Employee employee2 = new SalesPerson("Petrovov", new BigDecimal(10000), 15);
        Employee employee3 = new Manager("Sidorovov", new BigDecimal(9000), 45);
        Employee[] employees = {employee1, employee2, employee3};
        Company company = new Company(employees);
        company.giveEverybodyBonus(new BigDecimal(33));
        Assert.assertEquals(employee1.getBonus(), new BigDecimal(33));
        Assert.assertEquals(employee2.getBonus(), new BigDecimal(33));
        Assert.assertEquals(employee3.getBonus(), new BigDecimal(33));
    }

    @Test
    public void testAmountOfAllBonusesInStaffIfUseGiveEverybodyBonusWhenBonusChanged() {
        Employee employee1 = new Manager("Ivanov", new BigDecimal(8000), 500);
        Employee employee2 = new SalesPerson("Petrovov", new BigDecimal(10000), 250);
        Employee[] employees = {employee1, employee2};
        Company company = new Company(employees);
        company.giveEverybodyBonus(new BigDecimal(33));
        Assert.assertEquals(employee1.getBonus(), new BigDecimal(1033));
        Assert.assertEquals(employee2.getBonus(), new BigDecimal(99));
    }

    @Test
    public void testTotalToPay() {
        Employee employee1 = new Manager("Ivanov", new BigDecimal(8000), 25);
        Employee employee2 = new SalesPerson("Petrovov", new BigDecimal(10000), 15);
        Employee employee3 = new Manager("Sidorovov", new BigDecimal(9000), 35);
        Employee[] employees = {employee1, employee2, employee3};
        Company company = new Company(employees);
        company.giveEverybodyBonus(new BigDecimal(25));
        Assert.assertEquals(company.totalToPay(), new BigDecimal(27075));
    }

    @Test
    public void testNameMaxSalary() {
        Employee employee1 = new Manager("Ivanov", new BigDecimal(8000), 25);
        Employee employee2 = new SalesPerson("Petrovov", new BigDecimal(10000), 15);
        Employee employee3 = new Manager("Sidorovov", new BigDecimal(9000), 35);
        Employee[] employees = {employee1, employee2, employee3};
        Company company = new Company(employees);
        company.giveEverybodyBonus(new BigDecimal(25));
        Assert.assertEquals(company.nameMaxSalary(), "Petrovov");
    }
}
