package PracticeOOP.EmployeeManagement;

import javax.naming.Name;
import java.util.ArrayList;

public class Employee {
    String name;
    int age;
    String designation;
    String department;
    String reportingTo;
    static ArrayList<Employee> employeeRecords = new ArrayList<>();
    public Employee(String name, int age, String designation, String department, String reportingTo) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.department = department;
        this.reportingTo = reportingTo;
    }
}
