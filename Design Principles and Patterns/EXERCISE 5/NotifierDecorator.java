public abstract class NotifierDecorator implements Notifier{
    protected Notifier decoratedNotifier;
    public NotifierDecorator(Notifier decoratedNotifier){
        this.decoratedNotifier=decoratedNotifier;
    } 
    public String send(){
        return decoratedNotifier.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator{
    public SMSNotifierDecorator(Notifier decoratedNotifier){
        super(decoratedNotifier);
    }
    public String send(){
        return "SMS: "+super.send();
    }
}

class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier decoratedNotifier){
        super(decoratedNotifier);
    }
    public String send(){
        return "SLACK: "+super.send();
    }
}