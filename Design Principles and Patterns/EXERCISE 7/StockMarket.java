import java.util.ArrayList;

public class StockMarket implements Stock{
    private ArrayList<Observer> observers= new ArrayList<>();
    private String product;
    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    public void deregisterObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(Observer observer:observers){
            observer.update(product);
        }
    }
    public void setProduct(String newProduct){
        this.product=newProduct;
        notifyObservers();
    }
    
}
