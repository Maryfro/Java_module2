package DepartmentEmployeeFlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentService {

    int countEmployees(List<Department> departments, long threshold, String prefix) {
        return (int) departments.stream()
                .filter(department -> department.getCode().startsWith(prefix))
                .flatMap(department -> department
                        .getEmployees()
                        .stream()
                        .filter(employee -> employee
                                .getSalary() >= threshold))
                .count();
    }
}

/*
        Class Employee
  private String name;
    private long salary;

        Class Department
        String name
        String code
        List <Employee> employees

        Task: count the amount of employees, whose salary >= some
        specific threshold and department's code has to start with a
        specific prefix
        int countEmployees(List<Department> departments, long threshold, String prefix)
        use flatmap
 */
