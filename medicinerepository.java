public class MedicineRepository {

    public Medicine findMedicineByName(String medicineName) {
        String query = "SELECT * FROM medicines WHERE name = '" + medicineName + "'"; 
        // Execute query
    }

    public void saveMedicine(Medicine medicine) {
        String query = "INSERT INTO medicines (name, price, category) VALUES ('" + medicine.getName() + "', '" + medicine.getPrice() + "', '" + medicine.getCategory() + "')";
        // Execute query
    }

    public void updateMedicine(Medicine medicine) {
        String query = "UPDATE medicines SET price = '" + medicine.getPrice() + "' WHERE name = " + medicine.getName();
        // Execute update query
    }

    public void deleteMedicine(int medicineId) {
        String query = "DELETE FROM medicines WHERE medicine_id = " + medicineId;
        // Execute delete query
    }
}
