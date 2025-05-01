package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/*
public class AddStudentBox {
    private static final String[]  AddTitle = {"姓名","学号","密码","班级","语文成绩","数学成绩","英语成绩","物理成绩","化学成绩","生物成绩"};
    public static TextField[] label = new TextField[10];

    public static Button okButton = new Button("确定");

    static {
        int i = 0;
        for(String string:AddTitle){
            label[i] = new TextField("请输入" +string);
            label[i].setFont(new Font("楷体", 20));
            label[i].setStyle(DataManager.SearchBoxCSS);
            i++;
        }
    }

    static public VBox GetAddBox(){
        VBox addBox = new VBox(10);
        addBox.setAlignment(Pos.CENTER);

        int i = 0;
        for(String string:AddTitle) {
            i = getI(addBox, i, string, label);
        }

        //按钮
        okButton.setFont(new Font("楷体", 50));

        addBox.getChildren().add(okButton);

        return addBox;
    }

    static int getI(VBox addBox, int i, String string, TextField[] label) {
        Label hintLabel = new Label(string);
        hintLabel.setFont(new Font("楷体", 20));
        hintLabel.setTextFill(Color.BLUE);

        HBox rowArea = new HBox(10);
        rowArea.setAlignment(Pos.CENTER);
        rowArea.getChildren().addAll(hintLabel, label[i]);

        addBox.getChildren().add(rowArea);

        i++;
        return i;
    }

    static public String GetText(TextField text, int index){
        if (text.getText().equals("请输入" + AddTitle[index])) {
            return "";
        }
        return text.getText();
    }
}*/