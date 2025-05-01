package org.example;

import java.util.Map;

public class Student {
    public String name;
    public String username;
    public String sex;
    public String department;
    public int age;
    Map<String, String> courseGrade;

    Student(String name,String username,String sex, String department, int age, Map<String, String> courseGrade) {
        this.name = name;
        this.username = username;
        this.sex = sex;
        this.department = department;
        this.age = age;
        this.courseGrade = courseGrade;
    }

    public String getName(){
        return this.name;
    }

    public String getUsername(){
        return this.username;
    }

    public String getSex() { return this.sex; };

    public String getDepartment() { return this.department; }
    ;
    public int getAge() { return this.age; }

    public Map<String, String> getCourseGrade() { return this.courseGrade; }

    @Override
    public String toString(){
        String string = name + "\t" + username + "\t" + sex + "\t" + department + "\t" + age;

        for(Map.Entry<String, String> eachCourse : courseGrade.entrySet()) {
            String courseName = eachCourse.getKey();
            String courseGrade = eachCourse.getValue();
            string = string + "\t" + courseName + "\t" + courseGrade;
        }
        return string;
    }

    public void PrintStudent(){
        System.out.println("姓名："+ name);
        System.out.println("学号："+ username);
        System.out.println("性别："+ sex);
        System.out.println("专业："+ department);
        System.out.println("年龄："+ age);
        for(Map.Entry<String, String> eachCourse : courseGrade.entrySet()) {
            String courseName = eachCourse.getKey();
            String courseGrade = eachCourse.getValue();
            System.out.println(courseName + "：" + courseGrade);
        }
        System.out.println("-----------------------------------------");
    }
}