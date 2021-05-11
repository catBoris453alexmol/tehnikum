package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Faculty;
import ru.sapteh.model.Student;

import java.util.List;

public class StudentDaoImpl implements DAO<Student, Integer> {
    private final SessionFactory factory;
    public StudentDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Student student) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Student student) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Student> readByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Student ", Student.class).list();
        }
    }

    @Override
    public void delete(Student student) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }
}
