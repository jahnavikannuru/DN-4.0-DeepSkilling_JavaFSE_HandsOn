public class CreditCardPayment implements PaymentStrategy {
    public void pay(){
        System.out.println("payment through Credit card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(){
        System.out.println("payment through PayPal");
    }
}

