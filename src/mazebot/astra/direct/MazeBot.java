package mazebot.astra.direct;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.vecmath.Vector3d;

import astra.core.Module;
import astra.reasoner.Unifier;
import astra.term.Funct;
import astra.term.ListTerm;
import astra.term.Primitive;
import astra.term.Term;
import mazebot.core.MazeEnvironment;
import mazebot.core.MazeGenerator;
import mazebot.core.RobotBehaviour;
import simbad.gui.Simbad;
import simbad.sim.RobotFactory;
import simbad.sim.Wall;

public class MazeBot extends Module {
	static {
		Unifier.eventFactory.put(ASTRARobotEvent.class, new ASTRARobotEventUnifier());
	}

	private static Simbad frame;
	private static MazeEnvironment environment;
	private static Map<String, String> behaviours = new HashMap<String, String>();
	private static List<Wall> walls = new LinkedList<Wall>();

	@ACTION
	public boolean createWorld() {
		if (environment != null) throw new RuntimeException("World already created!");
		environment = new MazeEnvironment();
		return true;
	}
	
	@ACTION
	public boolean generateMaze(String generator) {
		if (environment == null) throw new RuntimeException("Need to create a maze first");
		
		try {
			((MazeGenerator) Class.forName(generator).getConstructor().newInstance()).generate(environment);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
		
	@ACTION
	public boolean launchGUI() {
		frame = new Simbad(environment,false);
		
		return true;
	}
	
	public boolean addWall(double x, double y, float length, float height) {
		walls.add(new Wall(new Vector3d(x, 0 ,y), length, height, environment));
		return true;
	}
	
	@ACTION
	public boolean installBehaviour(String name, String code) {
		behaviours.put(name, code);
		return true;
	}

	@SuppressWarnings("unchecked")
	@ACTION
	public boolean installBehaviours(ListTerm behaviours) {
		for(Term behaviour : behaviours) {
			installBehaviour(
					((Primitive<String>) ((Funct) behaviour).termAt(0)).value(), 
					((Primitive<String>) ((Funct) behaviour).termAt(1)).value()
			);
		}
		return true;
	}

	@TERM public ASTRARobot createRobot(String name, double x, double y) {
		ASTRARobot robot = new ASTRARobot(new Vector3d(x, 0 ,y), name);
		environment.add(robot);
		return robot;
	}
	
	@ACTION public boolean addSensor(ASTRARobot robot, String sensor) {
		if (sensor.equals("sonar")) {
			robot.installSensor("sonar", RobotFactory.addSonarBeltSensor(robot, 8));
		} else if (sensor.equals("bumper")) {
			robot.installSensor("bumper", RobotFactory.addBumperBeltSensor(robot, 8));
		} else if (sensor.equals("compass")) {
			robot.installSensor("compass", RobotFactory.addLightSensor(robot));
		} else {
			throw new RuntimeException("No such sensor: " + sensor);
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@ACTION public boolean addSensors(ASTRARobot robot, ListTerm sensors) {
		for (Term sensor : sensors) {
			addSensor(robot, ((Primitive<String>) sensor).value());
		}
		return true;
	}

	@ACTION public boolean addBehaviour(ASTRARobot robot, String behaviour) {
		String code = behaviours.get(behaviour);
		if (code == null) throw new RuntimeException("Behaviour: " + behaviour + " not registered with Mazebot");
		
		try {
			robot.installBehaviour(behaviour, (RobotBehaviour) Class.forName(code).getConstructor().newInstance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new RuntimeException("Failed to install behacviour: " + behaviour, e);
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@ACTION public boolean addBehaviours(ASTRARobot robot, ListTerm behaviours) {
		for (Term behaviour : behaviours) {
			addBehaviour(robot, ((Primitive<String>) behaviour).value());
		}
		return true;
	}
}
