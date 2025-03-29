package org.example;

import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaintingBox {
    static public BarChart<String, Number> createHistogram(List<Integer> scoreList,String chartTitle) {
        // 使用 TreeMap 统计每个分数段的频率
        Map<String, Integer> scoreDistribution = new TreeMap<>();
        for (int score : scoreList) {
            String range = getScoreRange(score);
            scoreDistribution.put(range, scoreDistribution.getOrDefault(range, 0) + 1);
        }

        // 创建X轴和Y轴
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("分数段");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("人数");

        // 创建条形图
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle(chartTitle);

        // 创建数据系列
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("人数");

        // 将数据添加到数据系列
        for (Map.Entry<String, Integer> entry : scoreDistribution.entrySet()) {
            XYChart.Data<String, Number> data = new XYChart.Data<>(entry.getKey(), entry.getValue());

            // 创建标签并将其放置在柱形的上方
            Label label = new Label(String.valueOf(entry.getValue()));
            label.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

            // 使用 StackPane 将标签放置在数据点上方
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(label);
            stackPane.setAlignment(Pos.TOP_CENTER);
            stackPane.setTranslateY(-10); // 调整标签位置

            data.setNode(stackPane);

            series.getData().add(data);
        }

        // 将数据系列添加到条形图
        barChart.getData().add(series);

        return barChart;
    }

    private static String getScoreRange(int score) {
        int rangeStart = (score / 10) * 10;
        int rangeEnd = rangeStart + 9;
        return rangeStart + "-" + rangeEnd;
    }
}
