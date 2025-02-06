public class PatientRepository {

    public Patient findById(int patientId) {
        String query = "SELECT * FROM patients WHERE id = " + patientId; 
        // Execute query and return patient data
    }

    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, age, address) VALUES ('" + patient.getName() + "', '" + patient.getAge() + "', '" + patient.getAddress() + "')";
        // Execute insert query
    }

    public void updatePatient(Patient patient) {
        String query = "UPDATE patients SET name = '" + patient.getName() + "', age = '" + patient.getAge() + "', address = '" + patient.getAddress() + "' WHERE id = " + patient.getId();
        // Execute update query
    }

    public void deletePatient(int patientId) {
        String query = "DELETE FROM patients WHERE id = " + patientId;
        // Execute delete query
    }
}
