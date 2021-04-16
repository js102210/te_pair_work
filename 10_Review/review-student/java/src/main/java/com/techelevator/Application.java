package com.techelevator;

import java.text.NumberFormat;
import java.util.*;

public class Application {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Department getDepartmentByName(String deptName) {
        Department result = null;
        for (Department department : departments) {
            if (department.getName().equals(deptName)) {
                result = department;

            }
        }
        return result;
    }


    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }



    private void run() {
        // create some departments


        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();
        // give Angie a 10% raise, she is doing a great job!
        // print all employees
        printEmployees();
        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
      printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */


    private void createDepartments() {
        Department marketing = new Department(1, "Marketing");
        departments.add(marketing);
        Department sales = new Department(2, "Sales");
        departments.add(sales);
        Department engineering = new Department(3, "Engineering");
        departments.add(engineering);

    }






    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("\n------------- Departments ------------------------------");
        for (Department department : departments) {
            System.out.println(department.getName());
        }
    }


    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee Dean = new Employee();
        Dean.setEmployeeId(001);
        Dean.setFirstName("Dean");
        Dean.setLastName("Johnson");
        Dean.setEmail("djohnson@teams.com");
        Dean.setDepartment(getDepartmentByName("Engineering"));
        Dean.setHireDate("08/21/2020");



        Employee Angie = new Employee(002, "Angie", "Smith",
                "asmith@teams.com", getDepartmentByName("Engineering"), "08/21/2020");
        Employee Margaret = new Employee(003, "Margaret", "Thompson",
                "mthompson@teams.com", getDepartmentByName("Marketing"), "08/21/2020");

        employees.add(Angie);
        employees.add(Dean);
        employees.add(Margaret);

        Angie.raiseSalary(10);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- Employees ------------------------------");
        for (Employee employee : employees) {
            NumberFormat salaryFormatter = NumberFormat.getCurrencyInstance(Locale.US);
            double salaryDouble = employee.getSalary();
            String formattedSalary = salaryFormatter.format(salaryDouble);
            System.out.println(employee.getFullName() + " " + "(/" + formattedSalary + ")" + " " + employee.getDepartment().getName());
        }
    }

    /**
     * Create the 'TEams' project.
     */
    Map<String, Project> projects = new HashMap<>();

    private void createTeamsProject() {
        Project TEams = new Project("TEams", "Project Managment Software",
                0, 30);


        //  TEams.addEmployees(employees.get(1));

        for (Employee employee : employees) {
            String employeeDepartment = employee.getDepartment().getName();
            if (employeeDepartment.equals("Engineering")) {
                TEams.addEmployees(employee);
            }
        }
        projects.put("TEams", TEams);

    }


    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project marketingLandingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing",
                31, 38);
        for (Employee employee : employees) {
            String employeeDepartment = employee.getDepartment().getName();
            if (employeeDepartment.equals("Marketing")) {
                marketingLandingPage.addEmployees(employee);
            }
        }
     projects.put("Marketing Landing Page", marketingLandingPage);

    }


    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
       for (Map.Entry<String, Project> project : projects.entrySet()) {
           System.out.println(project.getKey() + ": " + project.getValue().getEmployeeList().size());

        }
    }

}
