package kiosk;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
                   searchId,
                   searchCourseNumber,
                   appointmentType;
    private Date advisingDate;
    private List<String> selectedTimes;
    
    public KioskDataBean() {
        searchDepartment = "";
        searchId = "";
    }
    
    public String getSearchDepartment() { return searchDepartment; }
    public void setSearchDepartment(String s) { searchDepartment = s; }
    
    public String getSearchId() { return searchId; }
    public void setSearchId(String s) { searchId = s; }
    
    public String getSearchCourseNumber() { return searchCourseNumber; }
    public void setSearchCourseNumber(String s) { searchCourseNumber = s; }
    
    public String getAppointmentType() { return appointmentType; }
    public void setAppointmentType(String a) { appointmentType = a; }
    
    public Date getAdvisingDate() { return advisingDate; }
    public void setAdvisingDate(Date d) { advisingDate = d; }
    
    public List<String> getSelectedTimes() { return selectedTimes; }
    public void setSelectedTimes(List<String> s) { selectedTimes = s; }
    
    public List<Exam> getExams() throws ClassNotFoundException, SQLException {
 
        Connection connect = null;
 
        String url = "jdbc:mysql://localhost:3306/uw_kiosk";
        String username = "mhiebert";
        String password = "3060402ACS!";
        String statement;
        
        try {
 
            Class.forName("com.mysql.jdbc.Driver");
 
            connect = DriverManager.getConnection(url, username, password);
            // System.out.println("Connection established"+connect);
 
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
 
        List<Exam> exams = new ArrayList<>();
        
        statement = "SELECT Department, CourseNumber, Term, ExamInfo FROM exams WHERE " +
                "(CourseNumber LIKE '%" + searchDepartment + "%') AND " +
                "(CourseNumber LIKE '%" + searchCourseNumber + "%') AND " + 
                "(EnrolledStudents LIKE '%" + searchId + "%')";
        
        PreparedStatement pstmt = connect.prepareStatement(statement);
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
        
        //searchDepartment = "";
        //searchId = "";
 
        return exams;
 
    }
    
    public Date getToday() {
        return new Date();
    }
    
    public List<String> getTimeOptions() {
        List<String> times = new ArrayList<>();
        
        times.add("9:00am - 10:00am");
        times.add("10:00am - 11:00am");
        times.add("11:00am - 12:00pm");
        times.add("12:00pm - 1:00pm");
        times.add("1:00pm - 2:00pm");
        times.add("2:00pm - 3:00pm");
        times.add("3:00pm - 4:00pm");
        times.add("4:00pm - 5:00pm");
        
        return times;
    }
    
    public String getAppointmentDialog() {
        StringBuilder text = new StringBuilder();
        
        text.append("Appointment type: ");
        text.append(appointmentType);
        text.append("Date: ");
        text.append(advisingDate);
        text.append("Selected times: ");
        
        for (int i = 0; i<selectedTimes.size(); i++) {
            text.append(selectedTimes.get(i));
            if (i < selectedTimes.size() - 1)
                text.append(", ");
        }
        
        return text.toString();
    }
}
