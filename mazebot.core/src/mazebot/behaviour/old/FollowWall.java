package mazebot.behaviour.old;

import java.util.Map;

import mazebot.core.BasicRobot;
import mazebot.core.RobotBehaviour;
import simbad.sim.RangeSensorBelt;

public class FollowWall implements RobotBehaviour {

	@Override
	public void execute(BasicRobot agent) {
		// reads the three front quadrants
		RangeSensorBelt sonars = (RangeSensorBelt) agent.getSensor("sonar");
		if (sonars == null)
			throw new RuntimeException("No sonar installed");
		
		if (!sonars.oneHasHit()) {
			System.out.println("Lost Wall...");
		} else {
			double left = sonars.getFrontLeftQuadrantMeasurement();
			double right = sonars.getFrontRightQuadrantMeasurement();
			double front = sonars.getFrontQuadrantMeasurement();

			// if obstacle near
			// if(sonars.hasHit(MyEnv.b1))
			if ((front < 1.0) || (left < 1.0) || (right < 1.0)) {
				agent.setRotationalVelocity(-1); // always turns left
				agent.setTranslationalVelocity(0.6);
				System.out.println("left");
//			} else if ((front > 1.2) || (left > 1.2) || (right > 1.2)) {
//				System.out.println("straight");
//				agent.setRotationalVelocity(0);
//				agent.setTranslationalVelocity(0.6);
			} else if ((front > 1.2) || (left > 1.2) || (right > 1.2)) {
				System.out.println("right");
				agent.setRotationalVelocity(1);
				agent.setTranslationalVelocity(0.6);
			} else {
				System.out.println("stop turning");
				agent.setRotationalVelocity(0);
			}
			System.out.println("rot vel: " + agent.getRotationalVelocity());
			System.out.println("trans vel: " + agent.getTranslationalVelocity());
		}
	}

	@Override
	public void configure(Map<String, Object> config) {
		// TODO Auto-generated method stub
		
	}
}
