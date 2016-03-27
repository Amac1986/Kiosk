/**
 * Author:  Matthew HIebert
 * Created: 26-Mar-2016
 */

CREATE TABLE exams (
ExamID int NOT NULL AUTO_INCREMENT,
Department varchar(50) NOT NULL,
CourseNumber varchar(20) NOT NULL,
Term varchar(10) NOT NULL,
ExamInfo varchar(255) NOT NULL,
EnrolledStudents text;
PRIMARY KEY (ExamID)
);