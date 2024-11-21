package payloadPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Store {

    @JsonProperty("id")
    private int id;
    @JsonProperty("petId")
    private int petId;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("shipDate")
    private String shipDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("complete")
    private Boolean complete;


//    public int getId(int id) {
//        return this.id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getPetId() {
//        return petId;
//    }
//
//    public void setPetId(int petId) {
//        this.petId = petId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getShipDate() {
//        return shipDate;
//    }
//
//    public void setShipDate(String shipDate) {
//        this.shipDate = shipDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Boolean getComplete() {
//        return complete;
//    }
//
//    public void setComplete(Boolean complete) {
//        this.complete = complete;
//    }
}
