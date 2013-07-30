import java.util.Random;

public class Life {

	int x, y;
	int life = 10;
	boolean alive = false;
	boolean infected = false;
	int rate = 0;
	Random r;
	Infection virus;
	int illness = 30;
	boolean spread = true;

	public Life(int x, int y, boolean alive) {
		this.x = x;
		this.y = y;
		this.alive = alive;
		r = new Random();
	}

	public int time = 100;

	public boolean update(Life[][] grid) {
		int near = getAdjacent(grid);
		if (near == 3 && illness > 0) {
			alive = true;
			if (life == -time) {
				life = 10;
			}
		}
		if (near >= 4) {
			alive = false;
		}
		if (near < 2) {
			alive = false;
		}
		if (alive) {
			if (life == 0) {
				alive = false;
				life--;
			}
		} else {
			if (life != -time)
				life--;
		}
		if (life % 10 == 0) {
			if (x > 15 && y > 15 && x < 999 && y < 499 && x % 60 == 0
					&& y % 60 == 0) {
				int density = density(grid);
				if (density > 250) {
					int factor = (100 - (200 - density)) / 5;
					if (factor < 1)
						factor = 1;

					if (r.nextInt(factor) == 0) {
						System.out.println("virus");
						infected = true;
						rate = factor;
						virus = new Infection();
					}
				}

			}
		}
		if (infected) {
			infectUpdate(grid);
		}
		if (illness == -30) {
			illness = 30;
			infected = false;
			virus = null;
			rate = 0;
			spread = true;
		}
		return alive;

	}

	public int getAdjacent(Life[][] grid) {
		int count = 0;
		if (x > 1) {
			if (grid[x - 1][y].alive)
				count++;
			if (y > 1 && grid[x - 1][y - 1].alive)
				count++;
			if (y < 499 && grid[x - 1][y + 1].alive)
				count++;
		}
		if (y > 1 && grid[x][y - 1].alive)
			count++;

		if (x < 999) {
			if (grid[x + 1][y].alive)
				count++;
			if (y < 499 && grid[x + 1][y + 1].alive)
				count++;
			if (y > 1 && grid[x + 1][y - 1].alive)
				count++;
		}
		if (y < 499 && grid[x][y + 1].alive)
			count++;

		return count;
	}

	public int density(Life[][] grid) {
		int count = 0;
		for (int x = this.x - 15; x < this.x + 15; x++) {
			for (int y = this.y - 15; y < this.y + 15; y++) {
				if (grid[x][y].alive)
					count++;
			}
		}
		return count;
	}

	public void infectUpdate(Life[][] grid) {
		if (spread) {
			if (r.nextInt((rate / 2) + 1) == 0) {
				if (x > 1 && grid[x - 1][y].alive)
					grid[x - 1][y].infect(virus);
				if (x < 999 && grid[x + 1][y].alive)
					grid[x + 1][y].infect(virus);
				if (y > 1 && grid[x][y - 1].alive)
					grid[x][y - 1].infect(virus);
				if (y < 499 && grid[x][y + 1].alive)
					grid[x][y + 1].infect(virus);

			}
		}
		if (illness == 0) {
			alive = false;
			illness--;
		} else {
			illness--;
		}
	}

	public void infect(Infection v) {
		infected = true;
		virus = v;
		if(v.travel()==0) spread=false;
	}

	// public ArrayList<Life> getAdjacent(Life[][] grid){
	// ArrayList<Life> a = new ArrayList<Life>();
	// a.add(grid[x][y]);
	// if(x > 0){
	// a.add(grid[x-1][y]);
	// if(y > 0)
	// a.add(grid[x-1][y-1]);
	// if(y < 500)
	// a.add(grid[x-1][y+1]);
	// }
	// if(y > 0){
	// a.add(grid[x][y-1]);
	// }
	// if(x < 1000){
	// a.add(grid[x+1][y]);
	// if(y < 500)
	// a.add(grid[x+1][y+1]);
	// if(y > 0)
	// a.add(grid[x+1][y-1]);
	// }
	// if(y < 500){
	// a.add(grid[x][y+1]);
	// }
	//
	// return a;
	// }

}
