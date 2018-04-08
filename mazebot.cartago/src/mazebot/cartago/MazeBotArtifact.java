package mazebot.cartago;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.vecmath.Vector3d;

import cartago.Artifact;
import cartago.LINK;
import cartago.OPERATION;
import mazebot.core.MazeEnvironment;
import mazebot.core.MazeGenerator;
import simbad.gui.Simbad;
import simbad.sim.Wall;

public class MazeBotArtifact extends Artifact {
	private static Simbad frame;
	private static MazeEnvironment environment;
	public static Map<String, String> behaviours = new HashMap<String, String>();
	private static List<Wall> walls = new LinkedList<Wall>();

	@LINK
	public void link(CArtAgORobot robot) {
		environment.add(robot);
	}
	
	@OPERATION
	public void createWorld() {
		if (environment != null) throw new RuntimeException("World already created!");
		environment = new MazeEnvironment();
	}
	
	@OPERATION
	public void generateMaze(String generator) {
		if (environment == null) throw new RuntimeException("Need to create a maze first");
		
		try {
			((MazeGenerator) Class.forName(generator).getConstructor().newInstance()).generate(environment);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	@OPERATION
	public void launchGUI() {
		if (frame == null) frame = new Simbad(environment,false);
	}
	
	@OPERATION
	public void addWall(double x, double y, float length, float height) {
		Wall wall = new Wall(new Vector3d(x, 0 ,y), length, height, environment);
		walls.add(wall);
		environment.add(wall);
	}
	
	@OPERATION
	public void installBehaviour(String name, String code) {
		behaviours.put(name, code);
	}
}
