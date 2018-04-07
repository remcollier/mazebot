package mazebot.cartago;

import javax.vecmath.Vector3d;

import mazebot.core.BasicRobot;

public class CArtAgORobot extends BasicRobot {
	private RobotArtifact artifact;
	
	public CArtAgORobot(Vector3d location, String name) {
		super(location, name);
	}

	public void setArtifact(RobotArtifact artifact) {
		this.artifact = artifact;
	}

	public void performBehavior() {
		super.performBehavior();
		
		if(!events.isEmpty()) {
			artifact.handleEvent(events.poll());
		}
	}
}
