@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @GetMapping("/list")
    public ResponseEntity<?> listMedicines() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        return ResponseEntity.ok(medicines);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMedicine(@RequestBody Medicine medicine) {
        medicineService.save(medicine);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medicine added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) {
        Medicine existingMedicine = medicineService.getById(id);
        if (existingMedicine == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found");
        }
        existingMedicine.setName(medicineDetails.getName());
        existingMedicine.setPrice(medicineDetails.getPrice());
        medicineService.save(existingMedicine);
        return ResponseEntity.ok(existingMedicine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable Long id) {
        Medicine medicine = medicineService.getById(id);
        if (medicine == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine not found");
        }
        medicineService.delete(id);
        return ResponseEntity.ok("Medicine deleted successfully");
    }
}
