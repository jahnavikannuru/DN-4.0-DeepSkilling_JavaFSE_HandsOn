public class Main {
    public static void main(String[] args) {
        Order[] orders = new Order[] {
            new Order(1, "ABC", 300),
            new Order(2, "XYZ", 150),
            new Order(3, "PQR", 450),
            new Order(4, "KLM", 100)
        };
        Sort sort=new Sort();
        sort.bubbleSort(orders);
        System.out.println("After bubble sort");
        for (Order o : orders) {
            System.out.println(o);
        }
        orders = new Order[] {
            new Order(1, "ABC", 300),
            new Order(2, "XYZ", 150),
            new Order(3, "PQR", 450),
            new Order(4, "KLM", 100)
        };
        sort.quickSort(orders, 0, orders.length - 1);
        System.out.println("After quick sort");
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
