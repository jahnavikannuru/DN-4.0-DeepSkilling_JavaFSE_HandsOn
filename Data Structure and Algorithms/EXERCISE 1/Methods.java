import java.util.ArrayList;

public class Methods {
    private ArrayList<Product> products;

    public Methods() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added");
    }

    public void updateProduct(int productId, String newName, int newQuantity, double newPrice) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setProductName(newName);
                product.setQuantity(newQuantity);
                product.setPrice(newPrice);
                System.out.println("Product updated");
                return;
            }
        }
    }
    public void deleteProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                System.out.println("Product removed");
                products.remove(i);
                return;
            }
        }
    }
    public void displayProducts() {
            for (Product product : products) {
                System.out.println(product);
        }
    }
}
