public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    } 
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void performPayment() {
        paymentStrategy.pay();
    }
}
