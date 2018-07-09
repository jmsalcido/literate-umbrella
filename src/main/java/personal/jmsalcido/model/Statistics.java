package personal.jmsalcido.model;

public class Statistics {

    private double sum;
    private double max;
    private double min;
    private int count;

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public int getCount() {
        return count;
    }

    public double getAvg() {
        return average();
    }

    public void add(double amount) {
        count++;
        sum += amount;

        if (amount > max) {
            max = amount;
        }

        if (min == 0.0 || amount < min) {
            min = amount;
        }
    }

    private double average() {
        double average = 0.0;
        if (count > 0) {
            average = sum / count;
        }
        return average;
    }

}
