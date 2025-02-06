@RestController
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientDetails(@PathVariable Long id) {
        Patient patient = patientService.getById(id);
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        patientService.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient registered successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient existingPatient = patientService.getById(id);
        if (existingPatient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        existingPatient.setName(patientDetails.getName());
        existingPatient.setEmail(patientDetails.getEmail());
        patientService.save(existingPatient);
        return ResponseEntity.ok(existingPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        Patient patient = patientService.getById(id);
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        patientService.delete(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
