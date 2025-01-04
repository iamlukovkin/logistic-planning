package ru.iamlukovkin.logistic.service;

import org.junit.jupiter.api.Test;
import ru.iamlukovkin.logistic.models.Transaction;
import ru.iamlukovkin.logistic.models.Wallet;
import ru.iamlukovkin.logistic.repository.TransactionRepository;
import ru.iamlukovkin.logistic.services.TransactionService;
import ru.iamlukovkin.logistic.util.ConsumerFactory;

import java.util.Currency;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionServiceTest {

    @Test
    public void rightBalanceTest() {
        var repository = new TransactionRepository();
        var service = new TransactionService(repository);
        var consumer = ConsumerFactory.getInstance().create();
        var receiver = Wallet.builder()
                .consumer(consumer)
                .name("receiver")
                .currency(Currency.getInstance(Locale.US))
                .build();
        var sender = Wallet.builder()
                .consumer(consumer)
                .name("sender")
                .currency(Currency.getInstance(Locale.US))
                .build();
        var amount = 100.0;
        var transaction = new Transaction(1L, receiver, sender, amount);
        repository.create(transaction);
        Double received = service.getBalance(receiver);
        Double serviceBalance = service.getBalance(sender);
        assertEquals(amount, received);
        assertEquals(-amount, serviceBalance);
    }
}
