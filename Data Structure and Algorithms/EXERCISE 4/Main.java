public class Main {
    public static void main(String[] args) {
        Methods method=new Methods();
        Employee e1=new Employee(1, "XYZ", "SDE1", 50000);
        Employee e2=new Employee(2, "ABC", "Frontend", 50000);
        method.Add(e1);
        method.Add(e2);
        method.Delete(1);
        method.Search(2);
        method.Traverse();
    }
}
