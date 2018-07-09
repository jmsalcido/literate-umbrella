package personal.jmsalcido.service;

import org.springframework.stereotype.Service;
import personal.jmsalcido.model.Statistics;
import personal.jmsalcido.model.Transaction;
import personal.jmsalcido.repository.StatisticsRepository;
import personal.jmsalcido.repository.TransactionRepository;

import java.time.Instant;
import java.util.List;

@Service
public class SimpleStatisticsService implements StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final TransactionRepository transactionRepository;

    public SimpleStatisticsService(StatisticsRepository statisticsRepository, TransactionRepository transactionRepository) {
        this.statisticsRepository = statisticsRepository;
        this.transactionRepository = transactionRepository;
    }

    public Statistics getStatistics() {
        return statisticsRepository.getStatistics();
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.addTransaction(transaction);

        // add the transaction to the actual statistics just in case.
        Statistics statistics = getStatistics();
        statistics.add(transaction.getAmount());
    }

    public void calculateStatistics() {
        Instant instant60secondsAgo = Instant.now().minusSeconds(60);
        List<Transaction> filteredTransactions = transactionRepository.findTransactionsAfter(instant60secondsAgo);

        statisticsRepository.calculateStatisticsWithTransactions(filteredTransactions);
    }
}
