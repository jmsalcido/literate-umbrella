package personal.jmsalcido.service;

import org.springframework.stereotype.Service;
import personal.jmsalcido.model.Statistics;
import personal.jmsalcido.model.Transaction;

@Service
public interface StatisticsService {

    Statistics getStatistics();

    void addTransaction(Transaction transaction);

    void calculateStatistics();
}
