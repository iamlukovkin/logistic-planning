package ru.iamlukovkin.logistic.util;

public interface AbstractFactory<Entity> {
    Entity create();
}
