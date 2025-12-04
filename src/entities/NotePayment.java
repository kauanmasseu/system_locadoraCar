package entities;

import java.time.Duration;

public class NotePayment {

    private Double valuePerHour;
    private Double valuePerDay;
    private DataLocation data;

    public NotePayment(Double valuePerHour, Double valuePerDay, DataLocation data) {
        this.valuePerHour = valuePerHour;
        this.valuePerDay = valuePerDay;
        this.data = data;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Double getValuePerDay() {
        return valuePerDay;
    }

    public DataLocation getData() {
        return data;
    }

    public double basicPayment() {
        Duration duration = Duration.between(data.getInstantInitial(), data.getFinalLocation());
        double hour = duration.toMinutes() / 60.0;
        double hoursRounded = Math.ceil(hour);

        if(hoursRounded <= 12.0) {
            return hoursRounded * valuePerHour;
        }
        else {
            double days = Math.ceil(hoursRounded / 24.0);
            return days * valuePerDay;
        }

    }

    public double valueImpost() {
        return basicPayment() <= 100 ? basicPayment() * 0.2 : basicPayment() * 0.15;
    }

    public double valueTot() {
        return basicPayment() + valueImpost();
    }

    @Override
    public String toString() {
        return "Basic payment: " + String.format("%.2f%n", basicPayment())
                + "Tax: " + String.format("%.2f%n", valueImpost())
                + "Total payment: " + String.format("%.2f%n", valueTot());
    }
}
