package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class StudentTableBox {
    static public TableView<Student> getStudentTable(List<Student> studentList){
        TableView<Student> studentTable = new TableView<>();

        TableColumn<Student, String> name = new TableColumn<>("姓名");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> id = new TableColumn<>("学号");
        id.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Student, Integer> Chinese = new TableColumn<>("语文");
        Chinese.setCellValueFactory(new PropertyValueFactory<>("Chinese"));

        TableColumn<Student, Integer> Math = new TableColumn<>("数学");
        Math.setCellValueFactory(new PropertyValueFactory<>("Math"));

        TableColumn<Student, Integer> English = new TableColumn<>("英语");
        English.setCellValueFactory(new PropertyValueFactory<>("English"));

        TableColumn<Student, Integer> Physics = new TableColumn<>("物理");
        Physics.setCellValueFactory(new PropertyValueFactory<>("Physics"));

        TableColumn<Student, Integer> Chemistry = new TableColumn<>("化学");
        Chemistry.setCellValueFactory(new PropertyValueFactory<>("Chemistry"));

        TableColumn<Student, Integer> Biology = new TableColumn<>("生物");
        Biology.setCellValueFactory(new PropertyValueFactory<>("Biology"));

        TableColumn<Student, Integer> sumCount = new TableColumn<>("总分");
        sumCount.setCellValueFactory(new PropertyValueFactory<>("sumCount"));

        ObservableList<Student> data = FXCollections.observableArrayList(studentList);

        studentTable.getColumns().addAll(name,id,Chinese,Math,English,Physics,Chemistry,Biology,sumCount);

        studentTable.setItems(data);

        return studentTable;
    }
}
