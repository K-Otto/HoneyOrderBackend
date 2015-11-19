package za.ac.cput.project.hospitalmanagement.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Created by stud on 4/25/15.
 */
@Entity
public class Treatment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long treatmentID;
    private String dateDischarged;
    private String dateAdmitted;
    

    public Treatment() {

    }

    public long getTreatmentID() {
        return treatmentID;
    }

    public String getDateDischarged() {
        return dateDischarged;
    }
    
    public String getDateAdmitted() {
        return dateAdmitted;
    }


    public Treatment(Builder builder){
        this.treatmentID=builder.treatmentID;
        this.dateDischarged = builder.dateDischarged;
        this.dateAdmitted = builder.dateAdmitted;
    }

    public static class Builder{
        private long treatmentID;
        private String dateDischarged;
        private String dateAdmitted;

        public Builder(String dateAdmitted) {
            this.dateAdmitted = dateAdmitted;
        }

        public Builder treatmentID(long value){
            this.treatmentID = value;
            return this;
        }

        public Builder dateDischarged(String value){
            this.dateDischarged = value;
            return this;
        }
           
        public Treatment build(){
            return new Treatment(this);
        }

        public Builder copy(Treatment value){
            this.treatmentID=value.treatmentID;
            this.dateDischarged = value.dateDischarged;
            this.dateAdmitted = value.dateAdmitted;
            return this;
        }
    }
}
