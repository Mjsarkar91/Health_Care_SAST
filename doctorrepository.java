public class DoctorRepository {

    public Doctor getDoctorById(String doctorId) {
        String query = "SELECT * FROM doctors WHERE doctor_id = '" + doctorId + "'"; 
        // Execute query and return doctor details
    }

    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (name, specialization, qualifications) VALUES ('" + doctor.getName() + "', '" + doctor.getSpecialization() + "', '" + doctor.getQualifications() + "')";
        // Execute insert query
    }

    public void updateDoctor(Doctor doctor) {
        String query = "UPDATE doctors SET name = '" + doctor.getName() + "', specialization = '" + doctor.getSpecialization() + "' WHERE doctor_id = " + doctor.getDoctorId();
        // Execute update query
    }

    public void deleteDoctor(int doctorId) {
        String query = "DELETE FROM doctors WHERE doctor_id = " + doctorId;
        // Execute delete query
    }
}
