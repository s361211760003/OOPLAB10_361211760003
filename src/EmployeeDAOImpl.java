import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements employeeDAO{
    //Constant database
    public static String driverName = "org.sqlite.JDBC";
    public static String url =
            "jdbc:sqlite:D:/OOPLAB10DATABASE/companys.sqlite";
    public static Connection conn = null;



    //Constant operators
    //CRUD
    public static final String GET_ALL_EMP = "select * from Employee";
    public static final String ADD_EMP = "insert into Employee" +
            "(empID,NAME,Position,Salary) values (?,?,?,?)";
    public static final String UPDATE_EMP = "update Employee det" +
            "Name = ?,Position = ?,Salary = ?,where id = ?";
    public static final String DELETE_EMP = "delete from " +
            "employee where id = ?";
    public static final String FIND_BY_ID = "select * " +
            "from employee where id = ?";

    //create class instant
    private static EmployeeDAOImpl instant = new EmployeeDAOImpl();
    public static EmployeeDAOImpl getInstant(){
        return instant;
    }
    //constructor
    public EmployeeDAOImpl() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver load Successfully");
    }

    @Override
    public List<Employee> getAllEmp() {
        List<Employee> emp = new ArrayList<Employee>();

        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_EMP);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String position = rs.getString(3);
                double salary = rs.getDouble(4);
                //add data to object
                emp.add(new Employee(id, name, position, salary));
            }
            //close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }//getAllEmp

    @Override
    public void addEmp(Employee newEmp) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(ADD_EMP);
            //Set
            ps.setInt(1,newEmp.getEmpid());
            ps.setString(2,newEmp.getName());
            ps.setString(3,newEmp.getPosition());
            ps.setDouble(4,newEmp.getSalary());

            boolean rs = ps.execute();
            if (rs == true) {
                System.out.println("Could not add data to database.");
                System.exit(1);
            }
            System.out.println("Already add your data to database.");
            //close
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateEmp(Employee emp, String empID) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(UPDATE_EMP);
            //Set
            ps.setString(1,Employee.getName());
            ps.setString(2,Employee.getPosition());
            ps.setDouble(3,Employee.getSalary());
            ps.setInt(4,Employee.getEmpid());

            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Data with empID "+ Employee.getEmpid() +
                        " was update ");
            } else {
                System.out.println("Could not update information " +
                        "with employee id:"+ empID );
            }
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmp(int id) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(DELETE_EMP);
            //Set
            ps.setInt(1,id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Employee with emIF "+ id + "was deleted.");
            } else {
                System.out.println("Could not delete Employee " + "with empID "+ id);
            }
            ps.close();;
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findEmp(int id, int empID) {
        Employee emp = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idd = rs.getInt(1);
                String name = rs.getString(2);
                String position = rs.getString(3);
                double salary = rs.getDouble(4);

                emp = new Employee(empID, name, position, salary);
            }else {
                System.out.println("Could not found Employee " +
                        " with empID" + id);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
}//class
