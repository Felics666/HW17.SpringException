package pro.sky.skyprolistemployeedemo.controller;

import pro.sky.skyprolistemployeedemo.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprolistemployeedemo.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping (path = "/add")
    public Employee addEmployee (@RequestParam ("firstName") String firstName,
                        @RequestParam("lastName") String lastName){
        return employeeService.add(firstName, lastName);
    }

    @GetMapping (path = "/remove")
    public Employee removeEmployee  (@RequestParam ("firstName") String firstName,
            @RequestParam("lastName") String lastName){
        return employeeService.remove(firstName, lastName);
    }


    @GetMapping (path = "/find")
    public Employee findEmployee  (@RequestParam ("firstName") String firstName,
                            @RequestParam("lastName") String lastName){
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/allEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }
}
