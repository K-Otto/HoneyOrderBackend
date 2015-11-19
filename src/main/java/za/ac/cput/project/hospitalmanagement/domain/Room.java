package za.ac.cput.project.hospitalmanagement.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

/**
 * Created by stud on 4/25/15.
 */
@Entity
public class Room implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomID;
    private int availableBeds;
    private int totalBeds;
    private String roomType;

    public Room(){

    }

    public long getRoomID() {
        return roomID;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public String getRoomType() {
        return roomType;
    }

    public Room(Builder builder){
        this.roomID=builder.roomID;
        this.availableBeds = builder.availableBeds;
        this.totalBeds=builder.totalBeds;
        this.roomType=builder.roomType;
    }

    public static class Builder{
        private long roomID;
        private int availableBeds;
        private int totalBeds;
        private String roomType;

        public Builder(int totalBeds) {
            this.totalBeds = totalBeds;
        }

        public Builder roomID(long value){
            this.roomID=value;
            return this;
        }

        public Builder availableBeds(int value){
            this.availableBeds=value;
            return this;
        }

        public Builder roomType(String value){
            this.roomType=value;
            return this;
        }

        public Builder copy(Room value){
            this.roomID=value.roomID;
            this.availableBeds = value.availableBeds;
            this.totalBeds=value.totalBeds;
            this.roomType=value.roomType;
            return this;
        }

        public Room build(){
            return new Room(this);
        }
    }
}
