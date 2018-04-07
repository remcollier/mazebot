package mazebot.strategic;

import javax.vecmath.Vector3d;

import mazebot.core.BasicRobot;

public class StrategicRobot extends BasicRobot {

	private Strategy strategy;

	public StrategicRobot(Vector3d arg0, String arg1) {
		super(arg0, arg1);
	}
	
	public void performBehavior() {
		super.performBehavior();
		
		if(!events.isEmpty()) {
			strategy.strategize(this, events.poll());
		}
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
		strategy.initialize(this);
	}

}
