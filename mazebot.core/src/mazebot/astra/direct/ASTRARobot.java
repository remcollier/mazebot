package mazebot.astra.direct;

import javax.vecmath.Vector3d;

import astra.core.Agent;
import astra.term.ListTerm;
import astra.term.Primitive;
import mazebot.core.BasicRobot;
import mazebot.core.RobotEvent;

public class ASTRARobot extends BasicRobot {
	private Agent agent;

	public ASTRARobot(Vector3d arg0, String arg1) {
		super(arg0, arg1);
	}
	
	public void addEvent(RobotEvent event) {
		// Create a new Astra Robot Event and post it
		// to the agents event queue...
		ListTerm list = new ListTerm();
		if (event.getParams() != null) {
			for(Object param : event.getParams()) {
				list.add(Primitive.newPrimitive(param));
			}
		}
		
		agent.addEvent(new ASTRARobotEvent(
				Primitive.newPrimitive(event.getType()),
				list));
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public void performBehavior() {
		super.performBehavior();
	}
}
