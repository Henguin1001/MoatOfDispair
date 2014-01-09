package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JPanel;

public class Main extends JPanel {

    private static Life[][] grid = new Life[1000][500];
    
    private static Color alive = Color.GREEN;
    private static Color blank = Color.BLACK;
    private static Color infected = new Color(102, 51, 153); // Purple
    
    public static final int width = 1000;
    public static final int height = 500;

    public static void main(String[] args) {
        Display display = new Display("test", width, height);
        Timer timer = new Timer();
        timer.schedule(new GameControl(display), 0, 50);

        for (int x=0;x<width;x++)
            for (int y=0;y<height;y++)
                grid[x][y] = new Life(x,y,false);
        for (int x=width/2-5;x<width/2+5;x++)
            for (int y=height/2-5;y<height/2+5;y++)
                grid[x][y].setAlive(true);
    }

    @Override
    public void paintComponent(Graphics g) {
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
