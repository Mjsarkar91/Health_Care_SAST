public class PatientDTO {
    private int id;  // Secure: private
    public String name;  // Insecure: public, can be accessed directly
    private String medicalHistory;  // Secure: private

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Insecure: public field exposes the name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Secure: private field for medicalHistory
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
