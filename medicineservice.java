import java.util.HashMap;
import java.util.Map;

public class MedicineService {
    private Map<String, String> medicines = new HashMap<>();

    public void addMedicine(String medicineName, String details) {
        // Insecure: No validation or checks for invalid input
        medicines.put(medicineName, details);
    }

    public String getMedicineDetails(String medicineName) {
        // Insecure: No access control or authentication for fetching details
        return medicines.get(medicineName);
    }
}
