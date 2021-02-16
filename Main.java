import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception  {
        Department department = new Department();
        Employee employee = new Employee();
        Project project = new Project();
        //department.getDataFromDept(department);
        List<Employee> employeeList = employee.GetDataFromEmp(employee);
        //project.getDataFromProj(project);
        //department.upDatedListFromDept(department);
        //employee.updatedListFromEmp(employee);
        //ReadDataFromUser readDataFromUser = new ReadDataFromUser();
        //String input = readDataFromUser.getDataFromUser();
        //Searching searching = new Searching();
        //searching.searchForNameThatGiveUsFromInput(employeeList,input);
        employee.shortedListBySal(employeeList);
    }
}
