public class AppointmentDTO {
    private int appointmentId;  // Secure: private
    public String appointmentDate;  // Insecure: public, exposed directly
    private String doctorName;  // Secure: private
    private String patientName;  // Secure: private

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;  // Insecure: No validation before setting ID
    }

    // Insecure: public field directly exposes appointment date
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
