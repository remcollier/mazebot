package mazebot.astra.direct;

import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Point3d;

import astra.core.ActionParam;
import astra.core.Module;
import astra.event.Event;
import astra.term.Funct;
import astra.term.ListTerm;
import astra.term.Primitive;
import astra.term.Term;

public class Robot extends Module {
	private ASTRARobot robot;

	@ACTION
	public boolean link(ASTRARobot robot) {
		this.robot = robot;
		robot.setAgent(agent);
		return true;
	}
	
	@ACTION
	public boolean setBehaviour(String behaviour) {
		if (robot == null) throw new RuntimeException("Agent is not linked to a robot");
		robot.setBehaviour(behaviour);
		return true;
	}

	@ACTION
	public boolean setVelocity(double translation, double rotation) {
		if (robot == null) throw new RuntimeException("Agent is not linked to a robot");
		robot.setTranslationalVelocity(translation);
		robot.setRotationalVelocity(rotation);
		return true;
	}

	@ACTION
	public boolean setBehaviour(String behaviour, ListTerm config) {
		if (robot == null) throw new RuntimeException("Agent is not linked to a robot");
		
		Map<String, Object> map = new HashMap<String, Object>();
		for (Term term : config) {
			Funct funct = (Funct) term;
			map.put(funct.functor(), ((Primitive) funct.termAt(0)).value()); 
		}
		
		robot.setBehaviour(behaviour, map);
		return true;
	}

	@ACTION
	public boolean getCoordinates(ActionParam<Double> x, ActionParam<Double> y) {
		Point3d coords = new Point3d();
		robot.getCoords(coords);
		x.set(coords.x);
		y.set(coords.z);
		return true;
	}
	
	@EVENT(types = { "string", "list" }, signature = "$re", symbols = {})
	public Event event(Term type, Term params) {
		return new ASTRARobotEvent(type,params);
	}
}
