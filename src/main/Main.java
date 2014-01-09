package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import javax.swing.JPanel;

public class Main extends JPanel {
    
    private static Color alive = Color.GREEN;
    private static Color blank = Color.BLACK;
    private static Color infected = new Color(102, 51, 153); // Purple
    
    public static final int winWidth = 800;
    public static final int winHeight = 600;
    public static final int scale = 1;

    private static Life[][] grid = new Life[winWidth][winHeight];
    
    public static void main(String[] args) {
        Display display = new Display("MoatOfDispair", winWidth*scale, winHeight*scale);
        Timer timer = new Timer();
        timer.schedule(new GameControl(display), 0, 50);

        for (int x=0;x<winWidth;x++)
            for (int y=0;y<winHeight;y++)
                grid[x][y] = new Life(x,y,false);
        for (int x=winWidth/2-5;x<winWidth/2+5;x++)
            for (int y=winHeight/2-5;y<winHeight/2+5;y++)
                grid[x][y].setAlive(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int x=0;x<winWidth;x++) {
            for (int y=0;y<winHeight;y++) {
                if (grid[x][y].update(grid)) {
                    if (grid[x][y].isAlive())
                        g.setColor(alive);
                    else
                        g.setColor(blank);
                    if (grid[x][y].isInfected())
                        g.setColor(infected);
                    g.fillRect(x*scale,y*scale,scale,scale);
                }
            }
        }
    }
}
