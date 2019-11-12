/**
 * 
 */
package ctlogo.function;

/**
 * @author Paul Yang
 *
 */
public class BuildInFunctionRegistrator {
	
	static void registerAll () {
		FunctionManager.getInstace().register("PR", PrintFunction.getInstance(), false);
		FunctionManager.getInstace().register("PRINT", PrintFunction.getInstance(), false);
	}

}
