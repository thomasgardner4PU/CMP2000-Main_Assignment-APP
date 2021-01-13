import java.sql.DataTruncation;

public class StockData {
    // declare variables for stockitems such as 'name', 'price' and 'quantity'
    public String name;
    public String price;
    public int Quantity;
    public String Barcode;
    public float runningtotal;
    public float setItemName;

    //Start of Getters statements
    public String getBarcode() {
        return Barcode;
    }
    public float getRunningtotal(){
        return runningtotal;
    }
    public String Getname() {
        return name;
    }
    public String Getprice() {
        return price;
    }
    public int GetQuantity() {
    return Quantity;
    }

    //Start of setter statements
    public void setBarcode(String itembarcode){
        this.Barcode = itembarcode;
    }
    public void setRunningtotal(float runningtotal) {
        this.runningtotal = runningtotal;
    }
    public void setName(String itemName){
        this.name = itemName;
    }
    public void setPrice(String itemPrice){
        this.price = itemPrice;
    }
    public void setQuantity(int itemQuantity){
        this.Quantity = itemQuantity;
    }
    public void setItemPrice(float pricetofloat) {
        this.setItemName = pricetofloat;
    }
    public void setaccountinstock(int stockInt) {
        this.setItemName = stockInt;
    }
}
