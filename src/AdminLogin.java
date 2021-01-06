import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminLogin extends JFrame {

    private JPanel MainPanel;
    private JPanel LoginPnl;
    private JButton LoginBtn;
    private JLabel AdminPassword;
    private JLabel AdminUsername;
    private JTextField textField1;
    private JTextField textField2;

    public AdminLogin() {
        setContentPane(MainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        pack();
        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code for opening stock menu
                Stock Page = new Stock();
                Page.setVisible(true);
            }
        });
    }

    public void setPassword(String[] userData) {
    }

    //add code here which mentions load method from AdminUser class
}


