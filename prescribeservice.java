public class PrescriptionService {
    
    public void prescribeMedicine(String patientId, String medicine) {
        // Insecure: No input sanitization on prescribed medicine
        System.out.println("Prescribed " + medicine + " to patient " + patientId);
    }
}
