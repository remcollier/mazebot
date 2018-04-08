package mazebot.behaviour;

import java.util.HashMap;
import java.util.Map;

import mazebot.core.RobotBehaviour;

public abstract class AbstractBehaviour implements RobotBehaviour {
	protected Map<String, Object> config = new HashMap<String, Object>();
	
	public void configure(Map<String, Object> config) {
		for (String key : this.config.keySet()) {
			if (config.containsKey(key)) {
				this.config.put(key, config.get(key));
			}
		}
	}
}
