package ru.sapteh.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoimpl.FacultDaoImpl;
import ru.sapteh.daoimpl.SpecialDaoImpl;
import ru.sapteh.daoimpl.StudentDaoImpl;
import ru.sapteh.model.Faculty;
import ru.sapteh.model.Special;
import ru.sapteh.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegStudentController {

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    ObservableList<Special> specialList = FXCollections.observableArrayList();
    ObservableList<Faculty> FacultyList = FXCollections.observableArrayList();

    @FXML
    private Button addStudent;

    @FXML
    private TextField txtlastName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtPatronumik;

    @FXML
    private Label lblInfo;

    @FXML
    private ComboBox<Special> SpecialList;

    @FXML
    private TextField txtCource;

    @FXML
    private TextField txtGroup;

    @FXML
    private ComboBox<Faculty> listFacult;

    @FXML
    private DatePicker dateReceipt;

    public void initialize() throws ParseException {
        DAO<Special, Integer> specialDao =  new SpecialDaoImpl(factory);
        specialList.addAll(specialDao.readByAll());
        SpecialList.setItems(specialList);
        DAO<Faculty, Integer> FacultyDao =  new FacultDaoImpl(factory);
        FacultyList.addAll(FacultyDao.readByAll());
        listFacult.setItems(FacultyList);



    }
    @FXML
    void onactionAdd(ActionEvent event) throws ParseException {
        DAO<Student, Integer> studentDao = new StudentDaoImpl(factory);
        Student student = new Student();

        student.setFirstname(txtFirstName.getText());
        student.setLastname(txtlastName.getText());
        student.setPatronumik(txtPatronumik.getText());
        student.setSpecial(SpecialList.getValue());
        student.setCourse(Integer.parseInt(txtCource.getText()));
       student.setFaculty(listFacult.getValue());
       student.setNumber_group(txtGroup.getText());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date receipt = format.parse(String.valueOf(dateReceipt.getValue()));
        student.setDate_of_receipt(receipt);
        studentDao.create(student);

      lblInfo.setTextFill(Color.GREEN);
      lblInfo.setText("Пользователь добавлен:)");
    }

}

