package ru.iamlukovkin.logistic.util;

import com.github.javafaker.Faker;
import ru.iamlukovkin.logistic.models.Consumer;

public class ConsumerFactory implements AbstractFactory<Consumer> {

    private static ConsumerFactory instance;
    private final Faker faker = new Faker();
    private static Long id = 1L;

    private ConsumerFactory() {}

    @Override
    public Consumer create() {
        return new Consumer(id++, faker.name().firstName());
    }

    public static ConsumerFactory getInstance() {
        if (instance == null) {
            instance = new ConsumerFactory();
        }
        return instance;
    }

}
