import java.sql.DataTruncation;

public class StockData {
    // declare variables for stockitems such as 'name', 'price' and 'quantity'

    public String name;

    public String price;

    public String Quantity;

    public float runningtotal;

    public float setItemName;

    //Start of Getters statements

    public float getRunningtotal(){
        return runningtotal;
    }

    public String Getname() {
        return name;
    }

    public String Getprice() {
        return price;
    }

    public String GetQuantity() {
    return Quantity;
    }

    //Start of setter statements

    public void setRunningtotal(float runningtotal) {
        this.runningtotal = runningtotal;
    }

    public void Setname(String itemName){
        this.name = itemName;
    }

    public void Setprice(String itemPrice){
        this.price = itemPrice;
    }

    public void SetQuantity(String itemQuantity){
        this.Quantity = itemQuantity;
    }

    public void setItemPrice(float pricetofloat) {
        this.setItemName = pricetofloat;
    }

    public void setaccountinstock(int stockInt) {
        this.setItemName = stockInt;
    }
}
