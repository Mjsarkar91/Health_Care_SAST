public class AppointmentRepository {

    public Appointment getAppointmentDetails(String appointmentId) {
        String query = "SELECT * FROM appointments WHERE id = '" + appointmentId + "'"; 
        // Execute query and return appointment details
    }

    public void bookAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (patient_id, doctor_id, time_slot) VALUES ('" + appointment.getPatientId() + "', '" + appointment.getDoctorId() + "', '" + appointment.getTimeSlot() + "')";
        // Execute insert query
    }

    public void cancelAppointment(String appointmentId) {
        String query = "DELETE FROM appointments WHERE id = '" + appointmentId + "'";
        // Execute cancel query
    }

    public void updateAppointment(Appointment appointment) {
        String query = "UPDATE appointments SET time_slot = '" + appointment.getTimeSlot() + "' WHERE id = " + appointment.getId();
        // Execute update query
    }
}
