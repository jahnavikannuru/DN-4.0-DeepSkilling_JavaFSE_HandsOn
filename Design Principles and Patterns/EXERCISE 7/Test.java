public class Test {
    public static void main(String[] args) {
        StockMarket stock=new StockMarket();
        Observer mobileApp=new MobileApp();
        Observer webApp=new WebApp();
        stock.registerObserver(mobileApp);
        stock.registerObserver(webApp);

        stock.setProduct("games");

    }
}
