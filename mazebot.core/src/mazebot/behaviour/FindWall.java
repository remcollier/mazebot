package mazebot.behaviour;

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
			double left = sonars.getFrontLeftQuadrantMeasurement();
			double right = sonars.getFrontRightQuadrantMeasurement();
			double front = sonars.getFrontQuadrantMeasurement();

			if (front - left > 0.3) {
				// wall is on left, so turn towards it
				agent.setTranslationalVelocity(0.3);
				agent.setRotationalVelocity(1);
			} else if (front - right > 0.3) {
				agent.setTranslationalVelocity(0.3);
				agent.setRotationalVelocity(-1);
			} else if (front > 1.0) {
				agent.setTranslationalVelocity(0.3);
				agent.setRotationalVelocity(0);
			}else {
				agent.addEvent(new RobotEvent("FoundWall", null));
				agent.setBehaviour(null);
			}
		}

		else {
			// progress at 0.5 m/s
			agent.setTranslationalVelocity(0.8);
			// frequently change orientation

			agent.setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

		}

	}

	@Override
	public void configure(Map<String, Object> config) {
		// TODO Auto-generated method stub
		
	}
}
