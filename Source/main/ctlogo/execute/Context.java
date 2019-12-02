package ctlogo.execute;

import java.io.PrintStream;
import java.util.Scanner;

import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTVariableNotDefinedException;
import ctlogo.graphic.Screen;

/**
 * The context where one {@code Expression} should run.
 *
 * @author Paul Yang
 *
 */
public interface Context {
	
	/**
	 * Return the input stream of the context.
	 * @return the input stream of the context
	 */
	Scanner         getInputScanner();
	/**
	 * Return the output stream of the context
	 * @return the output stream of the context
	 */
	PrintStream     getOutputStream();
	/**
	 * Return the screen of the context
	 * @return the screen of the context
	 */
	Screen          getScreen();
	/**
	 * Return the variable manager of the context
	 * @return the variable manager of the context
	 */
	VariableManager getVariableManager();
	/**
	 * Return the value of the variable in the context
	 * @param vname name of variable
	 * @return the value of the variable in the context
	 * 
	 * @throws CTVariableNotDefinedException if the variable name is not defined.
	 */
	CTValue         getValueOf(String vname);
}
