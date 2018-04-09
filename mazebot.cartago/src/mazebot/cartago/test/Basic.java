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


public class Basic extends ASTRAClass {
	public Basic() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			"mazebot.cartago.test.Basic", new int[] {14,9,14,19},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"mazebot.cartago.test.Basic", new int[] {14,18,23,5},
				new Statement[] {
					new ModuleCall("console",
						"mazebot.cartago.test.Basic", new int[] {15,8,15,73},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("++++++++++++++++++++ Started: "),
								new ModuleTerm("system", Type.STRING,
									new Predicate("name", new Term[] {}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("mazebot.cartago.test.Basic","system")).name(
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((astra.lang.System) visitor.agent().getModule("mazebot.cartago.test.Basic","system")).name(
											);
										}
									}
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("mazebot.cartago.test.Basic","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {16,8,16,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).link(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {17,8,17,68},
						new Predicate("lookupArtifact", new Term[] {
							new ModuleTerm("system", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("mazebot.cartago.test.Basic","system")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("mazebot.cartago.test.Basic","system")).name(
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
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {18,8,18,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mazebot.cartago.test.Basic", new int[] {19,8,23,5},
						new Predicate("robot", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						})
					),
					new ModuleCall("console",
						"mazebot.cartago.test.Basic", new int[] {21,8,21,83},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("++++++++++++++++++++ Setting Behaviour: "),
								new ModuleTerm("system", Type.STRING,
									new Predicate("name", new Term[] {}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("mazebot.cartago.test.Basic","system")).name(
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((astra.lang.System) visitor.agent().getModule("mazebot.cartago.test.Basic","system")).name(
											);
										}
									}
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("mazebot.cartago.test.Basic","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {22,8,22,55},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("setBehaviour", new Term[] {
								Primitive.newPrimitive("FindWall")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"mazebot.cartago.test.Basic", new int[] {25,9,25,80},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "X",false),
					new Funct("FoundWall", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("mazebot.cartago.test.Basic","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			new Predicate("robot", new Term[] {
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mazebot.cartago.test.Basic", new int[] {25,79,27,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {26,8,26,57},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("setBehaviour", new Term[] {
								Primitive.newPrimitive("FollowWall")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"mazebot.cartago.test.Basic", new int[] {29,9,29,79},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "X",false),
					new Funct("LostWall", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("mazebot.cartago.test.Basic","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			new Predicate("robot", new Term[] {
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mazebot.cartago.test.Basic", new int[] {29,78,31,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {30,8,30,55},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("setBehaviour", new Term[] {
								Primitive.newPrimitive("FindWall")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).auto_action(intention,evaluate(intention,predicate));
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
			"mazebot.cartago.test.Basic", new int[] {33,9,33,80},
			new ModuleEvent("cartago",
				"$cse",
				new Predicate("signal", new Term[] {
					new Variable(Type.STRING, "X",false),
					new Funct("Collision", new Term[] {})
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.lang.Cartago) agent.getModule("mazebot.cartago.test.Basic","cartago")).signal(
							predicate.getTerm(0),
							predicate.getTerm(1)
						);
					}
				}
			),
			new Predicate("robot", new Term[] {
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mazebot.cartago.test.Basic", new int[] {33,79,35,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mazebot.cartago.test.Basic", new int[] {34,8,34,51},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("setVelocity", new Term[] {
								Primitive.newPrimitive(-6.0),
								Primitive.newPrimitive(0.0)
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mazebot.cartago.test.Basic","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Goal(
				new Predicate("init", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("cartago",astra.lang.Cartago.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
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
