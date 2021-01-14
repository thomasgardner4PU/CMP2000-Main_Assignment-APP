import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AdminLogin extends JFrame {

    private JPanel MainPanel;
    private JPanel LoginPnl;
    private JButton LoginBtn;
    private JLabel AdminPassword;
    private JLabel AdminUsername;
    private JTextField txtUserName;
    private JTextField txtPassword;

    public ArrayList<AdminData> accountsDatabase = new ArrayList<>();

    public void setAccountsDatabase(ArrayList<AdminData> accountsDatabase) {
        this.accountsDatabase = accountsDatabase;
    }

    public AdminLogin() {
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        pack();
        Dataloader dataloader = new Dataloader();
        dataloader.LoadAdminData();
        setAccountsDatabase(dataloader.getAccounts());

        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AuthenticateUser();
            }
        });
    }


    public void AuthenticateUser() {
        boolean matchNotFound = true;
        if (txtUserName.getText().isEmpty() | txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Please put in valid username and password");
        }
        else {
            for (int i = 0; i <accountsDatabase.size(); i++) {
                if (accountsDatabase.get(i).getUsername().equals(txtUserName.getText()) && accountsDatabase.get(i).getPassword().equals(txtPassword.getText())){
                    matchNotFound = false;
                    break;
                }
                else {
                    System.out.println("Test works");
                }
            }
        }

        if (matchNotFound){
            System.out.println("Match Not Found");
        }

        else {
            StockAdmin nextPage = new StockAdmin("NextPage");
            nextPage.setVisible(true);
        }
    }
}



