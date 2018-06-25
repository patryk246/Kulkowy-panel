import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rysownik kulek");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new KulkowyPanel() );
        frame.setPreferredSize(new Dimension(600,600));
        frame.pack();
        frame.setVisible(true);
    }
}
