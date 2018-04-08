package mazebot.core;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.SensorDevice;

public class BasicRobot extends Agent {

	public BasicRobot(Vector3d arg0, String arg1) {
		super(arg0, arg1);
	}
	
	private String behaviour;
	protected Queue<RobotEvent> events = new LinkedList<RobotEvent>();
	
	private Map<String,RobotBehaviour> behaviours = new HashMap<String,RobotBehaviour>();
	private Map<String,SensorDevice> sensors = new HashMap<String,SensorDevice>();
	
	
	
	public void installBehaviour(String id,RobotBehaviour behaviour) {
		behaviours.put(id, behaviour);
	}
	
	public void installSensor(String id,SensorDevice sensor) {
		sensors.put(id, sensor);
	}
	
	public SensorDevice getSensor(String id) {
		return sensors.get(id);
	}
	
	public void performBehavior() {
		if (!collisionDetection()) {
			executeBehaviour();
		}
	}
	
	protected boolean collisionDetection() {
		if (collisionDetected()) {
			addEvent(new RobotEvent("Collision", null));
			return true;
		}
		return false;
	}
	
	protected void executeBehaviour() {
		if(behaviour!=null){
			if(behaviours.get(behaviour) == null) {
				System.out.println("No such behaviour: " + behaviour);
			}
//			System.out.println("executing: " +behaviour);
			behaviours.get(behaviour).execute(this);
		}
	}

	public void setBehaviour(String string) {
		this.behaviour = string;
	}
	
	public void setBehaviour(String behaviour, Map<String, Object> config) {
		this.behaviour = behaviour;
		behaviours.get(behaviour).configure(config);
	}
	
	public String getBehaviour() {
		return behaviour;
	}
	
	public void addEvent(RobotEvent event) {
		events.add(event);
	}

	public boolean hasEvents() {
		return !events.isEmpty();
	}
	
	public RobotEvent getEvent() {
		return events.poll();
	}
}
