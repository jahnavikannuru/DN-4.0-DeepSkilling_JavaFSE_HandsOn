public interface PaymentProcessor {
    void processPayment();
}

class Phonepe{
    public void complete(){
        System.out.println("Payment through phonepe");
    }
}
class GooglePay{
    public void complete(){
        System.out.println("Payment through GooglePay");
    }
}

class PaymentAdapter implements PaymentProcessor{
    private Phonepe payment;
    private GooglePay payment1;
    public PaymentAdapter(){
        this.payment=new Phonepe();
        this.payment1=new GooglePay();
    }
    public void processPayment(){
        payment.complete();
        payment1.complete();
    }
}