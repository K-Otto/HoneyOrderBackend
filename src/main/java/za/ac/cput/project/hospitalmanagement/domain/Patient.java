package za.ac.cput.project.hospitalmanagement.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by stud on 4/25/15.
 */
@Entity
public class Patient implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientID;
    @Embedded
    private Person person;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bedNo")
    private Bed bed;
    private String description;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="treatmentID")
    Long treatmentID;

    public Patient() {

    }

    public long getPatientID() {
        return patientID;
    }

    public Person getPerson()
    {
        return person;
    }

    public Bed getBed() {
        return bed;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Long getTreatmentID() {
        return treatmentID;
    }

    public Patient(Builder builder){
        this.patientID = builder.patientID;
        this.person = builder.person;
        this.bed = builder.bed;
        this.description = builder.description;
        this.treatmentID = builder.treatmentID;
    }

    public static class Builder {
        private long patientID;
        private Person person;
        private Bed bed;
        private String description;
        private Long treatmentID;

        public Builder(Person person) {
            this.person = person;
        }

        public Builder bed(Bed value){
            this.bed=value;
            return this;
        }

        public Builder patientID(long value){
            this.patientID=value;
            return this;
        }
        
        public Builder description(String value){
            this.description=value;
            return this;
        }
        
        public Builder treatmentID(Long value){
            this.treatmentID=value;
            return this;
        }

        public Builder copy(Patient value){
            this.patientID = value.patientID;
            this.person = value.person;
            this.bed = value.bed;
            this.description = value.description;
            this.treatmentID = value.treatmentID;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }
}
