package personal.jmsalcido.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import personal.jmsalcido.model.Transaction;
import personal.jmsalcido.service.StatisticsService;

import javax.validation.Valid;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController("/transactions")
public class TransactionController {

    private final StatisticsService statisticsService;

    public TransactionController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping
    public ResponseEntity addTransaction(@RequestBody @Valid Transaction transaction) {
        HttpStatus httpStatus = HttpStatus.CREATED;

        Instant instant = Instant.ofEpochMilli(transaction.getTimestamp());
        Instant instant60secondsAgo = Instant.now().minus(60, ChronoUnit.SECONDS);
        if (instant.isBefore(instant60secondsAgo)) {
            httpStatus = HttpStatus.NO_CONTENT;
        }

        statisticsService.addTransaction(transaction);

        return new ResponseEntity(httpStatus);
    }

}
