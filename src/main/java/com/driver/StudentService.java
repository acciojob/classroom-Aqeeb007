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

    void addStudentTeacherPair(String teacher,String student){
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    Student getStudentByName(String name){
       return studentRepository.getStudentByName(name);
    }

    Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
