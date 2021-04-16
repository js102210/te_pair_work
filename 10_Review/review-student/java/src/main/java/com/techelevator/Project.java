package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;

    private String description;

    private LocalDate startDate = defaultStartDate;

    private static LocalDate defaultStartDate = LocalDate.now();

    private LocalDate dueDate = LocalDate.now();

    public List<Employee> employeeList = new ArrayList<>();

    //

    public String getName(){
            return this.name;
    }
    public String getDescription(){
            return this.description;
    }
    public LocalDate getStartDate(){
            return this.startDate;
    }
    public LocalDate getDueDate(){ return this.dueDate; }
    public List<Employee> getEmployeeList(){ return this.employeeList; }

    //

    public void setName(String name){
            this.name = name;
    }
    public void setDescription(String description){
            this.description = description;
    }
    public void setStartDate(Long  daysFromTodayToStart){ this.startDate = this.startDate.plusDays(daysFromTodayToStart); }
    public void setDueDate(Long daysFromStartDate){ this.dueDate = this.startDate.plusDays(daysFromStartDate);
    }
    public void addEmployees(Employee employee) {this.employeeList.add(employee);}
    public Project(String name, String description, long daysFromTodayToStart, long lengthOfProject){
            setName(name);
            setDescription(description);
            setStartDate(daysFromTodayToStart);
            setDueDate(lengthOfProject);
            this.employeeList = new ArrayList<>(employeeList);

    }


}
