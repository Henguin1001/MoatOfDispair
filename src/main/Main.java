package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JPanel;

public class Main extends JPanel {

    private static Life[][] grid = new Life[1000][500];
    
    private Color alive = Color.GREEN;
    private Color blank = Color.BLACK;
    private Color infected = new Color(102, 51, 153);

    public static void main(String[] args) {
        Display d = new Display("test", 1000, 500);
        Timer t = new Timer();
        t.schedule(new GameControl(d), 0, 50);

        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 500; y++) {
                grid[x][y] = new Life(x, y, false);
            }
        }
        for (int x = 495; x < 505; x++) {
            for (int y = 245; y < 255; y++) {
                grid[x][y] = new Life(x, y, true);
            }
        }


    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,1000,500);
        for (int x=0;x<1000;x++) {
            for (int y=0;y<500;y++) {
                if (grid[x][y].update(grid)) {
                    if (grid[x][y].isAlive())
                        g.setColor(alive);
                    else
                        g.setColor(blank);
                    if (grid[x][y].isInfected())
                        g.setColor(infected);
                    g.fillRect(x,y,1,1);
                }
            }
        }
    }
}
