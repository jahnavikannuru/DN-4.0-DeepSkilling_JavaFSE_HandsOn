public class Logger {
    public static Logger obj;
    private Logger(){
        System.out.println("Instance created");
    }
    public static Logger getInstance(){
        if(obj==null){
            obj=new Logger();
        }
        return obj;
    }
}