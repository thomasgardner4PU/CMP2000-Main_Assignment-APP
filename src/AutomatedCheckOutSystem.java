import javax.swing.*;
import java.awt.*;

public class AutomatedCheckOutSystem extends JFrame {

    private JPanel mainPanel;
    private JLabel welcomeLbl;
    private JButton BeginScanBtn;

    public static void main(String[] args ) {
        AutomatedCheckOutSystem Page = new AutomatedCheckOutSystem("loading from file");
        Page.setVisible(true);
    }

    public AutomatedCheckOutSystem(String loading_from_file) {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
    }
}
