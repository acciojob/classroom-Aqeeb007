package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap = new HashMap<>();
    HashMap<String,Teacher> teacherHashMap  = new HashMap<>();
    HashMap<String, List<String>> teacherPair = new HashMap<>();

    void addStudent(Student student){
        String name = student.getName();
        studentHashMap.put(name,student);
    }

    void addTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherHashMap.put(name,teacher);
    }

    void addStudentTeacherPair(String teacher,String student){
        List<String> studentsList = new ArrayList<>();
        if(teacherPair.containsKey(teacher)){
            studentsList = teacherPair.get(teacher);
            studentsList.add(student);
            teacherPair.put(teacher, studentsList);
        }
        else{
            studentsList.add(student);
            teacherPair.put(teacher,studentsList);
        }
    }

    Student getStudentByName(String name){
        for(String sName : studentHashMap.keySet()){
            if(sName.equals(name)){
                return studentHashMap.get(sName);
            }
        }
        return null;
    }

    Teacher getTeacherByName(String name){
        for(String tName : teacherHashMap.keySet()){
            if(tName.equals(name)){
                return teacherHashMap.get(tName);
            }
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher){
        List<String> s = new ArrayList<>();
        if(teacherPair.containsKey(teacher)){
            s = teacherPair.get(teacher);
        }
        return s;
    }

    public List<String> getAllStudents(){
        List<String> studentsList = new ArrayList<>();
        for(String sName : studentHashMap.keySet()){
            studentsList.add(sName);
        }
        return studentsList;
    }

    public void deleteTeacherByName(String teacher){
        List<String> studentsList = new ArrayList<>();

        if(teacherPair.containsKey(teacher)){
            studentsList = teacherPair.get(teacher);

            for(String s : studentsList){
                if(studentHashMap.containsKey(s)){
                    studentHashMap.remove(s);
                }
            }
            if(teacherHashMap.containsKey(teacher)){
                teacherHashMap.remove(teacher);
            }
        }
            teacherHashMap.remove(teacher);
    }

    public void deleteAllTeachers(){
        teacherHashMap = new HashMap<>();
        HashSet<String> studentSet = new HashSet<>();
        for(String tName : teacherPair.keySet()){
            for(String sName : teacherPair.get(tName)){
                studentSet.add(sName);
            }
        }

        for(String sName : studentSet){
            if(studentHashMap.containsKey(sName)){
                studentHashMap.remove(sName);
            }
        }

        teacherPair = new HashMap<>();
    }
}
