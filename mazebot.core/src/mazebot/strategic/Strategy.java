package mazebot.strategic;

import mazebot.core.RobotEvent;

public interface Strategy {
	
	public void strategize(StrategicRobot agent, RobotEvent event);
	public void initialize(StrategicRobot agent);
}
