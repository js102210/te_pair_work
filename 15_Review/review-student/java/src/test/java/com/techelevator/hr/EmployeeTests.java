package com.techelevator.hr;

import com.techelevator.crm.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests {

    @Test
    public void getFullNameReturnsCorrectFormat() {
        Employee sut = new Employee("Test", "Testerson");

        String fullName = sut.getFullName();

        assertEquals("The employee full name is not in the correct format.", "Testerson, Test", fullName);
    }

    @Test
    public void raiseSalaryTest_Positive() {
        Employee sut = new Employee("Test", "Testerson");
        sut.setSalary(100);

        sut.raiseSalary(5);

        assertEquals("The employee raise of 5% was not computed correctly.",sut.getSalary(), 105, 0.0);
    }

    @Test
    public void raiseSalaryTest_Negative() {
        Employee sut = new Employee("Test", "Testerson");
        sut.setSalary(100);
        sut.raiseSalary(-10); //"raise" by negative 10%

        assertEquals("Salary should remain the same when raise percentage is negative.",100, sut.getSalary(),0.0);
    }

    @Test
    public void getBalanceDue_returns_correct_total_for_map_with_3_entries(){
        Employee sut = new Employee("Test", "Testerson");
        Map<String, Double> testServices = new HashMap<>();
        testServices.put("Walking", 10.00);
        testServices.put("Jogging", 30.00);
        testServices.put("Running for your life", 60.00);

        double result = sut.getBalanceDue(testServices);


        Assert.assertEquals(95.00, result, 0.00);
    }

    @Test
    public void getBalanceDue_returns_correct_total_for_map_with_1_entry(){
        Employee sut = new Employee("Test", "Testerson");
        Map<String, Double> testServices = new HashMap<>();

        testServices.put("Running for your life", 60.00);

        double result = sut.getBalanceDue(testServices);


        Assert.assertEquals(60.00, result, 0.00);
    }

    @Test
    public void getBalanceDue_returns_0_for_empty_map(){
        Employee sut = new Employee("Test", "Testerson");
        Map<String, Double> testServices = new HashMap<>();


        double result = sut.getBalanceDue(testServices);


        Assert.assertEquals(0.00, result, 0.00);
    }



}
