import java.util.HashMap;
import java.util.Map;

public class PatientService {
    private Map<String, String> patientData = new HashMap<>();

    public void updatePatientRecord(String patientId, String record) {
        // Insecure: Patient data is stored in an unprotected manner
        patientData.put(patientId, record);
    }

    public String getPatientRecord(String patientId) {
        // Insecure: No access control checks
        return patientData.get(patientId);
    }
}
