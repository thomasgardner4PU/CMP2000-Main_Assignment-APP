import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Reciept extends JFrame {

    public String filepathStockData = "src\\resources\\stock.txt";

    public String separator = "\\|";

    public ArrayList<StockData> CurrentStock = new ArrayList<>();

    /*private Formatter x;*/
    private float RunningTotal = 0.00f;
    private JPanel MainPanel;
    private JTextArea shoppingListTxt;
    private JButton PrintRecieptBtn;

    public Reciept() {
        loadstock(); //calling function loadstock
        System.out.println(CurrentStock);

        Kiosk kiosk = new Kiosk();
        kiosk.updatepricelable();

        ProvideReciept();

        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setResizable(false);
        pack();

        PrintRecieptBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProvideReciept();
            }
        });
    }

    public void loadstock() { // function that communicates with
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

    public void ProvideReciept() {


        new SwingWorker<Void, Object>() {

            @Override
            protected Void doInBackground() throws Exception {
                System.out.println("Swing Worker Thread: " + Thread.currentThread().getName()); //start of Swing Method
                shoppingListTxt.setText("Printing Receipt");
                Thread.sleep(4000); // delay when printing reciept
                shoppingListTxt.setText(""); //displays items inside shoppingList textfield
                double total = 0.0; // declares datatype for total
                for (StockData k : Kiosk.Map.keySet()) {
                    total += Kiosk.Map.get(k) * Double.parseDouble(k.price);
                    if (Kiosk.Map.get(k) > 0) { // displays if more then 0 has been ordered
                        shoppingListTxt.setText(shoppingListTxt.getText() + Kiosk.Map.get(k) + " x " + k.name + ".... Barcode: " + k.Barcode + "\n" + "£" + k.price + "each" + "\n");
                        //prints out the name, barcode and price inside the shoppingList textfield
                    }
                }
                shoppingListTxt.setText(shoppingListTxt.getText() + "Total: " + total);
                return null;
            }
        }.execute();
    }
}