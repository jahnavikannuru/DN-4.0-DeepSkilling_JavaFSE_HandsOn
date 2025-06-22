public class Order{
    private int orderId;
    private String customerName;
    private int totalPrice;

    public Order(int orderId,String customerName,int totalPrice){
        this.orderId=orderId;
        this.customerName=customerName;
        this.totalPrice=totalPrice;
    }
    public int getId(){
        return orderId;
    }
    public String getName(){
        return customerName;
    }
    public int getPrice(){
        return totalPrice;
    }
    public String toString(){
        return orderId+" "+customerName+" "+totalPrice;
    }
}