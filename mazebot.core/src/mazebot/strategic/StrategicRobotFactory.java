package mazebot.strategic;
import java.util.Map;

import javax.vecmath.Vector3d;

import mazebot.core.MazeRobotFactory;
import simbad.sim.Agent;

public class StrategicRobotFactory implements MazeRobotFactory {

	public Agent create(String name, Vector3d location, Map<String, Object> config) {
		StrategicRobot myRobot = new StrategicRobot(location, name);
		
		try {
			myRobot.setStrategy((Strategy) Class.forName(config.get("strategy").toString()).newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return myRobot;
	}
}
