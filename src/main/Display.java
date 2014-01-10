package main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Display extends JFrame {

    public Display(String windowName, int width, int height) {
        super(windowName);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setContentPane(new Main());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(Color.black);
    }
}
