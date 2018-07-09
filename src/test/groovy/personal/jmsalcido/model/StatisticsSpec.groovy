package personal.jmsalcido.model

import spock.lang.Specification

class StatisticsSpec extends Specification {

    @SuppressWarnings("GrEqualsBetweenInconvertibleTypes")
    def "new instance scenario"() {
        def instance = Statistics.newInstance()

        expect:
        assert instance.avg == 0.0
        assert instance.count == 0.0
        assert instance.max == 0.0
        assert instance.min == 0.0
        assert instance.sum == 0.0
    }

    @SuppressWarnings("GrEqualsBetweenInconvertibleTypes")
    def "add value inserts data correctly"() {
        def instance = Statistics.newInstance()
        instance.add(1.2)

        expect:
        assert instance.avg == 1.2
        assert instance.count == 1
        assert instance.max == 1.2
        assert instance.min == 1.2
        assert instance.sum == 1.2
    }

    @SuppressWarnings("GrEqualsBetweenInconvertibleTypes")
    def "add values match the expected output"() {
        def instance = Statistics.newInstance()
        instance.add(1.2) // 3 elements
        instance.add(2.8) // max
        instance.add(0.5) // min

        expect:
        assert instance.avg == 1.5
        assert instance.count == 3
        assert instance.max == 2.8
        assert instance.min == 0.5
        assert instance.sum == 4.5
    }

}
