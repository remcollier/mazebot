package mazebot.core;
import java.util.Map;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;

public interface MazeRobotFactory {
	public Agent create(String name, Vector3d location, Map<String, Object> config);
}
