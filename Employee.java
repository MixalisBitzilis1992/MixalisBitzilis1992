import com.sun.jdi.IntegerValue;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Employee extends DatabaseConnection{
    private int emp_number;
    private String ename;
    private String job;
    private Date hireDate;
    private int mgr;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private float sal;
    private float comm;
    private int dept_number;

    private Department department;

    public Employee(){

    }

    public Employee(int emp_number,String ename,String job,Date hireDate,int mgr,float sal,float comm,int dept_number){
        this.emp_number=emp_number;
        this.ename=ename;
        this.job=job;
        this.hireDate=hireDate;
        this.sal=sal;
        this.comm=comm;
        this.dept_number=dept_number;
    }

    public int getEmp_number() {
        return emp_number;
    }

    public void setEmp_number(int emp_number) {
        this.emp_number = emp_number;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public int getDept_number() {
        return dept_number;
    }

    public void setDept_number(int dept_number) {
        this.dept_number = dept_number;
    }

    public List<Employee> GetDataFromEmp(Employee employee) throws SQLException,Exception {
        Connection conn = getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "select * from emp";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Employee> employeeList = new ArrayList<>();
        while (rst.next()) {
            Employee employee1 = new Employee();
            employee1.setEmp_number(rst.getInt("emp_number"));
            employee1.setEname(rst.getString("ename"));
            employee1.setJob(rst.getString("job"));
            employee1.setHireDate(rst.getDate("hiredate"));
            employee1.setMgr(rst.getInt("mgr"));
            employee1.setSal(rst.getFloat("sal"));
            employee1.setComm(rst.getFloat("comm"));
            employee1.setDept_number(rst.getInt("dept_number"));

            employeeList.add(employee1);
        }

        System.out.println(employeeList.toString() + "" + System.lineSeparator());
        return employeeList;
    }

    public String toString(){
        return "Employee number:" + this.getEmp_number() + "\t" + "Name:" + this.getEname() + "\t" + "Job:" + this.getJob() + "\t" + "HireDate:" + this.getHireDate() + "\t" + "Mgr:" + this.getMgr() + "\t" + "Sal:" + this.getSal() + "\t" + "Comm:" + this.getComm() + "\t" + "Dept_number:" + this.getDept_number() + System.lineSeparator();
    }

    public void updatedListFromEmp(Employee employee) throws Exception,SQLException{
        Connection conn=getConnection();
        Statement stm;
        stm = conn.createStatement();
        int numberofrows = stm.executeUpdate("update emp set sal='2800' where ename='mixalis'");
        conn.commit();
        System.out.println("The number of rows that were updated is " + numberofrows);
    }

    public void shortedListByname(List<Employee> employeeList) {
        for(int i=0;i<employeeList.size();i++) {
                Collections.sort(employeeList, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee employee1, Employee employee2) {
                        return employee1.getEname().compareTo(employee2.getEname());
                    }
                });
            }

        System.out.println(employeeList);
    }

    public void shortedListBySal(List<Employee> employeeList) {
        for(int i=0;i<employeeList.size();i++) {
            Collections.sort(employeeList, new Comparator<Employee>() {
                @Override
                public int compare(Employee employee1, Employee employee2) {
                    return (employee1.getHireDate()).compareTo(employee2.getHireDate());
                }
            });
        }

        System.out.println(employeeList);
    }

}
