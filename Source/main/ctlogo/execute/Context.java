package ctlogo.execute;

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

}
