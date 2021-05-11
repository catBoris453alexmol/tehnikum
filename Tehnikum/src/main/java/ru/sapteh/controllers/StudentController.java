package ru.sapteh.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoimpl.SpecialDaoImpl;
import ru.sapteh.daoimpl.StudentDaoImpl;
import ru.sapteh.model.Special;
import ru.sapteh.model.Student;

import java.io.IOException;
import java.util.List;

public class StudentController {

    private final SessionFactory factory;

    public StudentController(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    private final ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> lastnameColumn;

    @FXML
    private TableColumn<Student, String> firstnameColumn;

    @FXML
    private TableColumn<Student, String> patronumikColumn;

    @FXML
    private TableColumn<Student, Integer> specialColumn;

    @FXML
    private TableColumn<Student, Integer> AverageScoreColumn;

    @FXML
    private Button addStudent;
    @FXML
    void initialize(){
        initDataFromBase();
        initTableView();
    }

    @FXML
    void initDataFromBase(){
        DAO<Student, Integer> studentDaoImpl = new StudentDaoImpl(factory);
        DAO<Special, Integer> specialDaoImpl = new SpecialDaoImpl(factory);
        specialDaoImpl.readByAll();
        List<Student> studentList = studentDaoImpl.readByAll();
        studentObservableList.addAll(studentList);
    }

    @FXML
    void initTableView(){
        studentTable.setItems(studentObservableList);
       idColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getId()));
        firstnameColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getFirstname()));
        lastnameColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getLastname()));
        patronumikColumn.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getPatronumik()));
        specialColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getSpecial().getId()));

    }
    @FXML
    void onactionAddStudent(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/RegStudent.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Registration new client");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(parent));
        stage.showAndWait();
    }
}
