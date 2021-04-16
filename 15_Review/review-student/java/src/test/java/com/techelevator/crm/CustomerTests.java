package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerTests {
    @Test
    public void getBalanceDue_returns_correct_total_for_map_with_3_entries(){
        Customer sut = new Customer("Test", "Testerson");
        Map<String, Double> testServices = new HashMap<>();
        testServices.put("Walking", 10.00);
        testServices.put("Jogging", 30.00);
        testServices.put("Running for your life", 60.00);

        double result = sut.getBalanceDue(testServices);


        Assert.assertEquals(100.00, result, 0.00);
    }

    @Test
    public void getBalanceDue_returns_correct_total_for_map_with_1_entry(){
        Customer sut = new Customer("Test", "Testerson");
        Map<String, Double> testServices = new HashMap<>();

        testServices.put("Running for your life", 60.00);

        double result = sut.getBalanceDue(testServices);


        Assert.assertEquals(60.00, result, 0.00);
    }

    @Test
    public void getBalanceDue_returns_0_for_empty_map(){
        Customer sut = new Customer("Test", "Testerson");
        Map<String, Double> testServices = new HashMap<>();


        double result = sut.getBalanceDue(testServices);


        Assert.assertEquals(0.00, result, 0.00);
    }

    @Test
    public void twoArg_constructor_creates_employee_correctly(){
        Customer sut= new Customer("Jake", "Schwartz");
        String resultName = "Jake Schwartz";
        String resultPhoneNum = "";


        Assert.assertEquals("Jake Schwartz", resultName);
        Assert.assertEquals("", resultPhoneNum);
    }
    @Test
    public void threeArg_constructor_creates_employee_correctly(){
        Customer sut= new Customer("Jake", "Schwartz", "555-555-5555");
        String resultName = "Jake Schwartz";
        String resultPhoneNum = "555-555-5555";


        Assert.assertEquals("Jake Schwartz", resultName);
        Assert.assertEquals("555-555-5555", resultPhoneNum);
    }



}
