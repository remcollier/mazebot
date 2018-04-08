package mazebot.behaviour;

import javax.vecmath.Point3d;

import mazebot.core.BasicRobot;
import mazebot.core.RobotEvent;

public class Orient extends AbstractBehaviour {
	public Orient() {
		config.put("speed", 0.2);
		config.put("stop", 0.4);
	}
	
	public static final int TEST_STEPS = 3;
	
	private double[] cumulative = new double[2];
	private double[] last = new double[2];
	private boolean forwards = true;
	private int steps = TEST_STEPS;
	private Point3d coords = new Point3d();
	
	@Override
	public void execute(BasicRobot agent) {
//		System.out.println("orienting: " + steps);
		if (forwards) {
			double[] current = new double[2];
			agent.getCoords(coords);
			current[0] = coords.x;
			current[1] = coords.z;
			
			if (steps == TEST_STEPS) {
				agent.setTranslationalVelocity((double) config.get("speed"));
				agent.setRotationalVelocity(0);
				steps--;
			} else if (steps == 0) {
				agent.setTranslationalVelocity(-(double) config.get("speed"));
				agent.setRotationalVelocity(0);
//				System.out.println("cumulative: (" + cumulative[0] + ", " + cumulative[1]+ ")");
				forwards = false;
			} else {
				cumulative[0] += current[0]-last[0]; 
				cumulative[1] += current[1]-last[1];
				steps--;
			}
			last = current;
			
		} else {
			if (steps < TEST_STEPS) {
				steps++;
			} else if (steps == TEST_STEPS) {
				// send oriented event...
				agent.addEvent(new RobotEvent("Oriented", new Object[] {chooseDirection(cumulative)}));
				agent.setBehaviour(null);
				agent.setTranslationalVelocity(0);
				agent.setRotationalVelocity(0);
				
				//reset behaviour
				forwards = true;
				cumulative[0] = 0;
				cumulative[1] = 0;
			}
		}
		
	}

	private String chooseDirection(double[] cumulative) {
		if (Math.abs(cumulative[0]) > Math.abs(cumulative[1])) {
			if (cumulative[0] > 0) return "East"; else return "West"; 
		} else if (Math.abs(cumulative[0]) < Math.abs(cumulative[1])) {
			if (cumulative[1] > 0) return "North"; else return "South"; 
		}
		return "None";
	}
}
