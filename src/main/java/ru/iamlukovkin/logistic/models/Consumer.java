package ru.iamlukovkin.logistic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Consumer {
    private Long id;
    private String name;

    public Consumer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
