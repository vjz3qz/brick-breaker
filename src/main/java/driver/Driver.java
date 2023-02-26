package driver;
import javax.swing.JFrame;

public class Driver {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker");
        BrickBreakerPanel panel=new BrickBreakerPanel();
        frame.setSize(700, 1000);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

}
