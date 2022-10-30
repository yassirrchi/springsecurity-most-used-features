package com.springsecurity.focus.springsecurityfocus.Emtities;

public class Employee {
    @Override
    public String toString() {
        return  employeeid+" "+name;
    }

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
