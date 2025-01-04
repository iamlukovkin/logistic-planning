package ru.iamlukovkin.logistic.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Wallet receiver;
    private Wallet sender;
    private Double amount;
}
