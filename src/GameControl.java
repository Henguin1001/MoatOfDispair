import java.util.TimerTask;


public class GameControl extends TimerTask{

	Display d;
	public GameControl(Display d){
		this.d = d;
	}
	@Override
	public void run() {
		d.repaint();
	}
}
