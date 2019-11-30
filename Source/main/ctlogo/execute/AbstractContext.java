package ctlogo.execute;

import java.io.PrintStream;
import java.util.Scanner;

import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.exception.CTVariableNotDefinedException;
import ctlogo.graphic.Screen;

public abstract class AbstractContext implements Context {
	
	private Scanner scanner;
	private PrintStream outputStream;
	private Screen screen;
	private VariableManager variableManager;
	private Context enclosingContext;

	/**
	 * @param scanner
	 * @param outputStream
	 * @param screen
	 * @param variableManager
	 * @param enclContext
	 * 
	 * If {@code: enclosingContext} is not given, then all other parameters
	 * cannot be null.
	 */
	public AbstractContext(
			Scanner scanner,
			PrintStream outputStream,
			Screen screen,
			VariableManager variableManager, 
			Context enclContext) {
		super();
		this.scanner = scanner;
		this.outputStream = outputStream;
		this.screen = screen;
		this.variableManager = variableManager;
		this.enclosingContext = enclContext;
		if (enclContext == null) {
			if (
					scanner == null || outputStream == null || 
					screen == null || variableManager == null) {
				throw new IllegalArgumentException(
						"No context information can be null, unless it has an encloding context");
			}
		}
	}

	public AbstractContext(
			Scanner scanner,
			PrintStream outputStream,
			Screen screen,
			VariableManager variableManager) {
		this(scanner, outputStream, screen, variableManager, null);
	}

	@Override
	public Scanner getInputScanner() {
		if (scanner != null)
			return scanner;
		else 
			return enclosingContext.getInputScanner();
	}

	@Override
	public PrintStream getOutputStream() {
		if (outputStream != null)
			return outputStream;
		else
			return enclosingContext.getOutputStream();
	}

	@Override
	public Screen getScreen() {
		if (screen != null) 
			return screen;
		else
			return enclosingContext.getScreen();
	}

	@Override
	public VariableManager getVariableManager() {
		if (variableManager != null)
			return variableManager;
		else
			return enclosingContext.getVariableManager();
	}

	/**
	 * 
	 * @throws CTVariableNotDefinedException if the variable name is not defined.
	 *
	 */
	@Override
	public CTValue getValueOf(String vname) {
		return getVariableManager().getValue(vname);
	}

}
