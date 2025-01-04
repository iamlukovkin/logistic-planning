package ru.iamlukovkin.logistic.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.iamlukovkin.logistic.models.Consumer;
import ru.iamlukovkin.logistic.models.Transaction;
import ru.iamlukovkin.logistic.models.Wallet;
import ru.iamlukovkin.logistic.util.ConsumerFactory;

import java.util.Currency;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TransactionRepositoryTest {

    private static Long transactionId;
    private TransactionRepository repository;

    @BeforeEach
    public void init() {
        repository = new TransactionRepository();
        transactionId = 1L;
    }

    private Consumer createConsumer() {
        return ConsumerFactory.getInstance().create();
    }

    private Wallet createWallet(Consumer consumer) {
        return Wallet.builder()
                .consumer(consumer)
                .currency(Currency.getInstance(Locale.US))
        .build();
    }

    @Test
    public void createNewTransactionTest() {
        var consumer = createConsumer();
        var receiver = createWallet(consumer);
        var sender = createWallet(consumer);
        Transaction transaction = new Transaction(++transactionId, receiver, sender, 100.0);
        assertDoesNotThrow(() -> repository.create(transaction));
    }
}
