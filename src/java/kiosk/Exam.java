package kiosk;

/**
 *
 * @author Matt
 */
public class Exam {
    private String department;
    private String courseNumber;
    private String term;
    private String examInfo;
    
    public Exam() {}
    
    public String getDepartment() { return department; }
    public void setDepartment(String d) { department = d; }
    
    public String getCourseNumber() { return courseNumber; }
    public void setCourseNumber(String c) { courseNumber = c; }
    
    public String getTerm() { return term; }
    public void setTerm(String t) { term = t; }
    
    public String getExamInfo() { return examInfo; }
    public void setExamInfo(String e) { examInfo = e; }
}
