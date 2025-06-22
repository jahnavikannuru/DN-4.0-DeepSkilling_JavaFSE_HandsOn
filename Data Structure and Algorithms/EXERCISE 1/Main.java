public class Main {
    public static void main(String[] args) {
        Methods method = new Methods();
        method.addProduct(new Product(1, "Laptop", 1, 75000));
        method.addProduct(new Product(2, "Keyboard", 5, 3000));
        method.displayProducts();
        method.updateProduct(1, "Gaming Laptop", 1, 80000);
        method.deleteProduct(2);
        method.displayProducts();
    }
}
