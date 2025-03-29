package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //舞台
        stage.setTitle(DataManager.StageTitle);
        stage.setFullScreen(true);

        //注册界面
        Scene loginScene = LoginScene.getLoginScene();

        stage.setScene(loginScene);

        //跳转主界面
        if(LoginScene.loginButton != null) {
            LoginScene.loginButton.setOnAction(event -> {
                if(LoginScene.OnClickButton()) {
                    Scene mainScene;
                    if(LoginScene.thisStudent.isManager) {
                        mainScene = MainScene.GetMainScene();
                    }
                    else {
                        mainScene = StudentMainScene.GetMainScene();
                    }
                    stage.setScene(mainScene);
                    stage.setFullScreen(true);
                }
            });
        }
        int []a= new int[4];
        System.out.println(a.length);
        //退出系统
        MainScene.exitButton.setOnAction(event -> {
            try {
                TxtWriter.WriterTxt(DataManager.txtPath);
                Platform.exit();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //退出系统
        StudentMainScene.exitButton.setOnAction(event -> {
            try {
                TxtWriter.WriterTxt(DataManager.txtPath);
                Platform.exit();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}