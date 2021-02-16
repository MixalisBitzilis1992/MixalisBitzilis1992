import jdk.swing.interop.SwingInterOpUtils;

import java.security.PublicKey;
import java.util.List;

public class Searching {

    public void searcheInTheListOfEmp(List<Employee> employeeList,String input){
        int i=0;
        while(i<employeeList.size() && !input.equals(employeeList.get(i).getEname())){
            i++;
        }
        System.out.println("The position in List of Employess is " + i + "\t" + "and the job of this employee is " + employeeList.get(i).getJob());
    }

    public void searchForNameThatGiveUsFromInput(List<Employee> employeeList,String input){
        for(Employee employee:employeeList){
            if(employee.getEname().contains(input))
                System.out.println("The job is " + employee.getJob() + "\t" +  "the sal is " + employee.getSal());

        }
        //System.out.println(employeeList.stream().anyMatch(o -> o.getEname().equals(input)));
        }
    }

