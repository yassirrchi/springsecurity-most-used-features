package com.springsecurity.focus.springsecurityfocus.Controllers;

import com.springsecurity.focus.springsecurityfocus.Emtities.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/employees")
public class ManagementController {
    private static final List<Employee> employeesList= Arrays.asList(
            new Employee(1,"Yassir"),
            new Employee(2,"Ahmed"),
            new Employee(3,"Amine")

    );
    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeesList;
    }
    @PostMapping(path="new")
    public void addNewEmployee(@RequestBody Employee employee){
        System.out.println(employee.getName());
    }
    @DeleteMapping(path="delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        System.out.println(employeesList.stream().filter(employee -> employee.getEmployeeid()==id));

    }
    @PutMapping(path="update/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        System.out.println(id +" "+employee.getName());

    }

}
