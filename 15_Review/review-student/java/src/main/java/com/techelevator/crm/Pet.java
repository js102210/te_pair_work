package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String name;
    private String species;
    private List<String> vaccinations = new ArrayList<>();

  //getters and setters
  public String getName(){
      return this.name;
  }
  public void setName(String name){
      this.name = name;
  }

  public String getSpecies(){
      return this.species;
  }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<String> getVaccinations() {

      return this.vaccinations;
    }

    public void setVaccinations(List<String> vaccinations) {
        this.vaccinations = vaccinations;
    }

    // constructors

    public Pet (String name, String species) {
      this.setName(name);
      this.setSpecies(species);
    }



    public String listVaccinations() {
        String result = "";
        if (this.vaccinations.size() > 0) {
            for (String vac : this.vaccinations) {
                result += vac + ", ";
            }
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }


    @Override
    public String toString() {
        return this.name + " the " + this.species;
    }
}
