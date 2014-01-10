package main;

public class Infection {

    private int distance = 0;

    // This needs to be balanced.
    public Infection() {
        distance = (int)(Math.random()*(100)) + 800;
        int random = (int)(Math.random()*(40));
        if (random < 4)
            distance = 10000 + random * 50;
        if (random == 0) {
            distance = 10000000;
        if ((int)(Math.random()*(10)) == 0)
            distance = Integer.MAX_VALUE;
        }
    }

    public int travel() {
        if (distance > 0)
            distance--;
        return distance;
    }
}
