package mazebot.strategic;

import java.util.HashMap;
import java.util.Map;

import mazebot.core.RobotEvent;

public class BasicStrategy implements Strategy{

	@Override
	public void strategize(StrategicRobot agent, RobotEvent event) {
		if (event.getType().equals("FoundWall")) {
			Map<String, Object> config = new HashMap<String, Object>();
			config.put("speed", 0.8);
			agent.setBehaviour("FollowWall", config);
			System.out.println("Found Wall");
		} else if (event.getType().equals("Collision")) {
			System.out.println("Collision...");
		} else if (event.getType().equals("LostWall")) {
			agent.setBehaviour("FindWall");
			System.out.println("Lost Wall");
		}
	}

	public void initialize(StrategicRobot agent) {
		agent.setBehaviour("FindWall");
	}
	
}
