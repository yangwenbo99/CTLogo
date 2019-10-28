package ctlogo.execute;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.PrintStream;

import ctlogo.graphic.Screen;
import ctlogo.data.VariableManager;
import ctlogo.data.CTValue;

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
	 * @throws NoSuchElementException (optional) if such variable is not 
	 *         found in current context
	 */
	CTValue         getValueOf(String vname);
}
