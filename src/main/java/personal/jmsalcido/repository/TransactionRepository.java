package personal.jmsalcido.repository;

import personal.jmsalcido.model.Transaction;

import java.time.Instant;
import java.util.List;

public interface TransactionRepository {

    void addTransaction(Transaction transaction);

    List<Transaction> findTransactionsAfter(Instant instant);
}
