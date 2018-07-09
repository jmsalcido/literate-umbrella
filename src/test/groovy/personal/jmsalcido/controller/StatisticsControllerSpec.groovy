package personal.jmsalcido.controller

import org.springframework.http.HttpStatus
import personal.jmsalcido.model.Statistics
import personal.jmsalcido.service.StatisticsService
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class StatisticsControllerSpec extends Specification {

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "stats scenario"() {
        given: "a controller with statistics service mock"
        def statisticsService = Mock(StatisticsService)
        def controller = new StatisticsController(statisticsService)

        and: "the mockMvc instance"
        def mockMvc = standaloneSetup(controller)
                .build()

        when: "I perform a POST to transactions"
        def response = mockMvc.perform(get("/stats"))
                .andReturn().response

        then: "should call the statisticsService.addTransaction method once"
        1 * statisticsService.getStatistics() >> new Statistics()

        and: "response status should be 201"
        assert response.status == HttpStatus.OK.value()
        assert response.contentAsString == '{"sum":0.0,"max":0.0,"min":0.0,"count":0,"avg":0.0}'

    }
}
