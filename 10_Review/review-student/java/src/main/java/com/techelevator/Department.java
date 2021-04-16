package com.techelevator;

public class Department {

    private int departmentId;
    private String name;

    public int getDepartmentId() {
        return this.departmentId;
    }
    public String getName(){
        return this.name;
    }

    public void setDepartmentId(int departmentId){
        this.departmentId = departmentId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Department(int departmentId, String name) {
        setDepartmentId(departmentId);
        setName(name);
    }


}
