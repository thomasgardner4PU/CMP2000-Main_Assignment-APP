import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BankVerificationScreen extends JFrame {

    private JPanel MainPanel;
    private JPanel Panel1;
    private JLabel VerificationLbl;
    private JButton ConfirmPaymentBtn;

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
        ConfirmPaymentBtn.addActionListener(new ActionListener() {
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