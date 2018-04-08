package mazebot.cartago.test;


import astra.compiler.ASTRACompiler;

public class MBCartagoCompile {

	public static void main(String[] args) {
		ASTRACompiler.compile("mazebot.cartago.test.Main");
		ASTRACompiler.compile("mazebot.cartago.test.Basic");
	}

}
