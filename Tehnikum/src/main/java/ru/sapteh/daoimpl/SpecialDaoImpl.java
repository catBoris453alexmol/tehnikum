package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Faculty;
import ru.sapteh.model.Special;

import java.util.List;

public class SpecialDaoImpl implements DAO<Special, Integer> {
    private final SessionFactory factory;
    public SpecialDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Special special) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(special);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Special special) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(special);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Special> readByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Special ", Special.class).list();
        }
    }

    @Override
    public void delete(Special special) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(special);
            session.getTransaction().commit();
        }
    }
}
