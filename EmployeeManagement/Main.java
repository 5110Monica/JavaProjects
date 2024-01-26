package PracticeOOP.EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initializeRecords();
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Record Management App");
            System.out.println("1. Display all Employee records");
            System.out.println("2. Search records");
            System.out.println("3. Print reporting tree");
            System.out.println("4. Print employees reporting to a manager");
            System.out.println("5. Print summary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    displayAllEmployeeRecords();
                    break;
                case 2:
                    searchRecords();
                    break;
                case 3:
                   // printReportingTree(in);
                    break;
                case 4:
                    //printEmployeesReportingToManager(in);
                    break;
                case 5:
                   // printSummary();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

    }
    private static void displayAllEmployeeRecords() {
        System.out.println("Employee Records:");
        System.out.printf("%-15s%-5s%-15s%-15s%-15s\n", "EmpName", "Age", "Designation", "Department", "ReportingTo");
        for (Employee employee : Employee.employeeRecords) {
            System.out.printf("%-15s%-5d%-15s%-15s%-15s\n",
                    employee.name, employee.age, employee.designation, employee.department, employee.reportingTo);
        }
        System.out.println();
    }
    public static void initializeRecords(){
        Employee.employeeRecords.add(new Employee("Moni",22,"developer","software","ash"));
        Employee.employeeRecords.add(new Employee("Jungkook",25,"developer","software","ash"));
        Employee.employeeRecords.add(new Employee("Vijay",30,"accountant","accounts","priya"));
        Employee.employeeRecords.add(new Employee("kim",31,"accountant","accounts","priya"));
        Employee.employeeRecords.add(new Employee("jin",29,"developer","software","vijay"));
    }
    public static void searchRecords() {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Integer");
        System.out.println("2.String");
        System.out.println("Enter the choice: ");
        int choice = in.nextInt();
        System.out.println("Enter the column to search: ");
        System.out.println("1.Name ");
        System.out.println("2.Age ");
        System.out.println("3.Designation");
        System.out.println("4.Department");
        System.out.println("5.ReportingManger");
        int columnType = in.nextInt();
        System.out.println("Enter operation: ");
        String operator = in.next();
        while (true) {
            if (choice == 1) {
                if(operator.equals("between")){
                    System.out.println("Enter an val1 to search: ");
                    int val1 = in.nextInt();
                    System.out.println("Enter an val2 to search: ");
                    int val2 = in.nextInt();
                    searchInteger(val1,val2,columnType,operator);
                    break;
                }
                System.out.println("Enter an val to search: ");
                int val = in.nextInt();
                searchInteger(val,columnType,operator);
                break;
            }
            else if (choice==2) {
                System.out.println("Enter String to search: ");
                String str = in.next();
                searchString(str,columnType,operator);
                break;
            }
            else {
                System.out.println("invalid choice");
            }
        }
    }
    private static void searchInteger(int val, int columnType, String operator) {
        System.out.printf("%-15s%-5s%-15s%-15s%-15s\n", "EmpName", "Age", "Designation", "Department", "ReportingTo");
        for(Employee employee:Employee.employeeRecords){
             int num = findColumnInt(employee,columnType);
             if(compareInt(num,val,operator)){
                 System.out.printf("%-15s%-5d%-15s%-15s%-15s\n",
                         employee.name, employee.age, employee.designation, employee.department, employee.reportingTo);
             }
        }
    }
    private static void searchInteger(int val1, int val2, int columnType, String operator) {
        System.out.printf("%-15s%-5s%-15s%-15s%-15s\n", "EmpName", "Age", "Designation", "Department", "ReportingTo");
        for(Employee employee:Employee.employeeRecords){
            int num = findColumnInt(employee,columnType);
            if(compareInt(num,val1,val2,operator)){
                System.out.printf("%-15s%-5d%-15s%-15s%-15s\n",
                        employee.name, employee.age, employee.designation, employee.department, employee.reportingTo);
            }
        }
    }
    private static void searchString(String str, int columnType, String operator) {
        System.out.printf("%-15s%-5s%-15s%-15s%-15s\n", "EmpName", "Age", "Designation", "Department", "ReportingTo");
        for(Employee employee:Employee.employeeRecords){
            String s = findColumnStr(employee,columnType);
            if(compareStr(s,str,operator)){
                System.out.printf("%-15s%-5d%-15s%-15s%-15s\n",
                        employee.name, employee.age, employee.designation, employee.department, employee.reportingTo);
            }
        }
    }

    private static boolean compareStr(String num, String str, String operator) {
        switch (operator.toLowerCase()){
            case "startswith":
                return num.startsWith(str);
            case "endswith":
                return num.endsWith(str);
            case "equals":
                return num.equals(str);
            case "notequals":
                return !num.equals(str);
            case "contains":
                return num.contains(str);
            case "notcontains":
                return !num.contains(str);
        }
        return false;
    }

    private static String findColumnStr(Employee employee,int columnType){
        switch (columnType){
            case 1:
                return employee.name;
            case 3:
                return employee.designation;
            case 4:
                return employee.department;
            case 5:
                return employee.reportingTo;
            default:
                return "invalid input!";
        }
    }

    private static int findColumnInt(Employee employee,int columnType){
            return employee.age;
    }
    private static boolean compareInt(int num, int val, String operator) {
        switch (operator.toLowerCase()){
            case "equals":
                return num==val;
            case "notequals":
                return num!=val;
            case "greaterthanorequal":
                return num>=val;
            case "lessthanorequal":
                return num<=val;
        }
        return false;
    }
    private static boolean compareInt(int num, int val1,int val2, String operator){
        if(operator.toLowerCase().equals("between")){
            if(num>val1 && num<val2){
                return true;
            }
        }
        return false;
    }
}
