package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoginScene {

    public static Button loginButton = new Button("登录");
    public static TextField username = new TextField("请输入账号");
    public static PasswordField password = new PasswordField();
    public static Student thisStudent;

    static public Scene getLoginScene() throws FileNotFoundException {
        GridPane loginGridPane = new GridPane();

        String backgroundPath = "src/main/resources/images/bg-4.png";
        Background background = getBackground(backgroundPath,DataManager.StageWidth,DataManager.StageHeight);
        loginGridPane.setBackground(background);
        loginGridPane.setHgap((float)DataManager.StageWidth/5); // 设置行间距
        loginGridPane.setVgap((float)DataManager.StageHeight/20); // 设置列间距


        Text titleText = new Text("统一登陆界面");
        titleText.setFont(Font.font("楷体", FontWeight.BOLD,155));
        titleText.setFill(Color.PINK);
        HBox titleHBox = new HBox();
        titleHBox.setPadding(new Insets(30,0,0,30)); //上右下左
        titleHBox.getChildren().add(titleText);

        //账号
        Label usernameLabel = new Label("账号");
        HBox usernameHBox = CreateHBox(usernameLabel, username);

        //密码
        Label passwordLabel = new Label("密码");
        HBox passwordHBox = CreateHBox(passwordLabel, password);

        //按钮
        loginButton.setFont(new Font("楷体", 50));

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(usernameHBox,passwordHBox,loginButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinWidth(DataManager.StageWidth/3);
        vBox.setMinHeight(DataManager.StageHeight*2/3);
        Background vBoxBG = getBackground("src/main/resources/images/result.png", vBox.getWidth(), vBox.getHeight());
        vBox.setBackground(vBoxBG);

        loginGridPane.add(titleHBox,0,0);
        loginGridPane.add(vBox,     1,1);

        return new Scene(loginGridPane);
    }

    private static HBox CreateHBox(Label passwordLabel, TextField password) {
        HBox passwordHBox = new HBox(20);
        passwordHBox.getChildren().addAll(passwordLabel, password);
        passwordLabel.setFont(new Font("楷体", 50));
        passwordLabel.setTextFill(Color.BLUE);
        password.setFont(new Font("楷体", 50));
        passwordHBox.setAlignment(Pos.CENTER);
        return passwordHBox;
    }

    static public boolean OnClickButton(){
        String thisUsername = username.getText();
        String thisPassword = password.getText();

        Student student = DataManager.studentManager.SearchStudent(thisUsername);
        if(student==null){
            PopWindow.showAlert(DataManager.LoginErrorTitle,DataManager.LoginErrorContent);
            return false;
        }
        if(thisPassword.equals(student.password)){
            thisStudent = student;
            return true;
        }
        PopWindow.showAlert(DataManager.LoginErrorTitle,DataManager.LoginErrorContent);
        return false;
    }

    private static Background getBackground(String path,double width,double height) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(path);
        Image image = new Image(input);
        BackgroundSize backgroundSize = new BackgroundSize(width,height,
                false,false,true,true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        return new Background(backgroundImage);
    }
}