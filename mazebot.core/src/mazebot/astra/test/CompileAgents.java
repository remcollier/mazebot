package mazebot.astra.test;


import astra.compiler.ASTRACompiler;

public class CompileAgents {

	public static void main(String[] args) {
		ASTRACompiler.compile("mazebot.astra.test.Main");
		ASTRACompiler.compile("mazebot.astra.test.Basic");
	}

}
