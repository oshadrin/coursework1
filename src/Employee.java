public class Employee {

    private final String fullName;
    private double salary;
    private int department;
    private static int counter = 1;

    private int id;


    public Employee(String fullName, int salary, int department, int id) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        this.id = counter;
        counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

@Override
    public String toString(){
        return "Name: " + getFullName() + ", Salary: " + getSalary() + ", Department: " + getDepartment() + ", ID: " + getId();
}
}
