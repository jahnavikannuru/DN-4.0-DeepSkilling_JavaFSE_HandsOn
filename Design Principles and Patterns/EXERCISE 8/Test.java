public class Test {
    public static void main(String[] args) {
        PaymentContext paymentContext=new PaymentContext(new CreditCardPayment());
        paymentContext.performPayment();
        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.performPayment();
    }
}
