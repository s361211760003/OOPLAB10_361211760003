import java.util.List;
import java.util.Scanner;
public class CompanyManagement {
    public static void main(String[] args) {
        //create interface instant
        employeeDAO dao = EmployeeDAOImpl.getInstance();
        //Get all Employee
        displayAllEmployee(dao);
        //add
        //addNewEmployee(dao);
            //find Employee by ID
       // findEmployeeByID(dao);
            //update Employee by ID
        updateEmployeeByID(dao);
        //delete Employee by id
        //deleteEmployeeByID(dao);
    }//main

    private static void deleteEmployeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Delete employee with ID:");
        int id =Integer.parseInt(sc.nextLine().trim());
        dao.deleteEmp(id);
    }

    private static void updateEmployeeByID(employeeDAO dao) {
        Employee emp = findEmployeeByID2(dao);
        Scanner sc = new Scanner(System.in);
        System.out.print("Update new salary for employee ID "
                +emp.getEmpID()+":");
        double ns = Double.parseDouble(sc.nextLine().trim());
        emp.setSalary(ns);
        dao.updateEmp(emp);
        System.out.println("Updated employee with ID:"+emp.getEmpID());
    }
    private static Employee findEmployeeByID2(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Update an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());
        return  emp;
    }
    private static void findEmplyeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());
    }
    private static void addNewEmployee(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter employee Name");
        String Name = sc.nextLine().trim();
        System.out.print("Enter employee Position");
        String Position = sc.nextLine().trim();
        System.out.print("Enter employee Salary");
        double Salary =Double.parseDouble(sc.nextLine().trim());
        //insert data to database
        Employee newEmp = new Employee(id, Name, Position, Salary);
        dao.addEmp(newEmp);
    }
    private static void displayAllEmployee(employeeDAO dao) {
        List<Employee> myEmp = dao.gatAllEmp();
        for (Employee emp:myEmp){
            System.out.println(emp.toString());
        }
    }
}//class
