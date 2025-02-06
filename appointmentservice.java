import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, String> appointments = new HashMap<>();

    public void scheduleAppointment(String appointmentId, String details) {
        // Insecure: No input validation or sanitation
        appointments.put(appointmentId, details);
    }

    public String getAppointmentDetails(String appointmentId) {
        // Insecure: No validation on the data fetched
        return appointments.get(appointmentId);
    }
}
