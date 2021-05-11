package ru.sapteh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoimpl.StudentDaoImpl;
import ru.sapteh.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program extends Application {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        DAO<Student, Integer> studentDao = new StudentDaoImpl(factory);
//        List<Student> students = new ArrayList<>();
//        students.addAll(studentDao.readByAll());
//        System.out.println(students);
        @Override
        public void start(Stage stage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
            stage.setTitle("Tabel");
            stage.setScene(new Scene(root));
            stage.show();
        }

    public static void main(String[] args) {
        launch(args);
    }
    }

