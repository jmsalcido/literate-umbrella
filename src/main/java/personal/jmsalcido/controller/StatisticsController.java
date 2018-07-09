package personal.jmsalcido.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.jmsalcido.model.Statistics;
import personal.jmsalcido.service.StatisticsService;

@RestController("/stats")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public Statistics getStatistics() {
        return statisticsService.getStatistics();
    }
}
