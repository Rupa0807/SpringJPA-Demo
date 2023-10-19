package com.rupa.RestJpa.Controller;

import com.rupa.RestJpa.Dao.EmployeeRepository;
import com.rupa.RestJpa.Entity.Employee;
import com.rupa.RestJpa.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    EmployeeRepository employee;
    EmployeeService EmpService;
@Autowired
    public EmployeeRestController(EmployeeService employee) {
        this.EmpService = employee;
    }


    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        System.out.println("Inside employee method");
        return    EmpService.getAllEmployee();


    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeebyId(@PathVariable("id")  Long Id){
        System.out.println("Inside employee method");
        return  EmpService.findById(Id);


    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println("Inside add employee method");
       employee.setId(0L);//to create new user instead of update
       return  EmpService.save(employee);


    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
       //er instead of update
        return  EmpService.save(employee);


    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        //er instead of update
        Employee e= EmpService.findById(id);
        e=employee;
        //updating the user details
//        e.setId(employee.getId());
//        e.setFirstName(employee.getFirstName());
//        e.setEMail(employee.getEMail());
        return  EmpService.save(e);
// adding a new comment to check for differenceg

    }

    @DeleteMapping ("/employee/{id}")
    public void deleteEmployeeById(@PathVariable("id")  Long Id){
        System.out.println("Inside Delete employee method");
        Employee e= EmpService.findById(Id);
          EmpService.deleteEmployee(e);


    }
}
