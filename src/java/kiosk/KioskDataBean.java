package kiosk;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Matt
 */
@SessionScoped
@Named("kioskDataBean")
public class KioskDataBean implements Serializable {
    private String searchDepartment,
                   searchId;
    
    public KioskDataBean() {}
    
    public String getSearchDepartment() { return searchDepartment; }
    public void setSearchDepartment(String s) { searchDepartment = s; }
    
    public String getSearchId() { return searchId; }
    public void setSearchId(String s) { searchId = s; }
    
    public List<Exam> getExams() throws ClassNotFoundException, SQLException {
 
        Connection connect = null;
 
        String url = "jdbc:mysql://localhost:3306/uw_kiosk";
        String username = "mhiebert";
        String password = "3060402ACS!";
 
        try {
 
            Class.forName("com.mysql.jdbc.Driver");
 
            connect = DriverManager.getConnection(url, username, password);
            // System.out.println("Connection established"+connect);
 
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
 
        List<Exam> exams = new ArrayList<Exam>();
        PreparedStatement pstmt = connect.prepareStatement("SELECT Department, CourseNumber, Term, ExamInfo FROM exams");
        ResultSet rs = pstmt.executeQuery();
 
        while (rs.next()) {
 
            Exam exam = new Exam();
            exam.setDepartment(rs.getString("Department"));
            exam.setCourseNumber(rs.getString("CourseNumber"));
            exam.setTerm(rs.getString("Term"));
            exam.setExamInfo(rs.getString("ExamInfo"));
            
            exams.add(exam);
 
        }
 
        // close resources
        rs.close();
        pstmt.close();
        connect.close();
 
        return exams;
 
    }
}
