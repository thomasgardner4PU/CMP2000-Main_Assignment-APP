import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk extends JFrame {

    private final float TotalAmountPaid = 0.00f;
    private float TotalPrice; //Variable declared as float here to enable calculation of total price

    private JPanel KioskPanel;
    private JButton ScanItemsBtn;
    private JTextField txtField;
    private JTextArea itemsList;

    private JButton AdminBtn;

    private JPanel PaymentPage;
    private JButton CardPaymentBtn;
    private JButton CashPaymentBtn;
    private JTextField EnterMoneyTxt;
    private JTextField EnterPaymentTxt;
    private JLabel ShowChangeLbl;
    private JLabel TotalCashPriceLbl;
    private JLabel TotalLbl;

    public static ArrayList<StockData> CurrentStock = new ArrayList<>();

    public static ArrayList<StockData> setArrayListStock(){
        return CurrentStock;
    }

    public Kiosk (String loading_from_file) {
        setContentPane(KioskPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700,700));
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
              String itembarcode = txtField.getText(); //Contains what the customer has typed in
                for (StockData item: CurrentStock) { //creates variable of item stock
                    if (itembarcode.equals(item.name)){ //will fire is the itembarcode the customer has entered matches the itemname it is searching
                        itemsList.append(item.name + "\r\n"); // will add item to new line
                        TotalPrice += Float.parseFloat(item.price);
                        updatepricelable();
                    }
                }
            }
        });
        CashPaymentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double change = Double.parseDouble(EnterMoneyTxt.getText()) - TotalPrice;
                ShowChangeLbl.setText(String.valueOf(change)); //double is decimal point or fraction
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

    public void updatecashlabel() {
        TotalCashPriceLbl.setText(String.format("%.2f", TotalAmountPaid));
    }
}