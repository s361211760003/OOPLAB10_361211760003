import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    public static void main(String[] args) {
        // create interface instant
        employeeDAO dao = EmployeeDAOImpl.getInstant();

        //Get all Employee
        displayAllEmployee(dao);
        
        //Get all Employee
        addNewEmployee(dao);





    }//main

    private static void addNewEmployee(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter employee id:");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter employee Name: ");
        String Name = sc.nextLine().trim();
        System.out.print("Enter employee Position: ");
        String Position = sc.nextLine().trim();
        System.out.print("Enter employee Salary: ");
        Double Salary = Double.parseDouble(sc.nextLine().trim());
        //insert data to database
        Employee newEmp = new Employee(id, Name, Position, Salary);
        dao.addEmp(newEmp);
    }

    private static void displayAllEmployee(employeeDAO dao) {
        List<Employee> myEmp = dao.getAllEmp();
        for (Employee emp:myEmp) {
            System.out.println(emp.toString());
        }
    }
}//class
