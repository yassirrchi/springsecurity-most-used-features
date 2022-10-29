package com.springsecurity.focus.springsecurityfocus.Controllers;

import com.springsecurity.focus.springsecurityfocus.Controllers.Emtities.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private static final List<Employee> employeesList= Arrays.asList(
            new Employee(1,"Yassir"),
            new Employee(2,"Ahmed"),
            new Employee(3,"Amine")

    );
    @GetMapping(path="{id}")
    public Employee getEmployee(@PathVariable("id") int employeeId){
        return employeesList.stream().filter(employee -> employeeId ==employee.getEmployeeid()).
                findFirst().orElseThrow(()->new IllegalStateException("employee with id "+employeeId+" doesnt exist"));

    }
}
