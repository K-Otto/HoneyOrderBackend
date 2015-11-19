package za.ac.cput.project.hospitalmanagement.domain;

import java.io.Serializable;
import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by stud on 4/25/15.
 */
@Entity
public class Medicine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long medicineID;
    private float quantity;
    private String medicineName;
    private String medicineType;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="treatmentID")
    Long treatmentID;


    public Medicine(){

    }

    public long getMedicineID() {
        return medicineID;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getMedicineType() {
        return medicineType;
    }
    
     public Long getTreatmentID() {
        return treatmentID;
    }

    public Medicine(Builder builder){
        this.medicineID=builder.medicineID;
        this.quantity = builder.quantity;
        this.medicineName=builder.medicineName;
        this.medicineType=builder.medicineType;
        this.treatmentID = builder.treatmentID;
    }

    public static class Builder{
        private long medicineID;
        private float quantity;
        private String medicineName;
        private String medicineType;
        private Long treatmentID;

        public Builder(String medicineName) {
            this.medicineName = medicineName;
        }

        public Builder medicineID(long value) {
            this.medicineID = value;
            return this;
        }

        public Builder quantity(float value) {
            this.quantity = value;
            return this;
        }

        public Builder medicineType(String value) {
            this.medicineType = value;
            return this;
        }
        
        public Builder treatmentID(Long value){
            this.treatmentID=value;
            return this;
        }

        public Builder copy(Medicine value){
            this.medicineID=value.medicineID;
            this.quantity = value.quantity;
            this.medicineName=value.medicineName;
            this.medicineType=value.medicineType;
            this.treatmentID = value.treatmentID;
            return this;
        }

        public Medicine build(){
            return new Medicine(this);
        }
    }
}
