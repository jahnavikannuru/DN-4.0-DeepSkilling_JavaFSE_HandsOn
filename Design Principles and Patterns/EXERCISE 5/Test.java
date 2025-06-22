public class Test {
    public static void main(String[] args) {
        Notifier emailNotifier=new EmailNotifier("this is an email notification");
        Notifier smsNotifier=new SMSNotifierDecorator(emailNotifier);
        System.out.println(smsNotifier.send());
        Notifier slackNotifier=new SlackNotifierDecorator(emailNotifier);
        System.out.println(slackNotifier.send());
    }
}
