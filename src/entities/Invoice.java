package entities;

public class Invoice {

    private Double basicPayment;
    private Double tax;

    public Invoice(){
    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }

    @Override
    public String toString() {
        return "Pagamento basico: " + String.format("%.2f%n", getBasicPayment()) +
                "Imposto: " + String.format("%.2f%n", getTax()) +
                "Pagamento total: " + String.format("%.2f%n", getTotalPayment());
    }
}
