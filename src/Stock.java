import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stock extends JFrame {

    private JPanel mainPanel;
    private JLabel TitleLbl;
    private JPanel Panel1;
    private JPanel Panel2;
    private JButton AddStock;
    private JButton RemoveStock;
    private JTextArea DisplayList;
    private JButton EditStock;

    public Stock (){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000,1000));
        pack();
    }
}
