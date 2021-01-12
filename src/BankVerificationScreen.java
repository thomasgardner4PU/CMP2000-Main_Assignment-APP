import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class BankVerificationScreen extends JFrame {

    private JPanel MainPanel;
    private JPanel Panel1;
    private JLabel VerificationLbl;
    private JButton AcceptBtn;
    private JButton DenyBtn;
    private JTextArea recieptArea;

    public ArrayList<BankData> BankVerification = new ArrayList<>();

    public ArrayList<BankData> setArrayListStock(){
        return BankVerification;
    }

    public BankVerificationScreen() {

        Dataloader dataloader = new Dataloader(); // loads and edits the existing data
        dataloader.loadbankdata();

        Dataloader.save(); // Then the data should appear inside the text file

        /*dataInput();*/

        BankVerification = dataloader.getArrayListBank();

        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,500));
        pack();
        AcceptBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reciept Page = new Reciept();
                Page.show();

                /*dataInput();*/
            }
        });
    }

    public void dataInput() {
    }
}