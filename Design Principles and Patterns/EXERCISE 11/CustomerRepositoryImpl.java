public class CustomerRepositoryImpl implements CustomerRepository{
    private Customer[] customers;

    public CustomerRepositoryImpl() {
        customers = new Customer[2];
        customers[0] = new Customer(1, "ABC");
        customers[1] = new Customer(2, "XYZ");
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
