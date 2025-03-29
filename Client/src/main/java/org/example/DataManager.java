package org.example;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.io.IOException;

public class DataManager {
    public static double StageWidth;
    public static double StageHeight;

    public static int MinLengthPassword = 5;

    public static String StageTitle = "学生管理系统";

    public static String txtPath = "resources/studentData/student.txt";

    public static String LoginErrorTitle = "登陆失败";
    public static String LoginErrorContent = "学号不存在或密码错误！";

    public static StudentManager studentManager;

    public static String ChoiceBoxCSS = "-fx-font-size: 40px;";
    public static String SearchBoxCSS = "-fx-background-color: pink; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 3px;";
    public static String TableViewCSS = "-fx-font-size: 40px;";

    public static String[] StudentManagerProject = {"学生管理","学生列表","学生查询(精确)","学生查询(模糊)","学生增加","学生删除","学生修改","添加管理员","删除管理员"};
    public static String[] PaintingProject = {"统计图绘制","语文成绩直方图","数学成绩直方图","英语成绩直方图","总成绩直方图"};
    public static String[] SortProject = {"排序科目","语文","数学","英语","物理","化学","生物","总分"};
    public static String[] SortMethodProject  = {"排序方式","升序","降序"};

    public static String[] StudentProject = {"操作列表","查看成绩","修改密码"};

    static {
        try {
            studentManager = new StudentManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Screen screen = Screen.getPrimary();

        // 获取屏幕的可视区域
        Rectangle2D bounds = screen.getVisualBounds();

        StageWidth = bounds.getWidth();
        StageHeight = bounds.getHeight();
    }
}