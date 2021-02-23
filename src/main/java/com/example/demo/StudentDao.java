package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDao {

    private static final Map<String, Student> studentMap = new HashMap<String, Student>();

    static {
        initStudents();
    }
    private static void initStudents(){
        Student stu1 = new Student("Mark Twain", 20,"1001");
        Student stu2 = new Student("James Harden", 22,"1002");

        studentMap.put(stu1.getRegNumber(),stu1);
        studentMap.put(stu2.getRegNumber(),stu2);
    }

   public Student getStudent(String regNumber) {
       return studentMap.get(regNumber);
   }

   public Student addStudent(Student student) {
       studentMap.put(student.getRegNumber(), student);
       return student;
   }

   public Student updateStudent(Student student) {
       studentMap.put(student.getRegNumber(), student);
       return student;
   }

   public void deleteStudent(String regNumber) {
       studentMap.remove(regNumber);
   }

   public List<Student> getAllStudents(){
       Collection<Student> collection = studentMap.values();
       List<Student> students = new ArrayList<Student>();
       students.addAll(collection);
       return students;
   }

}
