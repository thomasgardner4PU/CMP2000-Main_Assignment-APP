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
    private JButton Payment;
    private JButton StaffBtn;

    public Kiosk(String loading_from_file) {
        setContentPane(AdminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        StaffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin Page = new AdminLogin();
                Page.show();

                dispose();
            }
        });
    }
}