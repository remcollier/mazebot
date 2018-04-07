package mazebot.core;

import java.util.Map;

public interface RobotBehaviour {
	public void configure(Map<String, Object> config);

	public void execute(BasicRobot agent);
}
