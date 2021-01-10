import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminLogin extends JFrame {

    private JPanel MainPanel;
    private JPanel LoginPnl;
    private JButton LoginBtn;
    private JLabel AdminPassword;
    private JLabel AdminUsername;
    private JTextField txtUserName;
    private JTextField txtPassword;

    static AdminData[] accountsDatabase = new AdminData[1];

    public static void main(String[] args ) {
        /*Dataloader dataloader = new Dataloader();
        dataloader.LoadAdminData();*/

        AutomatedCheckOutSystem Page = new AutomatedCheckOutSystem("nextPage");
        Page.setVisible(true);
        String filePath = ("src//resources//admin.txt");
            try {
                File file = new File(filePath);

                try (Scanner scanner = new Scanner(file)) {
                    scanner.useDelimiter("\n"); //
                    while (scanner.hasNextLine()) {
                        for (int i = 0; i < accountsDatabase.length; i++) {
                            String tempName = scanner.nextLine();
                            String tempPassword = scanner.nextLine();
                            accountsDatabase[i] = new AdminData(tempName, tempPassword);
                        }
                    }
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }


        public AdminLogin() {
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        pack();
        LoginBtn.addActionListener(e -> AuthenticateUser(txtUserName.getText(), txtPassword.getText()));
    }

    public void AuthenticateUser(String usernameData, String passwordData) {
        boolean matchNotFound = true;
        for (int i = 0; i <accountsDatabase.length; i++) {
            if (accountsDatabase[i].username.equals(usernameData) && accountsDatabase[i].password.equals(passwordData)){
                matchNotFound = false;
                break;
            }
        }

        if (matchNotFound){
            System.out.println("Match Not Found");
        }

        else {
            Stock nextPage = new Stock("NextPage");
            nextPage.setVisible(true);
        }
    }
}


