@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @PostMapping("/create")
    public ResponseEntity<?> createPrescription(@RequestBody Prescription prescription) {
        prescriptionService.save(prescription);
        return ResponseEntity.ok("Prescription created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPrescription(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getById(id);
        if (prescription == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prescription not found");
        }
        return ResponseEntity.ok(prescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails) {
        Prescription existingPrescription = prescriptionService.getById(id);
        if (existingPrescription == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prescription not found");
        }
        existingPrescription.setMedicine(prescriptionDetails.getMedicine());
        existingPrescription.setDosage(prescriptionDetails.getDosage());
        prescriptionService.save(existingPrescription);
        return ResponseEntity.ok(existingPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrescription(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getById(id);
        if (prescription == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prescription not found");
        }
        prescriptionService.delete(id);
        return ResponseEntity.ok("Prescription deleted successfully");
    }
}
