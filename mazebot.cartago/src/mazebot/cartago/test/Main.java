package mazebot.cartago.test;
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
			"mazebot.cartago.test.Main", new int[] {10,9,10,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "args",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"mazebot.cartago.test.Main", new int[] {10,27,31,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {11,8,11,30},
						new Predicate("startService", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).startService(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {12,8,12,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).link(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {14,8,14,117},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("mazebot"),
							Primitive.newPrimitive("mazebot.cartago.MazeBotArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {

									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mazebot.cartago.test.Main","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {15,8,15,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {16,8,16,44},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("createWorld", new Term[] {})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {18,8,18,68},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("generateMaze", new Term[] {
								Primitive.newPrimitive("mazebot.maze.DemoMaze")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {20,8,20,82},
						new Predicate("installBehaviour", new Term[] {
							Primitive.newPrimitive("FollowWall"),
							Primitive.newPrimitive("mazebot.behaviour.old.FollowWall")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {21,8,21,78},
						new Predicate("installBehaviour", new Term[] {
							Primitive.newPrimitive("FindWall"),
							Primitive.newPrimitive("mazebot.behaviour.old.FindWall")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new Subgoal(
						"mazebot.cartago.test.Main", new int[] {23,8,31,5},
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
								Primitive.newPrimitive("mazebot.cartago.test.Basic"),
								new Variable(new ObjectType(cartago.ArtifactId.class), "id")
							})
						)
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {30,8,30,27},
						new Predicate("launchGUI", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mazebot.cartago.test.Main", new int[] {34,9,34,124},
			new GoalEvent('+',
				new Goal(
					new Predicate("createRobot", new Term[] {
						new Variable(Type.STRING, "name",false),
						new Variable(Type.DOUBLE, "x",false),
						new Variable(Type.DOUBLE, "y",false),
						new Variable(Type.LIST, "sensors",false),
						new Variable(Type.LIST, "behaviours",false),
						new Variable(Type.STRING, "clz",false),
						new Variable(new ObjectType(cartago.ArtifactId.class), "mId",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"mazebot.cartago.test.Main", new int[] {34,123,45,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {35,8,35,110},
						new Predicate("makeArtifact", new Term[] {
							new Variable(Type.STRING, "name"),
							Primitive.newPrimitive("mazebot.cartago.RobotArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {

									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mazebot.cartago.test.Main","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {36,8,36,47},
						new Predicate("linkArtifacts", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							Primitive.newPrimitive("out-1"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "mId")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Main", new int[] {37,8,37,46},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("initRobot", new Term[] {
								new Variable(Type.DOUBLE, "x"),
								new Variable(Type.DOUBLE, "y")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ForAll(
						"mazebot.cartago.test.Main", new int[] {38,8,38,39},
						new Variable(Type.STRING, "sensor",false),
						new Variable(Type.LIST, "sensors"),
						new Block(
							"mazebot.cartago.test.Main", new int[] {38,40,45,5},
							new Statement[] {
								new ModuleCall("cartago",
									"mazebot.cartago.test.Main", new int[] {39,12,39,52},
									new Predicate("operation", new Term[] {
										new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
										new Funct("addSensor", new Term[] {
											new Variable(Type.STRING, "sensor")
										})
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
										}
										public boolean suppressNotification() {
											return true;
										}
									}
								)
							}
						)
					),
					new ForAll(
						"mazebot.cartago.test.Main", new int[] {41,8,41,45},
						new Variable(Type.STRING, "behaviour",false),
						new Variable(Type.LIST, "behaviours"),
						new Block(
							"mazebot.cartago.test.Main", new int[] {41,46,45,5},
							new Statement[] {
								new ModuleCall("cartago",
									"mazebot.cartago.test.Main", new int[] {42,12,42,58},
									new Predicate("operation", new Term[] {
										new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
										new Funct("addBehaviour", new Term[] {
											new Variable(Type.STRING, "behaviour")
										})
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Main","cartago")).auto_action(intention,evaluate(intention,predicate));
										}
										public boolean suppressNotification() {
											return true;
										}
									}
								)
							}
						)
					),
					new ModuleCall("system",
						"mazebot.cartago.test.Main", new int[] {44,8,44,37},
						new Predicate("createAgent", new Term[] {
							new Variable(Type.STRING, "name"),
							new Variable(Type.STRING, "clz")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("mazebot.cartago.test.Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
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
		fragment.addModule("cartago",astra.lang.Cartago.class,agent);
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
