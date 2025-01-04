package ru.iamlukovkin.logistic.repository;

import ru.iamlukovkin.logistic.models.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ivanlukovkin
 * TODO: replace with real repository
 */
public class TransactionRepository implements CrudRepository<Transaction, Long> {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void create(Transaction transaction) {
        if (transaction.getId() == null) {
            throw new IllegalArgumentException("Transaction id must not be null");
        }
        if (read(transaction.getId()) != null) {
            throw new IllegalArgumentException("Transaction with id " + transaction.getId() + " already exists");
        }
        transactions.add(transaction);
    }

    @Override
    public Transaction read(Long id) {
        return transactions.stream().filter(
                transaction -> transaction.getId().equals(id)
        ).findFirst().orElse(null);
    }

    @Override
    public List<Transaction> readAll() {
        return transactions;
    }

    @Override
    public void update(Transaction transaction) {
        var oldTransaction = read(transaction.getId());
        transactions.set(transactions.indexOf(oldTransaction), transaction);
    }

    @Override
    public void delete(Long id) {
        transactions.removeIf(transaction -> transaction.getId().equals(id));
    }
}
