package personal.jmsalcido.repository;

import org.springframework.stereotype.Repository;
import personal.jmsalcido.model.Transaction;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryTransactionRepository implements TransactionRepository {

    private List<Transaction> transactions;

    public InMemoryTransactionRepository() {
        this.transactions = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> findTransactionsAfter(Instant instant) {
        return transactions.stream()
                .filter(t -> filterTransactionBefore(t, instant))
                .collect(Collectors.toList());
    }

    private boolean filterTransactionBefore(Transaction t, Instant instant) {
        Instant timeStamp = Instant.ofEpochMilli(t.getTimestamp());
        return timeStamp.isAfter(instant);
    }

}
