package ru.iamlukovkin.logistic.repository;

import java.util.List;

public interface CrudRepository<Entity, PrimaryKey> {
    void create(Entity entity);
    Entity read(PrimaryKey primaryKey);
    List<Entity> readAll();
    void update(Entity entity);
    void delete(PrimaryKey primaryKey);
}
