package za.ac.cput.project.hospitalmanagement.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
/**
 * Created by stud on 4/25/15.
 */
@Entity
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long operationID;
    private String startTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="theatreNo")
    private OperationTheatre theatreNo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="treatmentID")
    Treatment treatment;

    public Operation() {

    }

    public long getOperationID() {
        return operationID;
    }

    public OperationTheatre getTheatreNo() {
        return theatreNo;
    }

    public String getStartTime() {
        return startTime;
    }
    
    public Treatment getTreatment() {
        return treatment;
    }

    public Operation(Builder builder){
        this.operationID=builder.operationID;
        this.theatreNo = builder.theatreNo;
        this.startTime = builder.startTime;
        this.treatment = builder.treatment;
    }

    public static class Builder{
        private long operationID;
        private OperationTheatre theatreNo;
        private String startTime;
        private Treatment treatment;

        public Builder(String treatmentID){
            this.startTime = treatmentID;
        }

        public Builder operationID(long value){
            this.operationID=value;
            return this;
        }

        public Builder theatreNo(OperationTheatre value){
            this.theatreNo=value;
            return this;
        }
        
        public Builder treatment(Treatment value){
            this.treatment=value;
            return this;
        }
        
        public Builder copy(Operation value){
            this.operationID=value.operationID;
            this.theatreNo = value.theatreNo;
            this.startTime = value.startTime;
            this.treatment = value.treatment;
            return this;
        }

        public Operation build(){
            return new Operation(this);
        }
    }
}
