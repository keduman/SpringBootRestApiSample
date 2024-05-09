package com.example.demo;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDao {

    private final Map<String, Student> studentMap;

    @Autowired
    public StudentDao(HazelcastInstance hazelcastInstance) {
        studentMap = hazelcastInstance.getMap("students");
        initStudents();
    }
    public void initStudents(){
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

    public Map<String, Student> getCacheContent() {
        return studentMap;
    }

}
