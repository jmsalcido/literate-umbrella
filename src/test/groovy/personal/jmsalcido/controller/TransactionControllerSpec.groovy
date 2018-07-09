package personal.jmsalcido.controller

import groovy.json.JsonOutput
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import personal.jmsalcido.service.StatisticsService
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Instant

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

@Unroll
class TransactionControllerSpec extends Specification {

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "scenario for #responseStatus"() {
        given: "a controller with statistics service mock"
        def statisticsService = Mock(StatisticsService)
        def controller = new TransactionController(statisticsService)

        and: "the mockMvc instance"
        def mockMvc = standaloneSetup(controller)
                .build()

        and: "an instance of a transaction"
        def transaction = [
                timestamp: timeNow,
                amount   : amount
        ]

        when: "I perform a POST to transactions"
        def response = mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonOutput.toJson(transaction)))
                .andReturn().response

        then: "should call the statisticsService.addTransaction method once"
        1 * statisticsService.addTransaction(_)

        and: "response status should be 201"
        assert response.status == responseStatus.value()

        where:
        amount | timeNow                                        | responseStatus
        1.2    | System.currentTimeMillis()                     | HttpStatus.CREATED
        1.2    | Instant.now().minusSeconds(100).toEpochMilli() | HttpStatus.NO_CONTENT


    }

}
