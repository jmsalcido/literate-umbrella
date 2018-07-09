package personal.jmsalcido.repository;

import org.springframework.stereotype.Repository;
import personal.jmsalcido.model.Statistics;
import personal.jmsalcido.model.Transaction;

import java.util.List;

@Repository
public class InMemoryStatisticsRepository implements StatisticsRepository {

    private Statistics statistics;

    @Override
    public Statistics getStatistics() {
        if (statistics == null) {
            statistics = new Statistics();
        }

        return statistics;
    }

    @Override
    public void calculateStatisticsWithTransactions(List<Transaction> transactions) {
        statistics = new Statistics();
        transactions.forEach(t -> statistics.add(t.getAmount()));
    }
}
