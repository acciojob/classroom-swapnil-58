package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class studentrepository {

    HashMap<String,Student>studentHashMap=new HashMap<>();

    HashMap<String,Teacher>teacherHashMap=new HashMap<>();

    HashMap<String, List<String>> pairHashMap=new HashMap<>();

    public void addstudent(Student student){
        studentHashMap.put(student.getName(),student);
    }

    public void addteacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void createpair(String studentname, String teachername){
        if(!pairHashMap.containsKey(teachername)){
            List<String>studentList=new ArrayList<>();
            studentList.add(studentname);
            pairHashMap.put(teachername,studentList);
        }
        else{
            List<String>studentlist=pairHashMap.get(teachername);
            studentlist.add(studentname);
            pairHashMap.put(teachername,studentlist);
        }
    }

    public Student findstudent(String studentname){
        return studentHashMap.get(studentname);
    }
    public Teacher findteacher(String teachername){
        return teacherHashMap.get(teachername);
    }

    public List<String> getstudentsofteacher(String teachername){
        return pairHashMap.get(teachername);
    }


    //creating a list
    public List<String> getallstudent(){
        List<String> students= new ArrayList<>();

        for (String stName: studentHashMap.keySet()){
            students.add(stName);
        }
        return students;
    }

    public void deleteteacherandstudent(String teachername){
        teacherHashMap.remove(teachername);
        List<String>stList=pairHashMap.get(teachername);
        for(String st:stList){
            studentHashMap.remove(st);
        }
        pairHashMap.remove(teachername);
    }

    public void deleteallteacherandstudent(){
        for(String  t: pairHashMap.keySet()){
            List<String>stList= pairHashMap.get(t);
            for(String st:stList){
                studentHashMap.remove(st);
            }
            teacherHashMap.remove(t);
        }
        pairHashMap.clear();
    }



}
