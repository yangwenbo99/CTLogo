/**
 * 
 */
package ctlogo.execute.expression.instruction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.ExpressionStream;
import ctlogo.execute.expression.Expression;
import ctlogo.processing.TokenStream;

/**
 * @author yang
 *
 */
public class InstructionManager {
	private Map<String, Instruction> instrucions;
	
	private InstructionManager() { 
		instrucions = new HashMap<>();
	}

	private static InstructionManager instance = new InstructionManager();
	public static InstructionManager getInstance() {
		return instance;
	}

	/**
	 * Register an instruction object. 
	 * 
	 * @param name instruction name
	 * @param inst the instruction object to register. 
	 */
	public void register(String name, Instruction inst) {
		if (instrucions.containsKey(name.toUpperCase()))
            throw new IllegalArgumentException(
                    "Registerring an instrucition twice not allowed.");
		instrucions.put(name.toUpperCase(), inst);
	}
	
	public boolean hasInstruction(String name) {
		return instrucions.containsKey(name);
	}
	
	/**
	 * @param name name of instruction
	 * @param ts   the TokenStream
	 * @param es   the ExpressionStream
	 * @param isFirst if this the first expression after a parenthesis. 
	 * @throws CTSyntaxException if incorrect number of parameter given
     * @throws NoSuchElementException if token not registered
	 * @return the Expression object representing the instruction.
	 */
	public Expression getExpression (
			String name, 
			TokenStream ts, 
			ExpressionStream es, 
			boolean isFirst
			) throws CTSyntaxException {
		if (hasInstruction(name.toUpperCase()))
			return instrucions.get(name.toUpperCase()).getExpression(
					ts, es, isFirst);
		else
			throw new NoSuchElementException(String.format(
					"Instruction %s not registered", name.toUpperCase()));
	}

	/**
	 * @param name name of instruction
	 * @param ts   the TokenStream
	 * @param es   the ExpressionStream
	 * @throws CTSyntaxException if incorrect number of parameter given
     * @throws NoSuchElementException if token not registered
	 * @return the Expression object representing the instruction.
	 * 
	 * This should be equivalent to 
	 * <code>{@code getExpression(name, ts, es, false)}</code>
	 */
	public Expression getExpression (
			String name, 
			TokenStream ts, 
			ExpressionStream es) throws CTSyntaxException {
		return getExpression(name, ts, es, false);
	}

	static {
		InstructionManager.getInstance().register("REPEAT", RepeatInstruction.getInstance());
	}
}
