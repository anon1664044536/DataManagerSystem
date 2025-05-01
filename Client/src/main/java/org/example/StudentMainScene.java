package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
/*
public class StudentMainScene {
    //学生管理选择框
    private static final ChoiceBox<String> studentChoice = creatChoiceBox(DataManager.StudentProject);

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
        choiceHbox.getChildren().addAll(studentChoice,exitButton);

        borderPane.setTop(choiceHbox);

        Pane centerPane = new Pane();
        centerPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        //设置初始中心背景
        HBox center = new HBox();
        center.setBackground(Background.fill(Color.RED));
        borderPane.setCenter(center);

        studentChoice.setOnAction((actionEvent -> {
            switch (studentChoice.getValue()) {
                case "查看成绩":
                    List<Student> students = new ArrayList<>();
                    students.add(LoginScene.thisStudent);
                    TableView<Student> StudentTable = StudentTableBox.getStudentTable(students);
                    StudentTable.setStyle(DataManager.TableViewCSS);
                    borderPane.setCenter(StudentTable);
                    break;
                case "修改密码":
                    VBox changePasswordBox = SearchStudentBox.GetSearchBox("新密码");
                    borderPane.setCenter(changePasswordBox);
                    SearchStudentBox.okButton.setOnAction(actionEvent1 -> {
                        String newPassword = SearchStudentBox.message.getText();
                        if(newPassword.equals(LoginScene.thisStudent.password)){
                            PopWindow.showAlert("操作失败","新密码不能与旧密码相同！");
                        }

                        else if(newPassword.equals("请输入新密码") || newPassword.isEmpty()){
                            PopWindow.showAlert("操作失败","新密码不能为空！");
                        }

                        else if(newPassword.length() <= DataManager.MinLengthPassword){
                            PopWindow.showAlert("操作失败","密码不能小于5位！");
                        }

                        else {
                            LoginScene.thisStudent.password = newPassword;
                            PopWindow.showInfoAlert("操作成功", "密码已经被修改！");
                        }
                    });
                    break;
            }
        }));

        return new Scene(borderPane);
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
}
*/