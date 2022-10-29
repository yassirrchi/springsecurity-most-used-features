package com.springsecurity.focus.springsecurityfocus.Controllers.Emtities;

public class Employee {
    private final int employeeid;
    private final String name;


    public Employee(int employeeid, String name) {
        this.employeeid = employeeid;
        this.name = name;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public String getName() {
        return name;
    }
}
