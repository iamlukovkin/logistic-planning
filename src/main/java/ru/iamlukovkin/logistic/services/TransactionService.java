package ru.iamlukovkin.logistic.services;

import ru.iamlukovkin.logistic.models.Transaction;
import ru.iamlukovkin.logistic.models.Wallet;
import ru.iamlukovkin.logistic.repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.repository = transactionRepository;
    }

    public Double getBalance(Wallet wallet) {
        List<Transaction> transactions = repository.readAll();
        List<Transaction> received = transactions.stream().filter(
            transaction -> transaction.getReceiver().equals(wallet)
        ).toList();
        List<Transaction> sent = transactions.stream().filter(
            transaction -> transaction.getSender().equals(wallet)
        ).toList();
        return received.stream().map(Transaction::getAmount).reduce(
            0.0, Double::sum
        ) - sent.stream().map(Transaction::getAmount).reduce(
            0.0, Double::sum);
    }
}
