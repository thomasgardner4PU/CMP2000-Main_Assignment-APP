import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataloader {

    public String filePathAdminData = "src\\resources\\admin.txt";

    public String filepathStockData = "src\\resources\\stock.txt";

    public String separator = "\\|";

    // ArrayList for AdminLogin class
    public ArrayList<AdminData> Accounts = new ArrayList<>();

    //ArrayList for StockData class
    public ArrayList<StockData> CurrentStock = new ArrayList<>();


    public ArrayList<StockData> getArrayListStock(){
        return CurrentStock;
    }

    public ArrayList<AdminData> getArrayList(){
        return Accounts;
    }

    public void LoadAdminData() { //logic for AdminLogin class
        try {
            File file = new File(filePathAdminData);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String tablerow = scanner.nextLine();

                String[] TempAccount = tablerow.split(separator);

                AdminData admin = new AdminData();

                admin.setUsername(TempAccount[0]);

                admin.setPassword(TempAccount[0]);

                Accounts.add(admin);

                System.out.println(admin);


            }
        scanner.close();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }



    public void loadstock() { // logic for Stock items inside stock.txt file
        try {
            File file = new File(filepathStockData);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String tablerow = scanner.nextLine();

                String[] tempitem = tablerow.split(separator);

                StockData stockData = new StockData();

                stockData.name = tempitem[0]; //created a new instance of stockdata, and changing the item name to tempitem and loading the name into stockdata
                stockData.price = tempitem[1];
                stockData.Quantity = tempitem[2];
                stockData.runningtotal = Float.parseFloat(tempitem[1]);
                CurrentStock.add(stockData);

                float pricetofloat = Float.parseFloat(tempitem[2]);
                stockData.setItemPrice(pricetofloat);
                int stockInt = Integer.parseInt(tempitem[2]);
                stockData.setaccountinstock(stockInt);
                float totalcashprice = Float.parseFloat(tempitem[2]);
                stockData.setRunningtotal(totalcashprice);
            }

            scanner.close();
            System.out.println("stock file loaded");


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
