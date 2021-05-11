package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Faculty;
import ru.sapteh.model.Object;

import java.util.List;

public class ObjectDaoImpl implements DAO<Object,Integer> {
    private final SessionFactory factory;
    public ObjectDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Object object) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Object object) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Object> readByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Object ", Object.class).list();
        }
    }

    @Override
    public void delete(Object object) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        }
    }
}
