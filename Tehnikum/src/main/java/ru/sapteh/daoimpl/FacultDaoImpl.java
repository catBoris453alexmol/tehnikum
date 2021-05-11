package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Faculty;

import java.util.List;

public class FacultDaoImpl implements DAO<Faculty, Integer> {
    private final SessionFactory factory;
    public FacultDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Faculty faculty) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Faculty faculty) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(faculty);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Faculty> readByAll() {
       try (Session session = factory.openSession()){
           return session.createQuery("FROM Faculty ", Faculty.class).list();
       }
    }

    @Override
    public void delete(Faculty faculty) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(faculty);
            session.getTransaction().commit();
        }
    }
}
