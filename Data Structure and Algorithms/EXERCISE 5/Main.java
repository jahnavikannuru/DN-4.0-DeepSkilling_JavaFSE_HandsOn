public class Main {
    public static void main(String[] args) {
        List list=new List();
        Task t1=new Task(1, "coding", "completed");
        Task t2=new Task(2, "debugging", "pending");
        list.Add(t1);
        list.Add(t2);
        list.Search(1);
        list.Delete(1);
        list.Traverse();
    }
}
