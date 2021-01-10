import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stock extends JFrame {


    private JPanel mainPanel;
    private JLabel lbl;
    private JPanel Panel1;
    private JPanel Panel2;
    private JButton EditBtn;
    private JButton Add;
    private JButton RemoveBtn;
    private JList ItemList;
    private JLabel TitleLbl;
    private JLabel itemLbl;

    ArrayList<Stock> StockData;

    {
        StockData = new ArrayList<Stock>();
    }

    public Stock(String title){

        super(title);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
    }
}
