public class Employee {
    //attributes
    private int empid;
    private String Name;
    private String Position;
    private double Salary;
    //constructor

    public Employee(int empid, String name, String position, double salary) {
        this.empid = empid;
        Name = name;
        Position = position;
        Salary = salary;
    }

    //getter and setter

    public static int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public static String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public static double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    //toString

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", Name='" + Name + '\'' +
                ", Position='" + Position + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
