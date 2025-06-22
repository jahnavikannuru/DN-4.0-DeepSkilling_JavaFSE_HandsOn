public class MobileApp implements Observer{
    private String product;
    public void update(String product){
        this.product=product;
        display();
    }
    private void display(){
        System.out.println("Mobile App: "+product);
    }
}

class WebApp implements Observer{
    private String product;
    public void update(String product){
        this.product=product;
        display();
    }
    private void display(){
        System.out.println("Web App: "+product);
    }
}
