package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentManager {
    public List<Student> StudentList = new ArrayList<>();

    StudentManager() throws IOException {

        TxtReader.ReadTxt(DataManager.txtPath);

        for(Map<String, String> record:TxtReader.studentData){
            String name = record.get("姓名");
            String username = record.get("学号");
            String password = record.get("密码");
            String classes = record.get("班级");
            int Chinese = Integer.parseInt(record.get("语文"));
            int Math = Integer.parseInt(record.get("数学"));
            int English = Integer.parseInt(record.get("英语"));
            int Physics = Integer.parseInt(record.get("物理"));
            int Chemistry = Integer.parseInt(record.get("化学"));
            int Biology = Integer.parseInt(record.get("生物"));
            int isManager = Integer.parseInt(record.get("管理员权限"));
            Student tempStudent = new Student(name,username,password,classes,Chinese,
                    Math,English,Physics,Chemistry,Biology,isManager);
            StudentList.add(tempStudent);
        }
    }

    public Student SearchStudent(String id){
        for(Student student:StudentList){
            if(id.equals(student.username)){
                return student;
            }
        }
        return null;
    }

    public List<Student> FuzzySearch(String keyword){
        List<Student> studentList = new ArrayList<>();
        for(Student student:StudentList){
            int targetLength = student.name.length();
            int keywordLength = keyword.length();

            for (int i = 0; i <= targetLength - keywordLength; i++) {
                String substring = student.name.substring(i, i + keywordLength);
                if (substring.equalsIgnoreCase(keyword)) {
                    studentList.add(student);
                }
            }
        }

        return studentList;
    }

    public void PrintStudentList(){
        for(Student student:StudentList){
            student.PrintStudent();;
        }
    }
}