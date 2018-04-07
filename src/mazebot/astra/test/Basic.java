package mazebot.astra.test;
/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;

import mazebot.astra.direct.Robot;

public class Basic extends ASTRAClass {
	public Basic() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"mazebot.astra.test.Basic", new int[] {9,9,9,56},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(new ObjectType(mazebot.astra.direct.ASTRARobot.class), "rbt",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"mazebot.astra.test.Basic", new int[] {9,55,12,5},
				new Statement[] {
					new ModuleCall("robot",
						"mazebot.astra.test.Basic", new int[] {10,8,10,23},
						new Predicate("link", new Term[] {
							new Variable(new ObjectType(mazebot.astra.direct.ASTRARobot.class), "rbt")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.Robot) intention.getModule("mazebot.astra.test.Basic","robot")).link(
									(mazebot.astra.direct.ASTRARobot) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("robot",
						"mazebot.astra.test.Basic", new int[] {11,8,11,38},
						new Predicate("setBehaviour", new Term[] {
							Primitive.newPrimitive("FindWall")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.Robot) intention.getModule("mazebot.astra.test.Basic","robot")).setBehaviour(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mazebot.astra.test.Basic", new int[] {14,9,14,49},
			new ModuleEvent("robot",
				"$re",
				new Predicate("event", new Term[] {
					Primitive.newPrimitive("FoundWall"),
					new Variable(Type.LIST, "params",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((mazebot.astra.direct.Robot) agent.getModule("mazebot.astra.test.Basic","robot")).event(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"mazebot.astra.test.Basic", new int[] {14,48,16,5},
				new Statement[] {
					new ModuleCall("robot",
						"mazebot.astra.test.Basic", new int[] {15,8,15,40},
						new Predicate("setBehaviour", new Term[] {
							Primitive.newPrimitive("FollowWall")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.Robot) intention.getModule("mazebot.astra.test.Basic","robot")).setBehaviour(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mazebot.astra.test.Basic", new int[] {18,9,18,48},
			new ModuleEvent("robot",
				"$re",
				new Predicate("event", new Term[] {
					Primitive.newPrimitive("LostWall"),
					new Variable(Type.LIST, "params",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((mazebot.astra.direct.Robot) agent.getModule("mazebot.astra.test.Basic","robot")).event(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"mazebot.astra.test.Basic", new int[] {18,47,20,5},
				new Statement[] {
					new ModuleCall("robot",
						"mazebot.astra.test.Basic", new int[] {19,8,19,38},
						new Predicate("setBehaviour", new Term[] {
							Primitive.newPrimitive("FindWall")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.Robot) intention.getModule("mazebot.astra.test.Basic","robot")).setBehaviour(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mazebot.astra.test.Basic", new int[] {22,9,22,49},
			new ModuleEvent("robot",
				"$re",
				new Predicate("event", new Term[] {
					Primitive.newPrimitive("Collision"),
					new Variable(Type.LIST, "params",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((mazebot.astra.direct.Robot) agent.getModule("mazebot.astra.test.Basic","robot")).event(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"mazebot.astra.test.Basic", new int[] {22,48,25,5},
				new Statement[] {
					new ModuleCall("console",
						"mazebot.astra.test.Basic", new int[] {23,8,23,36},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("collision")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("mazebot.astra.test.Basic","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("robot",
						"mazebot.astra.test.Basic", new int[] {24,8,24,34},
						new Predicate("setVelocity", new Term[] {
							Primitive.newPrimitive(-6.0),
							Primitive.newPrimitive(0.0)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.Robot) intention.getModule("mazebot.astra.test.Basic","robot")).setVelocity(
									(java.lang.Double) intention.evaluate(predicate.getTerm(0)),
									(java.lang.Double) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("robot",mazebot.astra.direct.Robot.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new AdaptiveSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new Basic().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
