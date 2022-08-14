import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static double percent = 10;
    public static int dep = 4;
    public static double ratePercent = 10;
    public static double salary = 50_000;

    public static void main(String[] args) {
        int id = 0;

        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Ivanov Ivan Ivanovich", 80_000, 2, id);
        employee[1] = new Employee("Petrov Prtr Petrovich", 70_000, 2, 1);
        employee[2] = new Employee("Vasilev Vasiliy Vasilevich", 60_000, 3, 1);
        employee[3] = new Employee("Nikitin Nikita Nikitovich", 30_000, 4, 1);
        employee[4] = new Employee("Alekseev Aleksey Alekseevich", 32_000, 5, 1);
        employee[5] = new Employee("Kirillov Kirill Kirilovich", 36_000, 4, 1);
        employee[6] = new Employee("Maksimov Maksim Maksimovich", 37_000, 4, 1);
        employee[7] = new Employee("Vladimirov Vladimir Vladimirovich", 48_000, 1, 1);
        employee[8] = new Employee("Vadimov Vadim Vadimovich", 26_000, 1, 1);
        employee[9] = new Employee("Egorov Egor Egorovich", 79_000, 1, 1);

// Базовая сложность вывод
        printDataEmployees(employee);
        System.out.println("/////////////////\nSalary amount = " + salaryValue(employee));
        System.out.println("/////////////////\nEmployee with minimum salary is " + minSalary(employee));
        System.out.println("/////////////////\nEmployee with maximum salary is " + maxSalary(employee));
        System.out.println("/////////////////\nAverage salary = " + averageSalary(employee) + "\n/////////////////");
        getAllNames(employee);
// Повышенная сложность вывод
        indexationSalary(percent, employee);
        System.out.println("/////////////////\nSalary employees after indexation:");
        printDataEmployees(employee);
        minSalaryByDepartment(dep, employee);
        maxSalaryByDepartment(dep, employee);
        System.out.println("/////////////////\nDepartment costs are:\n" + costsSumByDepartment(dep, employee));
        String twoDecimalPlaces = String.format("%.2f", amountSalaryByDepartment(dep, employee));
        System.out.println("/////////////////\nAmount department costs are:\n" + twoDecimalPlaces);
        indexingByDepartment(dep, ratePercent, employee);
        System.out.println("/////////////////\nSalary employees by " + dep + " department after indexation:");
        printEmployeesByDepartment(dep, employee);
        System.out.println("/////////////////\nEmployees with salaries below current value: " + salary);
        findEmployeesLess(salary, employee);
        System.out.println("/////////////////\nEmployees with salaries more or equals current value: " + salary);
        findEmployeesMore(salary, employee);
    }

    // Базовая сложность - методы
    public static void printDataEmployees(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }
    }

    public static int salaryValue(Employee[] employee) {
        int summ = 0;
        for (int i = 0; i < employee.length; i++) {
            summ += employee[i].getSalary();
        }
        return summ;
    }

    public static String minSalary(Employee[] employee) {
        String minSalaryNames;
        double min = employee[0].getSalary();
        int index = 0;
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() < min) {
                min = employee[i].getSalary();
                index = i;
            }
        }
        minSalaryNames = employee[index].getFullName();
        return minSalaryNames;
    }

    public static String maxSalary(Employee[] employee) {
        String maxSalaryNames;
        double max = employee[0].getSalary();
        int index = 0;
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() > max) {
                max = employee[i].getSalary();
                index = i;
            }
        }
        maxSalaryNames = employee[index].getFullName();
        return maxSalaryNames;
    }

    public static double averageSalary(Employee[] employee) {
        double average = (double) salaryValue(employee) / employee.length;
        return average;
    }

    public static void getAllNames(Employee[] employee) {
        System.out.println("Full names:");
        for (Employee value : employee) {
            System.out.println(value.getFullName());
        }
    }

    // Повышенная сложность методы
    public static void indexationSalary(double percent, Employee[] employee) {
        double rate = percent / 100;
        double newSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            newSalary = (employee[i].getSalary() * rate) + employee[i].getSalary();
            employee[i].setSalary(newSalary);
        }
    }
    public static void minSalaryByDepartment(int dep, Employee[] employee) {
        double min = employee[0].getSalary();
        String name = employee[0].getFullName();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep && employee[i].getSalary() < min) {
                    min = employee[i].getSalary();
                    name = employee[i].getFullName();
            }
        }
        System.out.println("/////////////////\nThe lowest salary in the department employee:\n" + name + "\n" + min);
    }

    public static void maxSalaryByDepartment(int dep, Employee[] employee) {
        double max = employee[0].getSalary();
        String name = employee[0].getFullName();
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep && employee[i].getSalary() > max) {
                    max = employee[i].getSalary();
                    name = employee[i].getFullName();
            }
        }
        System.out.println("/////////////////\nThe biggest salary in the department employee:\n" + name + "\n" + max);
    }

    public static double costsSumByDepartment(int dep, Employee[] employee) {
        double costsSum = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                costsSum += employee[i].getSalary();
            }
        }
        return costsSum;
    }

    public static double amountSalaryByDepartment(int dep, Employee[] employee) {
        double amount;
        int countDep = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                countDep++;
            }
        }
        double sum = costsSumByDepartment(dep, employee);
        amount = sum / (double) countDep;
        return amount;
    }

    public static void indexingByDepartment(int dep, double ratePercent, Employee[] employee) {
        double rate = percent / 100;
        double newSal = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                newSal = (employee[i].getSalary() * rate) + employee[i].getSalary();
                employee[i].setSalary(newSal);
            }
        }
    }

    public static void printEmployeesByDepartment(int dep, Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                System.out.println("Name: " + employee[i].getFullName() + ", Salary: " + employee[i].getSalary() + ", ID: " + employee[i].getId());
            }
        }
    }
    public static void findEmployeesLess(double salary, Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < salary) {
                System.out.println("Name: " + employee[i].getFullName() + ", Salary: " + employee[i].getSalary() + ", ID: " + employee[i].getId());
            }
        }
    }
    public static void findEmployeesMore(double salary, Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() >= salary) {
                System.out.println("Name: " + employee[i].getFullName() + ", Salary: " + employee[i].getSalary() + " , Department: " + employee[i].getDepartment() + ", ID: " + employee[i].getId());
            }
        }
    }
}