package pro.sky.skyprolistemployeedemo.service;

import pro.sky.skyprolistemployeedemo.employee.Employee;
import pro.sky.skyprolistemployeedemo.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprolistemployeedemo.exception.EmployeeNotFoundException;
import pro.sky.skyprolistemployeedemo.exception.EmployeeStorageIsFullException;

import java.util.List;


public interface EmployeeService {

    Employee add(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(String firstName, String lastName)
            throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName)
            throws EmployeeNotFoundException;

    List<Employee> getAll();
}
