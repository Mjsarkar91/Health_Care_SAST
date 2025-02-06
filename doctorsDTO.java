public class DoctorDTO {
    public int id;  // Insecure: public, should be private
    private String name;  // Secure: private
    private String specialization;  // Secure: private

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;  // Insecure: No validation before setting ID
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
