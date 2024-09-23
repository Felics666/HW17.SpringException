package pro.sky.skyprolistemployeedemo.service;

import pro.sky.skyprolistemployeedemo.employee.Employee;
import pro.sky.skyprolistemployeedemo.exception.EmployeeAlreadyAddedException;
import pro.sky.skyprolistemployeedemo.exception.EmployeeNotFoundException;
import pro.sky.skyprolistemployeedemo.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int LIST_SIZE = 10;

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov"),
            new Employee("Petr", "Petrov"),
            new Employee("Harry", "Potter"),
            new Employee("Olga", "Simonova"),
            new Employee("Anastasia", "Zvyagina"),
            new Employee("Artyom", "Lavsky"),
            new Employee("Renat", "Mamaev"),
            new Employee("Ekaterina", "Kovalenko")));


    @Override
    public Employee add(String firstName, String lastName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= LIST_SIZE) {
            throw new EmployeeStorageIsFullException("The list size is exceeded!!!");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Such an employee already exists!!!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("This employee has not been found");
        }
        employees.remove(employee);
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName)
            throws EmployeeNotFoundException {

        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("This employee has not been found");
    }

    @Override
    public List<Employee> getAll() {
        return employees;

    }
}
