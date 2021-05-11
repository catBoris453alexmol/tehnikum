package ru.sapteh.dao;

import java.util.List;

public interface DAO<Entity, key> {
    void create(Entity entity);
    void update(Entity entity);
    List<Entity> readByAll();
    void delete(Entity entity);
}
