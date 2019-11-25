/**
 * 
 */
package ctlogo.execute;

import java.io.PrintStream;
import java.util.Scanner;

import ctlogo.data.VariableManager;
import ctlogo.graphic.Screen;

/**
 * @author Paul Yang
 *
 */
public class GlobalContext extends AbstractContext implements Context {

	/**
	 * @param scanner
	 * @param outputStream
	 * @param screen
	 * @param variableManager
	 */
	public GlobalContext(Scanner scanner, PrintStream outputStream, Screen screen, VariableManager variableManager) {
		super(scanner, outputStream, screen, variableManager);
	}

}
