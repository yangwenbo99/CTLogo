package ctlogo.execute;

<<<<<<< HEAD
import java.io.InputStream;
import java.io.OutputStream;

import ctlogo.data.CTValue;
import ctlogo.graphic.Screen;

/**
 * @author Dennis Wang
 *
 */
public interface Context {
	
	/**
	 * @return
	 */
	public InputStream getInputStream();
	
	/**
	 * @return
	 */
	public OutputStream getOutstream();

	/**
	 * @return
	 */
	public Screen getScreen();
	
	/**
	 * @param name
	 * @return
	 */
	public Boolean hasVariable(String name);

	/**
	 * @param name
	 * @return
	 */
	public CTValue getVariableValue(String name);

	/**
	 * @param name
	 * @return
	 */
	public CTValue setVariableValue(String name);

	/**
	 * @param name
	 * @return
	 */
	public Boolean hasOuterVariable(String name);
	
	/**
	 * @param name
	 * @return
	 */
	public CTValue getOuterVariableName(String name);
	
	/**
	 * @param name
	 * @return
	 */
	public CTValue setOuterVariableName(String name);
=======
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.PrintStream;

import ctlogo.graphic.Screen;
import ctlogo.data.VariableManager;
import ctlogo.data.CTValue;
>>>>>>> dev_general

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
