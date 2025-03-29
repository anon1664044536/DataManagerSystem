package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SearchStudentBox {
    public static Button okButton = new Button("确定");
    public static TextField message;

    static public VBox GetSearchBox(String MessageType) {
        VBox searchVBox = new VBox(10);
        searchVBox.setAlignment(Pos.CENTER);

        //输入框
        message = new TextField("请输入"+MessageType);
        message.setFont(new Font("楷体", 50));
        message.setStyle(DataManager.SearchBoxCSS);
        //文字提示
        Label usernameLabel = new Label(MessageType);
        usernameLabel.setFont(new Font("楷体", 50));
        usernameLabel.setTextFill(Color.BLUE);

        //按钮
        okButton.setFont(new Font("楷体", 50));

        HBox inputArea = new HBox(10);
        inputArea.getChildren().addAll(usernameLabel,message);
        inputArea.setAlignment(Pos.CENTER);

        searchVBox.getChildren().addAll(inputArea,okButton);
        searchVBox.setStyle(DataManager.SearchBoxCSS);
        return searchVBox;
    }
}
