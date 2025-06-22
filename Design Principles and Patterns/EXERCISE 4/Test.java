public class Test {
    public static void TestCode(PaymentProcessor processor){
        processor.processPayment();
    }
    public static void main(String[] args) {
        PaymentAdapter adapter=new PaymentAdapter();
        TestCode(adapter);
    }
}
