package mazebot.core;

public class RobotEvent {
	private String type;
	private Object[] parameters;
	
	public String getType() {
		return type;
	}
	
	public Object[] getParams() {
		return parameters;
	}
	
	public RobotEvent(String type, Object[] parameters) {
		this.type = type;
		this.parameters = parameters;
	}
}
