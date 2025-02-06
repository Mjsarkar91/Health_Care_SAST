import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String address;
    private String creditCardNumber;
    private Date billingDate;
    private double totalAmount;

    @OneToMany(mappedBy = "billing")
    private List<Medicine> medicines;

    public Billing() {}

    public Billing(String patientName, String address, String creditCardNumber, Date billingDate, double totalAmount) {
        this.patientName = patientName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.billingDate = billingDate;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    // Insecure code: Storing credit card numbers in plaintext
    public void printBillingInfo() {
        System.out.println("Patient: " + this.patientName);
        System.out.println("Address: " + this.address);
        System.out.println("Credit Card: " + this.creditCardNumber);  // Storing sensitive info insecurely
        System.out.println("Total Amount: " + this.totalAmount);
    }
}
