package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/*
public class ChangeStudent {
    private static final String[] ChangeTitle = {"姓名","密码","班级","语文成绩","数学成绩","英语成绩","物理成绩","化学成绩","生物成绩"};

    public static TextField[] messageText = new TextField[ChangeTitle.length];
    public static Button okButton = new Button("确定");

    static public VBox GetChangeBox(Student student){
        VBox changeBox = new VBox(10);
        changeBox.setAlignment(Pos.CENTER);

        messageText[0] = new TextField(student.name);
        messageText[1] = new TextField(student.password);
        messageText[2] = new TextField(student.classes);
        messageText[3] = new TextField(String.valueOf(student.Chinese));
        messageText[4] = new TextField(String.valueOf(student.Math));
        messageText[5] = new TextField(String.valueOf(student.English));
        messageText[6] = new TextField(String.valueOf(student.Physics));
        messageText[7] = new TextField(String.valueOf(student.Chemistry));
        messageText[8] = new TextField(String.valueOf(student.Biology));

        int i = 0;
        for(String string: ChangeTitle) {
            messageText[i].setFont(new Font("楷体", 20));
            messageText[i].setStyle(DataManager.SearchBoxCSS);

            i = AddStudentBox.getI(changeBox, i, string, messageText);
        }

        //按钮
        okButton.setFont(new Font("楷体", 50));

        changeBox.getChildren().add(okButton);

        return changeBox;
    }
}
*/