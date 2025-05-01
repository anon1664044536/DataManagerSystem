package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
public class MainScene {

    //当前显示列表
    private static List<Student> OnStudnetList = new ArrayList<>();

    //学生管理选择框
    private static final ChoiceBox<String> studentChoice = creatChoiceBox(DataManager.StudentManagerProject);

    //绘图系统选择框
    private static final ChoiceBox<String> paintingChoice = creatChoiceBox(DataManager.PaintingProject);

    //排序系统选择框
    private static final ChoiceBox<String> sortChoice = creatChoiceBox(DataManager.SortProject);

    //升序降序选择框
    private static final ChoiceBox<String> sortMethodChoice = creatChoiceBox(DataManager.SortMethodProject);

    //降序
    private static final AtomicInteger sortMethod = new AtomicInteger(1);

    //退出按钮
    public static Button exitButton = new Button("退出系统");

    static public Scene GetMainScene(){
        BorderPane borderPane = new BorderPane();

        //选择界面的水平窗口
        HBox choiceHbox = new HBox(10);
        choiceHbox.setBackground(Background.fill(Color.YELLOW));
        choiceHbox.setAlignment(Pos.CENTER);
        choiceHbox.setMinWidth(DataManager.StageWidth);
        choiceHbox.setMinHeight((double) DataManager.StageHeight /10);

        //退出按钮样式
        exitButton.setFont(new Font("楷体", 50));

        //选择框加入布局中
        choiceHbox.getChildren().addAll(studentChoice,sortChoice,sortMethodChoice,paintingChoice,exitButton);

        borderPane.setTop(choiceHbox);

        Pane centerPane = new Pane();
        centerPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        //设置初始中心背景
        HBox center = new HBox();
        center.setBackground(Background.fill(Color.RED));
        borderPane.setCenter(center);

        studentChoice.setOnAction((actionEvent -> {
            switch (studentChoice.getValue()) {
                case "学生列表":
                    OnStudnetList = DataManager.studentManager.StudentList;
                    FlashStudentTable(borderPane);
                    break;
                case "学生查询(精确)":
                    VBox searchBox = SearchStudentBox.GetSearchBox("学号");
                    borderPane.setCenter(searchBox);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String studentID = SearchStudentBox.message.getText();
                        Student student = DataManager.studentManager.SearchStudent(studentID);
                        if (student != null) {
                            List<Student> studentList = new ArrayList<>();
                            studentList.add(student);
                            OnStudnetList = studentList;
                            FlashStudentTable(borderPane);
                        } else {
                            PopWindow.showAlert("查找失败", "找不到此学号的同学！");
                        }
                    });
                    break;
                case "学生查询(模糊)":
                    VBox searchBox1 = SearchStudentBox.GetSearchBox("姓名");
                    borderPane.setCenter(searchBox1);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String partName = SearchStudentBox.message.getText();
                        List<Student> studentList = DataManager.studentManager.FuzzySearch(partName);
                        if (!studentList.isEmpty()) {
                            OnStudnetList = studentList;
                            FlashStudentTable(borderPane);
                        } else {
                            PopWindow.showAlert("查找失败", "找不到名字中有此字段的同学！");
                        }
                    });
                    break;
                case "学生增加":
                    VBox addBox = AddStudentBox.GetAddBox();
                    borderPane.setCenter(addBox);
                    AddStudentBox.okButton.setOnAction(actionEvent1 -> {
                        boolean x = false;
                        int index = 0;
                        for (TextField text : AddStudentBox.label) {
                            if ((AddStudentBox.GetText(text, index)).isEmpty()) {
                                x = false;
                                break;
                            } else {
                                x = true;
                            }
                            index++;
                        }
                        if (x) {
                            if (DataManager.studentManager.SearchStudent(AddStudentBox.label[1].getText()) != null) {
                                PopWindow.showAlert("操作失败", "已经有该学号的学生！");
                                x = false;
                            }
                            if (x) {
                                Student newStudent = getNewStudent(AddStudentBox.label, null);
                                DataManager.studentManager.StudentList.add(newStudent);
                                PopWindow.showInfoAlert("操作成功", "成功添加" + AddStudentBox.label[0].getText() + "同学！");
                            }
                        } else {
                            PopWindow.showAlert("输入错误", "有数据为空的栏目！");
                        }
                    });
                    break;
                case "学生删除":
                    VBox deleteBox = SearchStudentBox.GetSearchBox("学号");
                    borderPane.setCenter(deleteBox);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String studentID = SearchStudentBox.message.getText();
                        Student student = DataManager.studentManager.SearchStudent(studentID);
                        if (student != null) {
                            DataManager.studentManager.StudentList.remove(student);
                            PopWindow.showInfoAlert("操作成功", "成功删除" + student.name + "同学！");
                        } else {
                            PopWindow.showAlert("查找失败", "找不到此学号的同学！");
                        }
                    });
                    break;
                case "学生修改":
                    VBox searchTargetBox = SearchStudentBox.GetSearchBox("学号");
                    borderPane.setCenter(searchTargetBox);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String studentID = SearchStudentBox.message.getText();
                        Student student = DataManager.studentManager.SearchStudent(studentID);
                        if (student != null) {
                            VBox changeBox = ChangeStudent.GetChangeBox(student);
                            borderPane.setCenter(changeBox);
                            ChangeStudent.okButton.setOnAction(actionEvent2 -> {
                                Student newStudent = getNewStudent(ChangeStudent.messageText, student);
                                int index = DataManager.studentManager.StudentList.indexOf(student);
                                if (index != -1) {
                                    // 修改元素
                                    DataManager.studentManager.StudentList.set(index, newStudent);
                                    PopWindow.showInfoAlert("操作成功", "成功修改学号为" + student.username + "的同学！");
                                }
                            });
                        } else {
                            PopWindow.showAlert("操作失败", "找不到此学号的同学！");
                        }
                    });
                    break;
                case "添加管理员":
                    VBox addManagerBox = SearchStudentBox.GetSearchBox("学号");
                    borderPane.setCenter(addManagerBox);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String studentID = SearchStudentBox.message.getText();
                        Student student = DataManager.studentManager.SearchStudent(studentID);
                        if (student != null) {
                            if(student.isManager){
                                PopWindow.showAlert("操作失败", student.name+"同学已经成为管理员！");
                            }
                            else {
                                student.isManager = true;
                                PopWindow.showInfoAlert("操作成功", "成功将" + student.name + "同学变成管理员");
                            }
                        }
                        else {
                            PopWindow.showAlert("操作失败", "找不到此学号的同学！");
                        }
                    });
                    break;
                case "删除管理员":
                    VBox deleteManagerBox = SearchStudentBox.GetSearchBox("学号");
                    borderPane.setCenter(deleteManagerBox);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String studentID = SearchStudentBox.message.getText();
                        Student student = DataManager.studentManager.SearchStudent(studentID);
                        if (student != null) {
                            if(!student.isManager){
                                PopWindow.showAlert("操作失败", student.name+"同学不是管理员！");
                            }
                            else {
                                student.isManager = false;
                                PopWindow.showInfoAlert("操作成功", "成功将" + student.name + "同学取消管理员");
                            }
                        }
                        else {
                            PopWindow.showAlert("操作失败", "找不到此学号的同学！");
                        }
                    });
                    break;
            }
        }));

        sortMethodChoice.setOnAction((actionEvent3 -> {
            if(!sortChoice.getValue().equals(DataManager.SortProject[0])&&!sortMethodChoice.getValue().equals(DataManager.SortMethodProject[0])){
                switch (sortMethodChoice.getValue()) {
                    case "升序":
                        sortMethod.set(0);
                        SortByMethod();
                        FlashStudentTable(borderPane);
                        break;
                    case "降序":
                        sortMethod.set(1);
                        SortByMethod();
                        FlashStudentTable(borderPane);
                        break;
                }
            }
        }));

        sortChoice.setOnAction((actionEvent2 -> {
            if(!sortMethodChoice.getValue().equals(DataManager.SortMethodProject[0])&&!sortChoice.getValue().equals(DataManager.SortProject[0])){
                SortByMethod();
                FlashStudentTable(borderPane);
            }
        }));

        paintingChoice.setOnAction((actionEvent4 -> {
            switch (paintingChoice.getValue()){
                case "语文成绩直方图":
                    List<Integer> ChineseList = new ArrayList<>();
                    for(Student student:DataManager.studentManager.StudentList){
                        ChineseList.add(student.Chinese);
                    }
                    BarChart<String, Number> ChineseChart = PaintingBox.createHistogram(ChineseList,paintingChoice.getValue());
                    borderPane.setCenter(ChineseChart);
                    break;
                case "数学成绩直方图":
                    List<Integer> MathList = new ArrayList<>();
                    for(Student student:DataManager.studentManager.StudentList){
                        MathList.add(student.Math);
                    }
                    BarChart<String, Number> MathChart = PaintingBox.createHistogram(MathList,paintingChoice.getValue());
                    borderPane.setCenter(MathChart);
                    break;
                case "英语成绩直方图":
                    List<Integer> EnglishList = new ArrayList<>();
                    for(Student student:DataManager.studentManager.StudentList){
                        EnglishList.add(student.English);
                    }
                    BarChart<String, Number> EnglishChart = PaintingBox.createHistogram(EnglishList,paintingChoice.getValue());
                    borderPane.setCenter(EnglishChart);
                    break;
                case "总成绩直方图":
                    List<Integer> sumCountList = new ArrayList<>();
                    for(Student student:DataManager.studentManager.StudentList){
                        sumCountList.add(student.sumCount);
                    }
                    BarChart<String, Number> sumCountChart = PaintingBox.createHistogram(sumCountList,paintingChoice.getValue());
                    borderPane.setCenter(sumCountChart);
                    break;
            }
        }));

        return new Scene(borderPane);
    }

    static private Student getNewStudent(TextField[] textList,Student student) {
        int i = 0;
        String name = textList[i++].getText();
        String username;
        if(textList.length == AddStudentBox.label.length) {
            username = textList[i++].getText();
        }
        else{
            username = student.username;
        }
        String password = textList[i++].getText();
        String classes = textList[i++].getText();
        int Chinese = Integer.parseInt(textList[i++].getText());
        int Math = Integer.parseInt(textList[i++].getText());
        int English = Integer.parseInt(textList[i++].getText());
        int Physics = Integer.parseInt(textList[i++].getText());
        int Chemistry = Integer.parseInt(textList[i++].getText());
        int Biology = Integer.parseInt(textList[i++].getText());

        return new Student(name, username, password, classes, Chinese, Math, English, Physics, Chemistry, Biology,0);
    }

    static private ChoiceBox<String> creatChoiceBox(String[] choiceList){

        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.setMinHeight((double) DataManager.StageHeight /12);
        choiceBox.setMinWidth((double) DataManager.StageWidth / 15);
        choiceBox.setStyle(DataManager.ChoiceBoxCSS);

        //设定一个空值
        String emptyValueTitle = choiceList[0];
        choiceBox.getItems().add(emptyValueTitle);

        for(int i = 1;i<choiceList.length;i++) {
            choiceBox.getItems().add(choiceList[i]);
        }

        if(!choiceBox.getItems().isEmpty()){
            choiceBox.setValue(choiceBox.getItems().get(0));
        }

        return choiceBox;
    }

    static private void SortByMethod(){
        switch (sortChoice.getValue()){
            case "语文":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getChinese(), s2.getChinese()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getChinese(), s2.getChinese()));
                        break;
                }
                break;
            case "数学":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getMath(), s2.getMath()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getMath(), s2.getMath()));
                        break;
                }
                break;
            case "英语":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getEnglish(), s2.getEnglish()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getEnglish(), s2.getEnglish()));
                        break;
                }
                break;
            case "物理":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getPhysics(), s2.getPhysics()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getPhysics(), s2.getPhysics()));
                        break;
                }
                break;
            case "化学":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getChemistry(), s2.getChemistry()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getChemistry(), s2.getChemistry()));
                        break;
                }
                break;
            case "生物":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getBiology(), s2.getBiology()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getBiology(), s2.getBiology()));
                        break;
                }
                break;
            case "总分":
                switch (sortMethod.get()){
                    case 0:
                        OnStudnetList.sort((s1, s2) -> Integer.compare(s1.getSumCount(), s2.getSumCount()));
                        break;
                    case 1:
                        OnStudnetList.sort((s2, s1) -> Integer.compare(s1.getSumCount(), s2.getSumCount()));
                        break;
                }
                break;
        }
    }

    static private void FlashStudentTable(BorderPane borderPane){
        if(!sortChoice.getValue().equals(DataManager.SortProject[0])&&!sortMethodChoice.getValue().equals(DataManager.SortMethodProject[0])){
            SortByMethod();
        }

        TableView<Student> StudentTable1 = StudentTableBox.getStudentTable(OnStudnetList);
        StudentTable1.setStyle(DataManager.TableViewCSS);
        borderPane.setCenter(StudentTable1);
    }
}
*/