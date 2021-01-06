import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {

    private JPanel MainPanel;
    private JPanel LoginPnl;
    private JButton LoginBtn;
    private JLabel AdminPassword;
    private JLabel AdminUsername;
    private JTextField textField1;
    private JTextField textField2;

    public AdminLogin() {
        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String uname = AdminUsername.getText();

                String Pass = AdminPassword.getText();

                if (uname.equals("Morrisons") & Pass.equals("1992")){

                    Stock stock = new Stock();
                    stock.show();

                }else {

                    AdminLogin lframe = new AdminLogin();

                    JOptionPane.showMessageDialog(lframe, "Invalid");

                }

            }
        });
    }
}


