public class Product{
    private int productId;
    private String productName;
    private String category;
    
    Product(int productId,String productName,String category){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
    }

    public int getId(){
        return productId;
    }
    public String getName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public String toString(){
        return productId+" "+productName+" "+category;

    }
}