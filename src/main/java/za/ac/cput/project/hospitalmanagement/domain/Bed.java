package za.ac.cput.project.hospitalmanagement.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by stud on 4/25/15.
 */
@Entity
public class Bed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bedNo;
    private String availability;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="patientID")
//    private Patient patientID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="roomNo")
    private Room roomID;

    public Bed(){

    }

    public long getBedNo() {
        return bedNo;
    }

    public String getAvailability() {
        return availability;
    }

//    public Patient getPatientID() {
//        return patientID;
//    }

    public Room getRoomID() {
        return roomID;
    }

    public Bed(Builder builder){
        this.bedNo=builder.bedNo;
        this.availability = builder.availability;
//        this.patientID = builder.patientID;
        this.roomID = builder.roomID;
    }

    public static class Builder{
        private long bedNo;
        private String availability;
//        private Patient patientID;
        private Room roomID;

        public Builder(String availability) {
            this.availability = availability;
        }

//        public Builder patientID(Patient value){
//            this.patientID=value;
//            return this;
//        }

        public Builder bedNo(long value){
            this.bedNo=value;
            return this;
        }
        
        public Builder roomID(Room value){
            this.roomID=value;
            return this;
        }

        public Builder copy(Bed value){
            this.bedNo=value.bedNo;
            this.availability = value.availability;
//            this.patientID = value.patientID;
            this.roomID = value.roomID;
            return this;
        }

        public Bed build(){
            return new Bed(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bed other = (Bed) obj;
        if (this.bedNo != other.bedNo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.bedNo ^ (this.bedNo >>> 32));
        return hash;
    }
    
}

