package ru.sapteh.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Faculty;
import ru.sapteh.model.Perfomance;

import java.util.List;

public class PerfomanceDaoImpl implements DAO<Perfomance, Integer> {
    private final SessionFactory factory;
    public PerfomanceDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Perfomance perfomance) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(perfomance);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Perfomance perfomance) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(perfomance);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Perfomance> readByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Perfomance ", Perfomance.class).list();
        }
    }

    @Override
    public void delete(Perfomance perfomance) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(perfomance);
            session.getTransaction().commit();
        }
    }
}
