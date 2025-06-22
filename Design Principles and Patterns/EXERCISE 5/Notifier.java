public interface Notifier{
    String send();
}

class EmailNotifier implements Notifier{
    private String email;
    public EmailNotifier(String email){
        this.email=email;
    }
    public String send(){
        return email;
    }
}

