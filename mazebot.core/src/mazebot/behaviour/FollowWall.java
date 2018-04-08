package mazebot.behaviour;

import mazebot.core.BasicRobot;
import mazebot.core.RobotEvent;
import simbad.sim.RangeSensorBelt;

public class FollowWall extends AbstractBehaviour {
	private boolean moving = false;
	
	public FollowWall() {
		config.put("speed", 0.4);
		config.put("stop", 0.4);
		config.put("dist", 2.5);
		config.put("side", "right");
	}
	
	@Override
	public void execute(BasicRobot agent) {
		RangeSensorBelt sonars = (RangeSensorBelt) agent.getSensor("sonar");
		if (sonars == null)
			throw new RuntimeException("No sonar installed");
		
//		double front = sonars.getFrontQuadrantMeasurement();
		double front = Math.min(sonars.getMeasurement(0), Math.min(Math.cos(Math.PI/4)*sonars.getMeasurement(1), Math.cos(Math.PI/4)*sonars.getMeasurement(7)));

		double left = sonars.getMeasurement(2);
		double right = sonars.getMeasurement(6);
		
		if (front <= ((double) config.get("stop"))) {
			moving = false;
			agent.addEvent(new RobotEvent("Stopped", null));
			agent.setBehaviour(null);
			agent.setTranslationalVelocity(0);
		} else if (config.get("side").equals("right") && (right > (double) config.get("dist"))) {
			moving = false;
			System.out.println("right: " + right);
			agent.addEvent(new RobotEvent("LostWall", new Object[] {"right"}));
			agent.setTranslationalVelocity(0);
			agent.setBehaviour(null);
		} else if (config.get("side").equals("left") && (left > (double) config.get("dist"))) {
			moving = false;
			agent.setTranslationalVelocity(0);
			agent.addEvent(new RobotEvent("LostWall", new Object[] {"left"}));
			agent.setBehaviour(null);
		}else if (!moving) {
			agent.setTranslationalVelocity((double) config.get("speed"));
			agent.setRotationalVelocity(0);
			moving = true;
		}
	}
}
