package personal.jmsalcido.repository;

import personal.jmsalcido.model.Statistics;
import personal.jmsalcido.model.Transaction;

import java.util.List;

public interface StatisticsRepository {

    Statistics getStatistics();

    void calculateStatisticsWithTransactions(List<Transaction> transactions);

}
