package com.techelevator;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private static double salary = 60000.00;
    private Department department;
    private String hireDate;

    //getters
    public long getEmployeeId() {
        return this.getEmployeeId();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public double getSalary() {
        return this.salary;
    }

    public Department getDepartment() {
        return this.department;
    }

    public String getHireDate() {
        return this.hireDate;
    }


    //setters

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setSalary (double salary) {
        this.salary = salary;
    }
    public void setDepartment (Department department) {
        this.department = department;
    }

    public void setHireDate (String hireDate) {
        this.hireDate = hireDate;
    }


    //constructors

    public Employee(long employeeId, String firstName, String lastName, String email, Department department, String hireDate) {
        setEmployeeId(employeeId);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setDepartment(department);
        setHireDate(hireDate);
    }

    public Employee () {

    }

    //other methods
    public String getFullName() {
        return this.lastName + ", " + this.firstName;
    }

    public void raiseSalary(double percent) {
        this.salary = this.salary + (this.salary * (percent/100));
    }

}
