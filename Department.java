import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Department extends DatabaseConnection {
    private int dept_number;
    private String dept_name;
    private String loc;

    private List<Employee> employeeList;
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department(){

    }

    public Department(int dept_number, String dept_name, String loc) {
        this.dept_number = dept_number;
        this.dept_name = dept_name;
        this.loc = loc;
    }

    public int getDept_number() {
        return dept_number;
    }

    public void setDept_number(int dept_number) {
        this.dept_number = dept_number;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    public List<Department> getDataFromDept(Department department) throws SQLException,Exception {
        Connection conn=getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "select * from Dept";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Department> departmentList = new ArrayList<>();
        while (rst.next()){
            Department departments = new Department();
            departments.setDept_number(rst.getInt("dept_number"));
            departments.setDept_name(rst.getString("dept_name"));
            departments.setLoc(rst.getString("loc"));

            departmentList.add(departments);
        }

            System.out.println(departmentList.toString()+ "" + System.lineSeparator());
        return departmentList;
    }

    public String toString(){
        return ("Dept number:" +this.getDept_number()+ "\t"+ "Dept Name:"+ this.getDept_name() + "\t" + "Location:" +
                "" + this.getLoc() + System.lineSeparator());
    }

    public void upDatedListFromDept(Department department) throws Exception,SQLException{
        Connection conn=getConnection();
        Statement stm;
        stm = conn.createStatement();
        int numberofrows = stm.executeUpdate("update dept set loc='PRAGUE' where dept_number='10'");
        conn.commit();
        System.out.println("The number of rows that were updated is " + numberofrows);

    }




}
