package com.example.demo;

public class Student {

    String name;
    int age;
    String regNumber;

    public Student() {
    }

    public Student(String name, int age, String regNumber) {
        this.name = name;
        this.age = age;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
