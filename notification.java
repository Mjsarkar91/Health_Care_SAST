import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String recipient;
    private Date notificationDate;

    @OneToMany(mappedBy = "notification")
    private List<User> users;

    public Notification() {}

    public Notification(String message, String recipient, Date notificationDate) {
        this.message = message;
        this.recipient = recipient;
        this.notificationDate = notificationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Insecure code: Sending unfiltered notifications
    public void sendNotification() {
        System.out.println("Sending message: " + this.message + " to " + this.recipient);  // No validation or authorization checks
    }
}
