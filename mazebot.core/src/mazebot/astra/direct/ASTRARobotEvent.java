package mazebot.astra.direct;

import astra.event.Event;
import astra.term.Term;

public class ASTRARobotEvent implements Event {
	public final Term type;
	public final Term params;
	
	public ASTRARobotEvent(Term type, Term params) {
		this.type = type;
		this.params = params;
	}
	
	@Override
	public Object getSource() {
		return null;
	}

	@Override
	public String signature() {
		return "$re";
	}
}
