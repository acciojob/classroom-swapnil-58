package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Studentservice {

    @Autowired
    studentrepository studentrepository;

    public void addstudent(Student student){
        studentrepository.addstudent(student);
    }

    public void addteacher(Teacher teacher){
        studentrepository.addteacher(teacher);
    }

    public void createstudentteacherpair(String student,String teacher){
        studentrepository.createpair(student,teacher);
    }

    public Student getstudent(String student){
        return studentrepository.findstudent(student);
    }

    public Teacher getteacher(String teacher){
        return studentrepository.findteacher(teacher);
    }

    public List<String>getstudentbyteacher(String teacher){
        return studentrepository.getstudentsofteacher(teacher);
    }

    public List<String>getallstudent(){
        return studentrepository.getallstudent();
    }
    public void deleteteacher(String teacher){
        studentrepository.deleteteacherandstudent(teacher);
    }
    public void deleteadllteacher(){
        studentrepository.deleteallteacherandstudent();
    }


}
