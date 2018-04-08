package mazebot.behaviour;

import mazebot.core.BasicRobot;
import mazebot.core.RobotEvent;
import simbad.sim.RangeSensorBelt;

public class GoStraight extends AbstractBehaviour {
	private boolean moving = false;
	
	public GoStraight() {
		config.put("speed", 0.4);
		config.put("stop", 0.4);
	}
	
	@Override
	public void execute(BasicRobot agent) {
		RangeSensorBelt sonars = (RangeSensorBelt) agent.getSensor("sonar");
		if (sonars == null)
			throw new RuntimeException("No sonar installed");
		
//		double front = sonars.getMeasurement(0);
		double front = Math.min(sonars.getMeasurement(0), Math.min(Math.cos(Math.PI/4)*sonars.getMeasurement(1), Math.cos(Math.PI/4)*sonars.getMeasurement(7)));
//		double front = sonars.getFrontQuadrantMeasurement();
		if (front <= ((double) config.get("stop"))) {
			moving = false;
			agent.setTranslationalVelocity(0);
			agent.addEvent(new RobotEvent("Stopped", null));
			agent.setBehaviour(null);
		} else if (!moving) {
			agent.setTranslationalVelocity((double) config.get("speed"));
			agent.setRotationalVelocity(0);
			moving = true;
		}
		
	}
}
