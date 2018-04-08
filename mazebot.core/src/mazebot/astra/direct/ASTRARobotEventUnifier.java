package mazebot.astra.direct;

import java.util.HashMap;
import java.util.Map;

import astra.core.Agent;
import astra.reasoner.EventUnifier;
import astra.reasoner.Unifier;
import astra.term.Term;

public class ASTRARobotEventUnifier implements EventUnifier<ASTRARobotEvent> {
    @Override
    public Map<Integer,Term> unify(ASTRARobotEvent source, ASTRARobotEvent target, Agent agent) {
       return Unifier.unify(
          new Term[] {source.type, source.params}, 
          new Term[] {target.type, target.params}, 
          new HashMap<Integer,Term>(),
          agent);
    }
 }