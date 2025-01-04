package ru.iamlukovkin.logistic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    private Consumer consumer;
    private String name;
    private Currency currency;
}
