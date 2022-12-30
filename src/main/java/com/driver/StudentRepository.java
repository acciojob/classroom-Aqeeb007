package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String,Teacher> teacherHashMap;
    HashMap<String, List<String>> teacherPair;

    public StudentRepository() {
        this.studentHashMap = new HashMap<>();
        this.teacherHashMap = new HashMap<>();
        this.teacherPair = new HashMap<String,List<String>>();
    }


    void addStudent(Student student){
        String name = student.getName();
        studentHashMap.put(name,student);
    }

    void addTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherHashMap.put(name,teacher);
    }

    void addStudentTeacherPair(String student,String teacher){
        if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher)){
            List<String> curteacherStudents = new ArrayList<>();

            if (teacherPair.containsKey(teacher)){
                curteacherStudents = teacherPair.get(teacher);
            }

            curteacherStudents.add(student);
            teacherPair.put(teacher,curteacherStudents);
        }
    }

    Student getStudentByName(String name){
        Student s = studentHashMap.get(name);
        return s;
    }

    Teacher getTeacherByName(String name){
        Teacher t = teacherHashMap.get(name);
        return t;
    }

    public List<String> getStudentsByTeacherName(String teacher){
        List<String> s = new ArrayList<String>();
        if(teacherPair.containsKey(teacher)){
            s = teacherPair.get(teacher);
        }
        return s;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(teacherPair.keySet());
    }

    public void deleteTeacherByName(String teacher){
        List<String> students = new ArrayList<String>();

        if(teacherPair.containsKey(teacher)){
            students = teacherPair.get(teacher);

            for(String s : students){
                if(studentHashMap.containsKey(s)){
                    studentHashMap.remove(s);
                }
            }
            teacherPair.remove(teacher);
        }
        if(teacherHashMap.containsKey(teacher)){
            teacherHashMap.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        HashSet<String> movieSet = new HashSet<>();
        teacherHashMap = new HashMap<>();

        for(String d : teacherPair.keySet()){
            for (String movie : teacherPair.keySet()){
                movieSet.add(movie);
            }
        }

        for(String m : movieSet){
            if(studentHashMap.containsKey(m)) {
                studentHashMap.remove(m);
            }
        }

        teacherPair = new HashMap<>();
    }
}
