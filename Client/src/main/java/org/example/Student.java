package org.example;

public class Student {
    public String name;
    public String username;
    public String password;
    public String classes;
    public int Chinese;
    public int Math;
    public int English;
    public int Physics;
    public int Chemistry;
    public int Biology;
    public int sumCount;
    public boolean isManager;


    Student(String name,String username,String password,String classes,
            int Chinese,int Math,int English,int Physics,int Chemistry,int Biology,int isManager){
        this.name = name;
        this.username = username;
        this.password = password;
        this.classes = classes;
        this.Chinese = Chinese;
        this.Math = Math;
        this.English = English;
        this.Physics = Physics;
        this.Chemistry = Chemistry;
        this.Biology = Biology;
        this.sumCount = Chinese+Math+English+Physics+Chemistry+Biology;
        this.isManager = (isManager == 1);
    }

    public String getName(){
        return this.name;
    }

    public String getUsername(){
        return this.username;
    }

    public int getChinese(){
        return this.Chinese;
    }

    public int getMath(){
        return this.Math;
    }

    public int getEnglish(){
        return this.English;
    }

    public int getPhysics(){
        return this.Physics;
    }

    public int getChemistry(){
        return this.Chemistry;
    }

    public int getBiology(){
        return this.Biology;
    }

    public int getSumCount(){
        return this.sumCount;
    }

    @Override
    public String toString(){
        String string = name+"\t"+username+"\t"+password+"\t"+classes+ "\t"+Chinese+
                "\t"+Math+"\t"+English+"\t"+Physics+"\t"+Chemistry+"\t"+Biology+"\t";
        if(isManager){
            string += "1";
        }
        else {
            string += "0";
        }
        return string;
    }

    public void PrintStudent(){
        System.out.println("姓名："+name);
        System.out.println("学号："+username);
        System.out.println("密码："+password);
        System.out.println("班级："+classes);
        System.out.println("总分："+sumCount);
        System.out.println("-----------------------------------------");
    }
}