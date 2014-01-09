package main;

import java.util.ArrayList;
import java.util.TimerTask;

public class LifeSupport extends TimerTask {

    Life[][] grid = new Life[1000][500];
    ArrayList<Life> changed = new ArrayList<Life>();

    public LifeSupport() {
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
    public void run() {
        changed.clear();
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 500; y++) {
                boolean alive = grid[x][y].isAlive();
                if (grid[x][y].update(grid) != alive) {
                    changed.add(grid[x][y]);
                }
            }
        }

    }

    public synchronized ArrayList<Life> updated() {
        return changed;
    }
}
