package mazebot.behaviour;

import mazebot.core.BasicRobot;
import mazebot.core.RobotEvent;

public class TurnLeft extends AbstractBehaviour {
	private int turningCount = -1;
	
	public TurnLeft() {
		config.put("speed", 0.0);
		config.put("rotation_count", 20);
	}

	@Override
	public void execute(BasicRobot agent) {
		// If turningRightCount is 0, we have completed a 90 degree right turn. 
		if (turningCount == 0) {
			agent.addEvent(new RobotEvent("TurnedLeft", null));
			agent.setBehaviour(null);
			turningCount = -1;
			agent.setRotationalVelocity(0);
			agent.setTranslationalVelocity(0);
		} else {
			if (turningCount == -1) {
				turningCount = (int) config.get("rotation_count");
				agent.setTranslationalVelocity((double) config.get("speed"));
				agent.setRotationalVelocity(Math.PI / 2);
			}
			turningCount--;
		}			
	}
}
