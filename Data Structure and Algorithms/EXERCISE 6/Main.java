public class Main {
    public static void main(String[] args) {
        List list=new List();
        Book book=new Book(1, "Jack and Jill", "James");
        Book book1=new Book(2, "Java", "James Gosling");
        list.add(book);
        list.add(book1);
        list.linearSearch(1);
        list.binarySearch(2);

    }
}
