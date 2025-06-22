public class ProxyPattern {
    public static void main(String[] args) {
        Image image=new ProxyImage("your-background.jpg");
        image.display();
    }
}
