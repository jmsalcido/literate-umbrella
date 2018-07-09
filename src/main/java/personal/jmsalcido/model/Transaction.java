package personal.jmsalcido.model;

public class Transaction {

    private double amount;
    private long timestamp;

    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Transaction setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

}
