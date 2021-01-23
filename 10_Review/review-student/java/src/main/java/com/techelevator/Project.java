package com.techelevator;

import java.util.List;

public class Project {

    private String name;

    private String description;

    private String startDate;

    private String dueDate;

    private List<Employee> employeeList;

    //

    public String getName(){
            return this.name;
    }
    public String getDescription(){
            return this.description;
    }
    public String getStartDate(){
            return this.startDate;
    }
    public String getDueDate(){ return this.dueDate; }
    public List<Employee> getEmployeeList(){ return this.employeeList; }

    //

    public void setName(String name){
            this.name = name;
    }
    public void setDescription(String description){
            this.description = description;
    }
    public void setStartDate(String startDate){
            this.startDate = startDate;
    }
    public void setDueDate(String dueDate){
            this.dueDate = dueDate;
    }
    public void addEmployees(Employee employee) {this.employeeList.add(employee);}
    public Project(String name, String description, String startDate, String dueDate){
            setName(name);
            setDescription(description);
            setStartDate(startDate);
            setDueDate(dueDate);

    }
}
