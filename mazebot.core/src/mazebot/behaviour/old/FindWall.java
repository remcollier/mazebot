package mazebot.behaviour.old;

import java.util.Map;

import mazebot.core.BasicRobot;
import mazebot.core.RobotBehaviour;
import mazebot.core.RobotEvent;
import simbad.sim.RangeSensorBelt;

public class FindWall implements RobotBehaviour {

	@Override
	public void execute(BasicRobot agent) {
		RangeSensorBelt bumpers = (RangeSensorBelt) agent.getSensor("bumper");
		if (bumpers == null)
			throw new RuntimeException("No bumper installed");
		RangeSensorBelt sonars = (RangeSensorBelt) agent.getSensor("sonar");
		if (sonars == null)
			throw new RuntimeException("No sonar installed");

		if (bumpers.oneHasHit()) {
			for (int i = 0; i < bumpers.getNumSensors(); i++) {
				double angle = bumpers.getSensorAngle(i);
				boolean hit = bumpers.hasHit(i);
				if (hit == true) {
					agent.addEvent(new RobotEvent("HitWall", null));
					agent.setBehaviour("FollowWall");
				}

				System.out.println("Bumpers at angle " + angle + " has hit something:" + hit);
			}
		}

		else if (sonars.oneHasHit()) {	
			agent.addEvent(new RobotEvent("FoundWall", null));
			agent.setBehaviour(null);
		}

		else {
			agent.setTranslationalVelocity(0.5);
			agent.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));
		}
	}

	@Override
	public void configure(Map<String, Object> config) {
	}
}
