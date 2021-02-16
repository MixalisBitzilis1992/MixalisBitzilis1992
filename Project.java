import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Project extends DatabaseConnection {
    private int projno;
    private String pname;
    private float budget;



    public Project(){

    }

    public Project(int projno, String pname, float budget) {
        this.projno = projno;
        this.pname = pname;
        this.budget = budget;
    }

    public int getProjno() {
        return projno;
    }

    public void setProjno(int projno) {
        this.projno = projno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public List<Project> getDataFromProj(Project project) throws Exception, SQLException {
        Connection conn=getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "select * from proj";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Project> projectList = new ArrayList<>();
        while (rst.next()){
            Project project1 = new Project();
            project1.setProjno(rst.getInt("projno"));
            project1.setPname(rst.getString("pname"));
            project1.setBudget(rst.getFloat("budget"));

            projectList.add(project1);
        }

        System.out.println(projectList.toString()+ "" + System.lineSeparator());
        return projectList;
    }

    public String toString(){
        return "Project Number:" + this.getProjno() + "\t" + "Project Name:" + this.getPname() + "\t" + "Budjet:" + this.getBudget() + System.lineSeparator();
    }
}
