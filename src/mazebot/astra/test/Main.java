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

import mazebot.astra.direct.ASTRARobot;
import mazebot.astra.direct.MazeBot;

public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"mazebot.astra.test.Main", new int[] {10,9,10,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"mazebot.astra.test.Main", new int[] {10,27,27,5},
				new Statement[] {
					new ModuleCall("mazebot",
						"mazebot.astra.test.Main", new int[] {11,8,11,29},
						new Predicate("createWorld", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).createWorld(
								);
							}
						}
					),
					new ModuleCall("mazebot",
						"mazebot.astra.test.Main", new int[] {13,8,13,53},
						new Predicate("generateMaze", new Term[] {
							Primitive.newPrimitive("mazebot.maze.DemoMaze")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).generateMaze(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("mazebot",
						"mazebot.astra.test.Main", new int[] {15,8,18,10},
						new Predicate("installBehaviours", new Term[] {
							new ListTerm(new Term[] {
								new Funct("behaviour", new Term[] {
									Primitive.newPrimitive("FollowWall"),
									Primitive.newPrimitive("mazebot.behaviour.old.FollowWall")
								}),
								new Funct("behaviour", new Term[] {
									Primitive.newPrimitive("FindWall"),
									Primitive.newPrimitive("mazebot.behaviour.old.FindWall")
								})
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).installBehaviours(
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"mazebot.astra.test.Main", new int[] {20,8,27,5},
						new Goal(
							new Predicate("createRobot", new Term[] {
								Primitive.newPrimitive("test"),
								Primitive.newPrimitive(0.0),
								Primitive.newPrimitive(0.0),
								new ListTerm(new Term[] {
									Primitive.newPrimitive("bumper"),
									Primitive.newPrimitive("sonar")
								}),
								new ListTerm(new Term[] {
									Primitive.newPrimitive("FindWall"),
									Primitive.newPrimitive("FollowWall")
								}),
								Primitive.newPrimitive("mazebot.astra.test.Basic")
							})
						)
					),
					new ModuleCall("mazebot",
						"mazebot.astra.test.Main", new int[] {26,8,26,27},
						new Predicate("launchGUI", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).launchGUI(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mazebot.astra.test.Main", new int[] {30,9,30,100},
			new GoalEvent('+',
				new Goal(
					new Predicate("createRobot", new Term[] {
						new Variable(Type.STRING, "name",false),
						new Variable(Type.DOUBLE, "x",false),
						new Variable(Type.DOUBLE, "y",false),
						new Variable(Type.LIST, "sensors",false),
						new Variable(Type.LIST, "behaviours",false),
						new Variable(Type.STRING, "clz",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"mazebot.astra.test.Main", new int[] {30,99,37,5},
				new Statement[] {
					new Declaration(
						new Variable(new ObjectType(mazebot.astra.direct.ASTRARobot.class), "robot"),
						"mazebot.astra.test.Main", new int[] {31,8,37,5},
						new ModuleTerm("mazebot", new ObjectType(mazebot.astra.direct.ASTRARobot.class),
							new Predicate("createRobot", new Term[] {
								new Variable(Type.STRING, "name"),
								new Variable(Type.DOUBLE, "x"),
								new Variable(Type.DOUBLE, "y")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).createRobot(
										(java.lang.String) intention.evaluate(predicate.getTerm(0)),
										(double) intention.evaluate(predicate.getTerm(1)),
										(double) intention.evaluate(predicate.getTerm(2))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((mazebot.astra.direct.MazeBot) visitor.agent().getModule("mazebot.astra.test.Main","mazebot")).createRobot(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
										(double) visitor.evaluate(predicate.getTerm(1)),
										(double) visitor.evaluate(predicate.getTerm(2))
									);
								}
							}
						)
					),
					new ModuleCall("mazebot",
						"mazebot.astra.test.Main", new int[] {32,8,32,42},
						new Predicate("addSensors", new Term[] {
							new Variable(new ObjectType(mazebot.astra.direct.ASTRARobot.class), "robot"),
							new Variable(Type.LIST, "sensors")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).addSensors(
									(mazebot.astra.direct.ASTRARobot) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("mazebot",
						"mazebot.astra.test.Main", new int[] {33,8,33,48},
						new Predicate("addBehaviours", new Term[] {
							new Variable(new ObjectType(mazebot.astra.direct.ASTRARobot.class), "robot"),
							new Variable(Type.LIST, "behaviours")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((mazebot.astra.direct.MazeBot) intention.getModule("mazebot.astra.test.Main","mazebot")).addBehaviours(
									(mazebot.astra.direct.ASTRARobot) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"mazebot.astra.test.Main", new int[] {35,8,35,37},
						new Predicate("createAgent", new Term[] {
							new Variable(Type.STRING, "name"),
							new Variable(Type.STRING, "clz")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("mazebot.astra.test.Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"mazebot.astra.test.Main", new int[] {36,8,36,41},
						new Predicate("setMainGoal", new Term[] {
							new Variable(Type.STRING, "name"),
							new ListTerm(new Term[] {
								new Variable(new ObjectType(mazebot.astra.direct.ASTRARobot.class), "robot")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("mazebot.astra.test.Main","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
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
		fragment.addModule("mazebot",mazebot.astra.direct.MazeBot.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
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
			astra.core.Agent agent = new Main().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
