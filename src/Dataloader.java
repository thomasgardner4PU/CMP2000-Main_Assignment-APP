import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataloader {

    public String filePathAdminData = "src\\resources\\admin.txt";
    public String filepathStockData = "src\\resources\\stock.txt";
    public static String filepathBankdata = "src\\resources\\bankInformation.txt"; //file does not exsist yet
    public String separator = "\\|";

    // ArrayList for AdminLogin constructor
    public ArrayList<AdminData> Accounts = new ArrayList<>();

    //ArrayList for StockData constructor
    public ArrayList<StockData> CurrentStock = new ArrayList<>();

    //ArrayList for BankData constructor
    private static final ArrayList<BankData> BankVerification = new ArrayList<BankData>();

    // Getters for ArrayLists
    public ArrayList<BankData> getArrayListBank() {
        return BankVerification;
    }
    public ArrayList<StockData> getArrayListStock(){
        return CurrentStock;
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

            System.out.println("Login data has been successfully loaded");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void loadstock() { // logic for Stock class
        try {
            File file = new File(filepathStockData);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String tablerow = scanner.nextLine();

                String[] tempitem = tablerow.split(separator);

                StockData stockData = new StockData();

                stockData.Barcode = tempitem[0];
                stockData.name = tempitem[1]; //created a new instance of stockdata, and changing the item name to tempitem and loading the name into stockdata
                stockData.price = tempitem[2];
                stockData.Quantity = Integer.parseInt(tempitem[3]);
                stockData.runningtotal = Float.parseFloat(tempitem[4]);
                CurrentStock.add(stockData);

                String barcode = tempitem[0];
                stockData.setBarcode(barcode);
                float pricetofloat = Float.parseFloat(tempitem[2]);
                stockData.setItemPrice(pricetofloat);
                int stockInt = Integer.parseInt(tempitem[3]);
                stockData.setaccountinstock(stockInt);
                float totalcashprice = Float.parseFloat(tempitem[4]);
                stockData.setRunningtotal(totalcashprice);
            }

            scanner.close();
            System.out.println("stock data has been successfully loaded");


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadbankdata(){ //logic for BankVerificationClass
        try {
            File file = new File(filepathBankdata); //Process starts by setting up file
            Scanner scanner = new Scanner(file); // Scanner keyword is used to read each line between breakpoint within file
            while (scanner.hasNextLine()) { // Data Gathering from scanner begins
                String tablerow = scanner.nextLine();

                String[] userData = tablerow.split(separator);

                System.out.println(userData[0]);

                BankData user = new BankData();

                user.setName(userData[0]);

                int ageToInt = Integer.parseInt(userData[1]);
                user.setAge(ageToInt);

                float balanceToFloat = Float.parseFloat(userData[2]);
                user.setBalance(balanceToFloat);

                boolean platinumToBoolean = Boolean.parseBoolean(userData[3]);
                user.setPlatinumAccount(platinumToBoolean);

                BankVerification.add(user);

            }
            scanner.close(); // Scanner closed and has finished reading file

            System.out.println("Bank data has been successfully loaded");


        }catch // catch statement is used to 'catch' errors
        (FileNotFoundException e){  // the exception is used to find the error inside the try part of the statement
            e.printStackTrace();
        }

    }

    public static void save() {
        try {
            FileWriter writer = new FileWriter(filepathBankdata);

            for(int index = 0; index < BankVerification.size(); index++) {
                String dataRow = "";

                if(index > 0) {
                    dataRow += "\n";
                }
                dataRow += BankVerification.get(index).getName();

                String ageToString = Integer.toString(BankVerification.get(index).getAge());
                dataRow += "|" + ageToString;

                String balanceToString = Float.toString(BankVerification.get(index).getBalance());
                dataRow += "|" + balanceToString;

                String platinumToString = Boolean.toString(BankVerification.get(index).isPlatinumAccount());
                dataRow += "|" + platinumToString;

                writer.write(dataRow);
            }

            System.out.println("Save functionality successfull");

            writer.close();


        }catch (IOException e){  //The IO exception is used for inputting and outputting
            e.printStackTrace();
        }
    }

    public static BankData getUserAt(int index) {
        if (index >= BankVerification.size()) {
            return null;
        }
        return BankVerification.get(index);
    }


}
