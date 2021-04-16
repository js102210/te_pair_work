package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests {

    @Test
    public void listVaccinations_returns_correct_string_for_list_of_three(){
        Pet sut = new Pet("Emunah", "Mastiff");
        List<String> vaccinations = new ArrayList<String>();
        vaccinations.add("Rabies");
        vaccinations.add("Distemper");
        vaccinations.add("Parvo");
        sut.setVaccinations(vaccinations);
        String result = sut.listVaccinations();

        Assert.assertEquals("Rabies, Distemper, Parvo", result);

    }
    @Test
    public void listVaccinations_returns_correct_string_for_list_of_one(){
        Pet sut = new Pet("Emunah", "Mastiff");
        List<String> vaccinations = new ArrayList<String>();
        vaccinations.add("Covid");

        sut.setVaccinations(vaccinations);
        String result = sut.listVaccinations();

        Assert.assertEquals("Covid", result);

    }
    @Test
    public void listVaccinations_returns_correct_string_for_empty_list(){
        Pet sut = new Pet("Emunah", "Mastiff");
        List<String> vaccinations = new ArrayList<String>();


        sut.setVaccinations(vaccinations);
        String result = sut.listVaccinations();

        Assert.assertEquals("", result);

    }

    @Test
    public void toString_returns_correctly_for_jake_the_dog(){
        Pet sut = new Pet("Jake", "Dog");
        String result = sut.toString();

        Assert.assertEquals("Jake the Dog", result);
    }


}
