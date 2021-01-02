import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffLogin extends JFrame {

    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel StaffUserNameLbl;
    private JLabel StaffPasswordLbl;
    private JButton StaffLoginBtn;

    public StaffLogin() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        StaffLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String uname = StaffUserNameLbl.getText();

                String Pass = StaffPasswordLbl.getText();

                if (uname.equals("PL14") & Pass.equals("0121")) {

                    Stock hframe = new Stock();

                    hframe.setVisible(true);

                }else {
                    AdminLogin jframe = new AdminLogin();

                    JOptionPane.showMessageDialog(jframe, "Invalid");
                }
            }
        });
    }
}
