package com.epam.test.automation.java.practice6;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ManagerTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIfBonusSetNull() {
        new Manager("Ivanov", new BigDecimal(80500), 25).setBonus(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIfBonusIsLessThan0() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 25);
        manager.setBonus(new BigDecimal(-1));
    }

    @Test
    public void testIfBonusIs0() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 25);
        manager.setBonus(BigDecimal.ZERO);
        Assert.assertEquals(manager.getBonus(), BigDecimal.ZERO);
    }

    @Test
    public void testSetBonusWithClientAmount99() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 99);
        manager.setBonus(new BigDecimal(15));
        Assert.assertEquals(manager.getBonus(), new BigDecimal(15));
    }

    @Test
    public void testSetBonusWithClientAmount100() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 100);
        manager.setBonus(new BigDecimal(15));
        Assert.assertEquals(manager.getBonus(), new BigDecimal(15));
    }

    @Test
    public void testSetBonusWithClientAmount101() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 101);
        manager.setBonus(new BigDecimal(15));
        Assert.assertEquals(manager.getBonus(), new BigDecimal(515));
    }

    @Test
    public void testSetBonusWithClientAmount149() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 149);
        manager.setBonus(new BigDecimal(25));
        Assert.assertEquals(manager.getBonus(), new BigDecimal(525));
    }

    @Test
    public void testSetBonusWithClientAmount150() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 150);
        manager.setBonus(new BigDecimal(25));
        Assert.assertEquals(manager.getBonus(), new BigDecimal(525));
    }

    @Test
    public void testSetBonusWithClientAmount151() {
        Employee manager = new Manager("Ivanov", new BigDecimal(80500), 151);
        manager.setBonus(new BigDecimal(25));
        Assert.assertEquals(manager.getBonus(), new BigDecimal(1025));
    }

    @Test
    public void testToPay() {
        Employee manager = new Manager("Ivanov", new BigDecimal(25000), 99);
        manager.setBonus(new BigDecimal(80));
        Assert.assertEquals(manager.toPay(), new BigDecimal(25080));
    }

    @Test
    public void testSalaryRecording(){
        Employee manager = new Manager("Ivanov", new BigDecimal(25000), 99);
        manager.setSalary(new BigDecimal(15000));
        Assert.assertEquals(manager.getSalary(), new BigDecimal(15000));
    }
}
