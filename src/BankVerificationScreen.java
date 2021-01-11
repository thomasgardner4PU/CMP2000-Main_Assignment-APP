import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;

public class BankVerificationScreen extends JFrame {

    private JPanel MainPanel;
    private JPanel Panel1;
    private JLabel VerificationLbl;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public ArrayList<BankData> BankVerification = new ArrayList<>();

    public ArrayList<BankData> setArrayListStock(){
        return BankVerification;
    }

    public BankVerificationScreen() {

        Dataloader dataloader = new Dataloader();
        dataloader.loadbankdata();

        BankData user = Dataloader.getUserAt(1);

        BankVerification = dataloader.getArrayListBank();

        Dataloader.save();

        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,500));
        pack();
    }



}
