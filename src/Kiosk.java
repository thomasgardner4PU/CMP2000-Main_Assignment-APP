import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kiosk extends JFrame {

    public static HashMap<StockData, Integer> Map = new HashMap<>();

    private float TotalPrice; //Variable declared as float here to enable calculation of total price of StockItems

    private JPanel KioskPanel;
    private JButton ScanItemsBtn;
    private JTextField txtField;
    private JTextArea itemsList;
    private JButton AdminBtn;
    private JButton CardPaymentBtn;
    private JButton CashPaymentBtn;
    private JTextField EnterMoneyTxt;
    private JTextField EnterPaymentTxt;
    private JLabel ShowChangeLbl;
    private JLabel TotalCashPriceLbl;
    private JLabel TotalLbl;
    private JLabel changeLbl;
    private JLabel EnterAmountLbl;

    public static ArrayList<StockData> CurrentStock = new ArrayList<>(); // multiple instances of one type of item

    public Kiosk () {

        System.out.println("innit called");
        setContentPane(KioskPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,600));
        pack();

        Dataloader dataloader = new Dataloader();
        dataloader.loadstock();

        CurrentStock = dataloader.getArrayListStock(); // contains list of all items from StockData class

        System.out.println();
        AdminBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin Page = new AdminLogin();
                Page.setVisible(true);
                dispose();
            }
        });
        ScanItemsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TotalLbl
                itemsList.setText("");
                String itemname = txtField.getText();
                for (StockData k : Map.keySet()) {
                    System.out.println(k.Barcode + ":" + itemname);
                    if (k.Barcode.equals(itemname)) { //if the name of the current item we're iteralting through equals what we entered
                        Map.put(k, Map.get(k) + 1); // we're adding 1 onto the current amount of item's amount the customer is buying
                    }
                }
                double total = 0.0;
                for (StockData k : Map.keySet()) {
                    total += Map.get(k) * Double.parseDouble(k.price);
                    if (Map.get(k) > 0) { // displays if more then 0 has been ordered
                        itemsList.setText(itemsList.getText() + Map.get(k) + " x " + k.name + "....Barcode: " + k.Barcode + "\n" + "£"+ k.price + "each" + "\n" + "\n" + "\n");
                    }
                }
                TotalLbl.setText(String.valueOf(total));
            }
        });
        CashPaymentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float total = Float.parseFloat(EnterMoneyTxt.getText()) - Float.parseFloat(TotalLbl.getText());
                ShowChangeLbl.setText(String.valueOf(total)); //double is decimal point or fraction
            }
    });


        CardPaymentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BankVerificationScreen Page = new BankVerificationScreen();
                Page.show();

                dispose();
            }
        });
    }

    public void updatepricelable() {
        TotalLbl.setText(String.format("%.2f",TotalPrice)); //formated to string with two decimal places
    }

    public static void innit(){ //
        Map.clear(); //clears the map
        for (StockData stockData : CurrentStock) {
            Map.put(stockData, 0); //puts every item from stock into hashmap
            System.out.println("It works");
        }
    }
}