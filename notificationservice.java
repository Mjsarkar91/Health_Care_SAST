public class NotificationService {

    public void sendNotification(String recipient, String message) {
        // Insecure: Sending notifications without sanitizing input or validating user
        System.out.println("Notification sent to " + recipient + " with message: " + message);
    }
}
