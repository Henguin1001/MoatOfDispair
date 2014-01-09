package main;

import java.util.Random;

public class Infection {

    int distance = 0;
    Random r = new Random();

    public Infection() {
        distance = r.nextInt(100) + 800;
        int random = r.nextInt(40);
        if (random < 4)
            distance = 10000 + random * 50;
        if (random == 0) {
            distance = 10000000;
        if (r.nextInt(10) == 0)
            distance = Integer.MAX_VALUE;
        }
    }

    public int travel() {
        if (distance > 0)
            distance--;
        return distance;
    }
}
