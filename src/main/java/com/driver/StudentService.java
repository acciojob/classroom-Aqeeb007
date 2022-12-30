package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;



    void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    void addStudentTeacherPair(String student,String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    Student getStudentByName(String name){
        Student s = studentRepository.getStudentByName(name);
        return s;
    }

    Teacher getTeacherByName(String name){
        Teacher t = studentRepository.getTeacherByName(name);
        return t;
    }

    public List<String> getStudentsByTeacherName(String teacher){
        List<String> s = new ArrayList<String>();
        s = studentRepository.getStudentsByTeacherName(teacher);
        return s;
    }

    public List<String> getAllStudents(){
        List<String> s = new ArrayList<String>();
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
