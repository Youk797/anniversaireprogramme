import java.util.List;

public class Main {
    private Database database;
    private MailService mailService;

    public Main( Database database, MailService mailservice) {
        this.database = database;
        this.mailService = mailservice;
    }

    public void sendMessage() {
        database.connect();
        List<Friend> friend = database.getFriends();
        String today = Date.getCurrentDate();
        for (Friend f : friend) {
            if (Date.removeYear(f.getDateOfBirth()).equals(today)) {
                String subject = "Happy birthday!";
                String content = "Happy birthday, dear " + f.getFirstName() + "!";
                mailService.sendMail(f.getEmail(), subject, content);
            }
        }
    }
    

    public static void main(String[] args) {
        Database sqlConnector = new Sqlconnection();
        MailService emailService = new EmailSender();
        Main send = new Main(sqlConnector, emailService);
        send.sendMessage();
    }
}
