import java.util.Scanner;

abstract class Employee{
    private int employeeId;
    private String employeeName;
    Employee(int id, String name){
        this.employeeId = id;
        this.employeeName = name;
    }
    int getEmployeeId(){
        return employeeId;
    }
    String getEmployeeName(){
        return employeeName;
    }
    abstract double calculateSalary();
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    FullTimeEmployee(int id, String name, double monthlySalary){
        super(id, name);
        this.monthlySalary = monthlySalary;
    }
    @Override
        double calculateSalary(){
            return monthlySalary;
        }
    }

class ContractEmployee extends Employee{
    private int workingDays;
    private double dailyRate;
    ContractEmployee(int id, String name, int workingDays, double dailyRate){
        super(id, name);
        this.workingDays = workingDays;
        this.dailyRate = dailyRate;
    }
    @Override
    double calculateSalary(){
        return workingDays * dailyRate;
    }
}
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        int employeeType = sc.nextInt();
        int employeeId = sc.nextInt();
        String employeeName = sc.next();
        double monthlySalary = 0.0;
        int workingDays = 0;
        double dailyRate = 0.0; 
        Employee emp = null;
        if(employeeType == 1){
            monthlySalary = sc.nextDouble(); 
            emp = new FullTimeEmployee(employeeId, employeeName, monthlySalary);
        }
        else if(employeeType == 2){
            workingDays = sc.nextInt();
            dailyRate = sc.nextDouble();
            emp = new ContractEmployee(employeeId, employeeName, workingDays, dailyRate);
        }
        else {
            System.out.println("Invalid employee type");
            return;
        }
        System.out.println("Employee ID: " + emp.getEmployeeId());
          System.out.println("Employee Name: " + emp.getEmployeeName());
          System.out.printf("Salary: %.2f%n", emp.calculateSalary());
        }
}