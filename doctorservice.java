public class DoctorService {
    
    public void updateDoctorAvailability(String doctorId, String availability) {
        // Insecure: Storing availability without any validation or encryption
        System.out.println("Doctor " + doctorId + " is available at: " + availability);
    }
    
    public String getDoctorAvailability(String doctorId) {
        // Insecure: Returning availability without proper validation
        return "Available at " + doctorId;
    }
}
