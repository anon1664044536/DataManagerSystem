package org.example;

import org.example.Student;
import org.example.DataSQL;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TchStuManager {
    public String tchName;
    public ArrayList<String> stuName;
    public ArrayList<String> stuNo;
    public ArrayList<String> courseName;
    public ArrayList<String> grade;

    TchStuManager(String tchName) throws SQLException {
        this.tchName = tchName;
        ResultSet rs = DataSQL.tchSelect(tchName);

        while(rs.next()) {
            stuName.add(rs.getString("StuName"));
            stuNo.add(rs.getString("StuNo"));
            courseName.add(rs.getString("CosName"));
            grade.add(rs.getString("Grade"));
        }
    }

    public void printInfo() {
        System.out.println(tchName);
        for(int i=0; i<stuName.size(); i++) {
            String str = stuName.get(i) + "\t" + stuNo.get(i) + "\t" + courseName.get(i) + "\t" + grade.get(i);
            System.out.println(str);
        }
    }
}
