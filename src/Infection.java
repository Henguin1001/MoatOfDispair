import java.util.Random;


public class Infection {

	int distance = 0;
	Random r = new Random();
	public Infection() {
		distance = r.nextInt(100)+800;
		int chances = r.nextInt(40);
		if(chances < 4) distance = 10000 + chances * 50;
		if(chances==0)distance = 10000000;
		if(chances==0)if(r.nextInt(10)==0) distance = Integer.MAX_VALUE;
	}
	public int travel(){
		if(distance > 0) distance--;
		return distance;
	}
	

}
