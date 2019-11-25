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
		// print
		FunctionManager.getInstace().register("PR", PrintFunction.getInstance(), false);
		FunctionManager.getInstace().register("PRINT", PrintFunction.getInstance(), false);

		// Variable 
		FunctionManager.getInstace().register("MAKE", MakeFunction.getInstance(), false);
		
		// Math functions 
		FunctionManager.getInstace().register("SIN", SinFunction.getInstance(), false);
		FunctionManager.getInstace().register("COS", CosFunction.getInstance(), false);
		FunctionManager.getInstace().register("TAN", TanFunction.getInstance(), false);
		FunctionManager.getInstace().register("ASIN", AsinFunction.getInstance(), false);
		FunctionManager.getInstace().register("ACOS", AcosFunction.getInstance(), false);
		FunctionManager.getInstace().register("ATAN", AtanFunction.getInstance(), false);
		FunctionManager.getInstace().register("ATAN2", Atan2Function.getInstance(), false);
	}

}
