import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockAdmin extends JFrame {

    public String filepathStockData = "src\\resources\\stock.txt";
    public String separator = "\\|";
    public ArrayList<StockData> CurrentStock = new ArrayList<>();

    private JPanel mainPanel;
    private JLabel lbl;
    private JPanel Panel1;
    private JPanel Panel2;
    private JButton EditBtn;
    private JButton Add;
    private JButton RemoveBtn;
    private JLabel TitleLbl;
    private JLabel itemLbl;
    private JTextArea textArea1;
    private JButton SaveBtn;
    private JTextField txtItemID;
    private JTextField txtQuantityNeeded;


    public StockAdmin(String title){

        loadstock(); //calling method loadstock
        System.out.println(CurrentStock);

        FillTextAdmin();

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();

        EditBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStock();
            }
        });
        RemoveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStock();
            }
        });
        SaveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
    }

    public void FillTextAdmin() {
        String stock = "";
        for(StockData item : CurrentStock){
            stock += item.Barcode + "   |   " + item.name + "   |   " +item.price + "   |   " + item.Quantity + "\n";
        }
        textArea1.setText(stock);
    }

    public int findItem(String id){
        int pos = -1; //gives position of an item with the array
        for(StockData item : CurrentStock){
            if(item.Barcode.equals(id)){
                pos = CurrentStock.indexOf(item);
            }
        }
        return pos;
    }

    public void removeStock(){ // removes items from database
        try{
            String stockString = txtItemID.getText();
            int numberToRemove = Integer.parseInt(txtQuantityNeeded.getText());
            int pos = findItem(stockString);
            CurrentStock.get(pos).Quantity -= numberToRemove;
            FillTextAdmin();
        }catch (Exception e){{
            JOptionPane.showMessageDialog(null, "Invalid input");
        }}
    }

    public void updateStock(){ //this object will update the number of items inside the textArea
        try{
            String StockString = txtItemID.getText();
            int numberToAdd = Integer.parseInt(txtQuantityNeeded.getText());
            int pos = findItem(StockString);
            CurrentStock.get(pos).Quantity += numberToAdd;
            FillTextAdmin();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Invalid input");
        }
        txtQuantityNeeded.setText("");
        txtItemID.setText("");
    }

    public void loadstock() { // Object that communicates with Dataloader
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
            System.out.println("stock file loaded");


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter(filepathStockData);

            for(int index = 0; index <CurrentStock.size(); index++) {
                String dataRow = ""; //row adding to the text file

                if(index > 0) {
                    dataRow += "\n"; //adds data to next line
                }

                String barcode = (CurrentStock.get(index).getBarcode());
                dataRow += barcode;

                String name = (CurrentStock.get(index).Getname());
                dataRow += name;

                String price = (CurrentStock.get(index).Getprice());
                dataRow += "|" + price;

                int quantity = (CurrentStock.get(index).GetQuantity());
                dataRow += "|" + quantity;

                int runningtotal = 0;//when new transaction occurs instead of saving to the database it will reset the value to 0
                dataRow += "|" + runningtotal;

                writer.write(dataRow);
            }

            writer.close();


        }catch (IOException e){  //The IO exception is used for inputting and outputting
            e.printStackTrace();
        }

    }
}
