package ctlogo.execute;

import java.io.PrintStream;
import java.util.Scanner;

import ctlogo.data.LocalVariableManager;
import ctlogo.data.VariableManager;
import ctlogo.graphic.Screen;

public class LocalContext extends AbstractContext implements Context {

	/**
	 * Construct a local context.
	 * 
	 * @param enclContext the enclosing context
	 * 
	 * For this constructor, only a new LocalVariableManger will be constructed, 
	 * other properties are inherent from the enclosing context.
	 */
	public LocalContext(Context enclContext) {
		super(
				null, 
				null, 
				null, 
				new LocalVariableManager(enclContext.getVariableManager()),
				enclContext);
	}

	/**
	 * Construct a local context.
	 * 
	 * @param scanner
	 * @param outputStream
	 * @param screen
	 * @param variableManager
	 * @param enclContext
	 * 
	 * For this constructor, a new LocalVariableManger will be constructed, 
	 * other properties are inherent from the enclosing context if null is
	 * passed to the constructor.
	 */
	public LocalContext(
			Scanner scanner, 
			PrintStream outputStream, 
			Screen screen, 
			VariableManager variableManager,
			Context enclContext) {
		super(
				scanner, 
				outputStream, 
				screen, 
				new LocalVariableManager(enclContext.getVariableManager()),
				enclContext);
	}

}
