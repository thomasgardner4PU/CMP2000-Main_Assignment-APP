import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomatedCheckOutSystem extends JFrame {

    public static void main(String[] args){
        AutomatedCheckOutSystem Page = new AutomatedCheckOutSystem();
        Page.setVisible(true);
    }

    private JPanel mainPanel;
    private JLabel welcomeLbl;
    private JButton BeginScanBtn;

    public AutomatedCheckOutSystem() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        pack();
        BeginScanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code below allows the JButton BeginScanBtn to open other form, allowing
                // the user to begin their order.
                Kiosk kiosk = new Kiosk();
                Kiosk.innit();
                kiosk.show(); // display the kiosk form

                dispose(); // close current frame after opening the Kiosk menu
            }
        });
    }

}
