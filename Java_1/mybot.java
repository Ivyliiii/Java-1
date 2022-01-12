import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

public class mybot extends Bot{
	public mybot(MazeRunner mr, Color c) {
		super(mr, c);
		// TODO Auto-generated constructor stub
	}

	
	int phase = 1;
	int times = 0;
	
	public void move() {
		if(phase == 1) {
			if(moveForward()) {
				phase = 2;
			}
			else {
				phase = 3;
			}
		}
		else if(phase == 2) {
			turnLeft();
			phase = 1;
		}
		else if(phase == 3){
			if(times != 3) {
				turnLeft();
				times++;
			}
			else {
				times = 0;
				phase = 1;
			}
		}
	}
	

}
