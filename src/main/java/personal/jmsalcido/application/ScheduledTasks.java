package personal.jmsalcido.application;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import personal.jmsalcido.service.StatisticsService;

@Component
public class ScheduledTasks {

    private final StatisticsService statisticsService;

    public ScheduledTasks(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Scheduled(fixedRate = 1000)
    public void calcStats() {
        statisticsService.calculateStatistics();
    }

}
