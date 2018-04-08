package mazebot.cartago;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import cartago.ARTIFACT_INFO;
import cartago.Artifact;
import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.OUTPORT;
import cartago.OpFeedbackParam;
import cartago.OperationException;
import mazebot.core.RobotBehaviour;
import mazebot.core.RobotEvent;
import simbad.sim.RobotFactory;

@ARTIFACT_INFO(outports = { @OUTPORT(name = "out-1") })
public class RobotArtifact extends Artifact {
	private CArtAgORobot robot;

	public RobotArtifact() {
		super();
	}
	
	public void init() {
		this.defineObsProperty("events", 0);
	}

	@OPERATION
	public void initRobot(double x, double y) {
		// Create the body
		robot = new CArtAgORobot(new Vector3d(x, 0, y), this.getId().getName());
		robot.setArtifact(this);
		// Link it to the environment
		try {
			execLinkedOp("out-1", "link", robot);
			execInternalOp("checkEvents");
		} catch (OperationException e) {
			e.printStackTrace();
		}
	}

	@OPERATION
	public void addSensor(String sensor) {
		if (sensor.equals("sonar")) {
			robot.installSensor("sonar", RobotFactory.addSonarBeltSensor(robot, 8));
		} else if (sensor.equals("bumper")) {
			robot.installSensor("bumper", RobotFactory.addBumperBeltSensor(robot, 8));
		} else if (sensor.equals("compass")) {
			robot.installSensor("compass", RobotFactory.addLightSensor(robot));
		} else {
			throw new RuntimeException("No such sensor: " + sensor);
		}
	}
	
	@OPERATION
	public void addBehaviour(String behaviour) {
		String code = MazeBotArtifact.behaviours.get(behaviour);
		if (code == null) throw new RuntimeException("Behaviour: " + behaviour + " not registered with Mazebot");
		
		try {
			robot.installBehaviour(behaviour, (RobotBehaviour) Class.forName(code).getConstructor().newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new RuntimeException("Failed to install behacviour: " + behaviour, e);
		}
	}
	
	@OPERATION
	public void setBehaviour(String behaviour) {
		if (robot == null)
			throw new RuntimeException("Agent is not linked to a robot");
		robot.setBehaviour(behaviour);
	}

	@OPERATION
	public void setVelocity(double translation, double rotation) {
		if (robot == null)
			throw new RuntimeException("Agent is not linked to a robot");
		robot.setTranslationalVelocity(translation);
		robot.setRotationalVelocity(rotation);
	}

	@OPERATION
	public void setBehaviour(String behaviour, Map<String, Object> config) {
		if (robot == null)
			throw new RuntimeException("Agent is not linked to a robot");

		robot.setBehaviour(behaviour, config);
	}

	@OPERATION
	public void stop() {
		if (robot == null)
			throw new RuntimeException("Agent is not linked to a robot");

		robot.setBehaviour(null);
	}

	@OPERATION
	public void getCoordinates(OpFeedbackParam<Double> x, OpFeedbackParam<Double> y) {
		Point3d coords = new Point3d();
		robot.getCoords(coords);
		x.set(coords.x);
		y.set(coords.z);
	}

	@INTERNAL_OPERATION
	public void checkEvents() {
		while (true) {
			while (robot.hasEvents()) {
				RobotEvent event = robot.getEvent();
				if (event.getParams() == null) {
					signal(event.getType());
				} else {
					signal(event.getType(), event.getParams());
				}
			}
			await_time(100);
		}
	}
}