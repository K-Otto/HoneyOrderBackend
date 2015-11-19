package za.ac.cput.project.hospitalmanagement.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by stud on 4/25/15.
 */
@Entity
public class OperationTheatre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long theatreNo;
    private String operationRoomSize;
//    private int operationID;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="operationID")
    


    public OperationTheatre(){

    }

    public long getTheatreNo() {
        return theatreNo;
    }

    public String getOperationRoomSize() {
        return operationRoomSize;
    }

//    public int getOperationID() {
//        return operationID;
//    }

    public OperationTheatre(Builder builder){
        this.theatreNo = builder.theatreNo;
        this.operationRoomSize = builder.operationRoomSize;
//        this.operationID = builder.operationID;
    }

    public static class Builder{
        private long theatreNo;
        private String operationRoomSize;
//        private int operationID;

//        public Builder(int operationID) {
//            this.operationID = operationID;
//        }
        public Builder(String operationRoomSize)
        {
            this.operationRoomSize = operationRoomSize;
        }

        public Builder theatreNo(int value) {
            this.theatreNo = value;
            return this;
        }


        public Builder copy(OperationTheatre value){
            this.operationRoomSize = value.operationRoomSize;
            this.theatreNo = value.theatreNo;
//            this.operationID = value.operationID;
            return this;
        }

        public OperationTheatre build(){
            return new OperationTheatre(this);
        }
    }
}
