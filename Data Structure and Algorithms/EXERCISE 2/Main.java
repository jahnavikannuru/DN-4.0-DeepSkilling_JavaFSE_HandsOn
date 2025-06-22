import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products={
            new Product(3,"mobile","electronics"),
            new Product(1,"dress","clothes"),
            new Product(2,"book","stationary")
        };
        System.out.println("Linear search");
        for(Product product:products){
            System.out.println(product);
        }
        Search.linearSearch(products, 1);
        System.out.println();
        System.out.println("Binary search");
        Arrays.sort(products,Comparator.comparing(Product::getId));
        for(Product product:products){
            System.out.println(product);
        }

        Search.binarySearch(products, 2);
    }
}