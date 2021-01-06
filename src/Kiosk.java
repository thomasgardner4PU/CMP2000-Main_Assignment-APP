import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kiosk extends JFrame {

    private JPanel AdminPanel;
    private JLabel WelcomeLbl;
    private JPanel ScanPage;
    private JPanel PaymentPage;
    private JButton ScanItemsBtn;
    private JButton CardPayment;
    private JButton HelpBtn;
    private JTextField txtfield;
    private JTextArea itemslist;
    private JButton CashPayment;

    public Kiosk(String loading_from_file) {
        setContentPane(AdminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        HelpBtn.addActionListener(new ActionListener() {
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
                String Text;
                Text = txtfield.getText();
                itemslist.append(Text + "\r\n");
            }
        });
        CardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        CashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}