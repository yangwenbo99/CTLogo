package ctlogo.execute;

import java.io.PrintStream;
import java.util.Scanner;

import ctlogo.data.CTValue;
import ctlogo.data.VariableManager;
import ctlogo.graphic.Screen;

public abstract class AbstractContext implements Context {
	
	private Scanner scanner;
	private PrintStream outputStream;
	private Screen screen;
	private VariableManager variableManager;

	public AbstractContext(Scanner scanner, PrintStream outputStream, Screen screen, VariableManager variableManager) {
		super();
		this.scanner = scanner;
		this.outputStream = outputStream;
		this.screen = screen;
		this.variableManager = variableManager;
	}

	@Override
	public Scanner getInputScanner() {
		return scanner;
	}

	@Override
	public PrintStream getOutputStream() {
		return outputStream;
	}

	@Override
	public Screen getScreen() {
		return screen;
	}

	@Override
	public VariableManager getVariableManager() {
		return variableManager;
	}

	/**
	 * 
	 * @throws CTVariableNotDefinedException if the variable name is not defined.
	 *
	 */
	@Override
	public CTValue getValueOf(String vname) {
		return variableManager.getVariable(vname).getValue();
	}

}
