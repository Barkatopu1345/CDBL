
package investor;

import javafx.beans.property.SimpleStringProperty;

public class products {
    private SimpleStringProperty firstID,lastId,minPrice,finalPrice;

    public products(String firstID, String lastId, SimpleStringProperty minPrice, SimpleStringProperty finalPrice) {
        this.firstID = new SimpleStringProperty(firstID);
        this.lastId = new SimpleStringProperty(lastId);
        this.minPrice = minPrice;
        this.finalPrice = finalPrice;
    }

    public SimpleStringProperty getFirstID() {
        return firstID;
    }

    public void setFirstID(SimpleStringProperty firstID) {
        this.firstID = firstID;
    }

    public SimpleStringProperty getLastId() {
        return lastId;
    }

    public void setLastId(SimpleStringProperty lastId) {
        this.lastId = lastId;
    }

    public SimpleStringProperty getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(SimpleStringProperty minPrice) {
        this.minPrice = minPrice;
    }

    public SimpleStringProperty getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(SimpleStringProperty finalPrice) {
        this.finalPrice = finalPrice;
    }
   
}
