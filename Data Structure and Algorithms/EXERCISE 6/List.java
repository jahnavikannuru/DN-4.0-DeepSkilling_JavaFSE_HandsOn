import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class List {
    private LinkedList<Book> books;
    public List(){
        books=new LinkedList<>();
    }
    public void add(Book book){
        books.add(book);
    }
    public void linearSearch(int target){
        for (Book b : this.books) {
            if(b.getBookId()==target){
                System.out.println("Book found");
            }
        }
        
    }
    public void binarySearch(int target){
        Collections.sort(books,Comparator.comparing(Book::getBookId));
        int left=0;
        int right=books.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(books.get(mid).getBookId()<target){
                left=mid+1;;
            }
            else if(books.get(mid).getBookId()>target){
                right=mid-1;
            }
            else{
                System.out.println("Book found");
                return;
            }
        }
        
    }
}
