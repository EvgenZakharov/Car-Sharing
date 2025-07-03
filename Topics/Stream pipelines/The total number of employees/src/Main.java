import java.util.*;
import java.util.stream.Collectors;

class EmployeesCounter {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {



        return departments.stream()
                // Filter departments whose code starts with "111-"
                .filter(department -> department.getCode().startsWith("111-"))
                // Flatten the list of employees from each department into a single stream
                .flatMap(department -> department.getEmployees().stream())
                // Filter employees whose salary is greater than or equal to the threshold
                .filter(employee -> employee.getSalary() >= threshold)
                // Count the number of such employees
                .count();

    }

    // Don't change the code below
    static class Employee {
        private final String name;
        private final Long salary;

        Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employees;

        Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }
}