package com.epam.test.automation.java.practice6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class SalesPersonTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIfBonusSetNull() {
        new SalesPerson("Ivanov", new BigDecimal(80500), 25).setBonus(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIfBonusIsLessThan0() {
        Employee salesPerson = new SalesPerson("Ivanov", new BigDecimal(25500), 25);
        salesPerson.setBonus(new BigDecimal(-1));
    }

    @Test
    public void testIfBonusIsn0() {
        Employee salesPerson = new SalesPerson("Ivanov", new BigDecimal(25500), 25);
        salesPerson.setBonus(BigDecimal.ZERO);
        Assert.assertEquals(salesPerson.getBonus(), BigDecimal.ZERO);
    }

    @DataProvider(name = "testPercent")
    public static Object[][] percent() {
        return new Object[][] {{99, new BigDecimal(30)},
                {100, new BigDecimal(30)},
                {101, new BigDecimal(60)},
                {199, new BigDecimal(60)},
                {200, new BigDecimal(60)},
                {201, new BigDecimal(90)}};
    }

    @Test(dataProvider = "testPercent")
    public void testSetBonusWithPercent(int percent, BigDecimal expectedBonus){
        Employee salesPerson = new SalesPerson("Ivanov", new BigDecimal(25000), percent);
        salesPerson.setBonus(new BigDecimal(30));
        Assert.assertEquals(salesPerson.getBonus(), expectedBonus);
    }

    @Test
    public void testToPay() {
        Employee salesPerson = new SalesPerson("Ivanov", new BigDecimal(25000), 99);
        salesPerson.setBonus(new BigDecimal(80));
        Assert.assertEquals(salesPerson.toPay(), new BigDecimal(25080));
    }

    @Test
    public void testSalaryRecording(){
        Employee salesPerson = new SalesPerson("Ivanov", new BigDecimal(25000), 99);
        salesPerson.setSalary(new BigDecimal(15000));
        Assert.assertEquals(salesPerson.getSalary(), new BigDecimal(15000));
    }
}
