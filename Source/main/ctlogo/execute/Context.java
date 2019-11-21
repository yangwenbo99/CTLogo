package ctlogo.execute;

import java.io.PrintStream;
import java.util.Scanner;

import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTVariableNotDefinedException;
import ctlogo.graphic.Screen;

/**
 * @author Paul Yang
 *
 */
public interface Context {
	
	/**
	 * @return the input stream of the context
	 */
	Scanner         getInputScanner();
	/**
	 * @return the output stream of the context
	 */
	PrintStream     getOutputStream();
	/**
	 * @return the screen of the context
	 */
	Screen          getScreen();
	/**
	 * @return the variable manager of the context
	 */
	VariableManager getVariableManager();
	/**
	 * @param vname name of variable
	 * @return the value of the variable in the context
	 * 
	 * @throws CTVariableNotDefinedException if the variable name is not defined.
	 */
	CTValue         getValueOf(String vname);
}
