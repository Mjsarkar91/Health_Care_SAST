public class PrescriptionRepository {

    public Prescription getPrescriptionById(String prescriptionId) {
        String query = "SELECT * FROM prescriptions WHERE prescription_id = '" + prescriptionId + "'"; 
        // Execute query and fetch prescription
    }

    public void savePrescription(Prescription prescription) {
        String query = "INSERT INTO prescriptions (patient_id, doctor_id, medicine) VALUES ('" + prescription.getPatientId() + "', '" + prescription.getDoctorId() + "', '" + prescription.getMedicine() + "')";
        // Execute insert query
    }

    public void updatePrescription(Prescription prescription) {
        String query = "UPDATE prescriptions SET medicine = '" + prescription.getMedicine() + "' WHERE prescription_id = " + prescription.getPrescriptionId();
        // Execute update query
    }

    public void deletePrescription(int prescriptionId) {
        String query = "DELETE FROM prescriptions WHERE prescription_id = " + prescriptionId;
        // Execute delete query
    }
}
