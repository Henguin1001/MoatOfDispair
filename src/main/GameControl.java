package main;

import java.util.TimerTask;

public class GameControl extends TimerTask {

    private Display display;

    public GameControl(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        display.repaint();
    }
}
