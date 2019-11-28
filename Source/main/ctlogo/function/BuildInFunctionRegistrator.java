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
		
		// Drawing Functions
		FunctionManager.getInstace().register("FORWARD", ForwardFunction.getInstance(), false);
		FunctionManager.getInstace().register("FD", ForwardFunction.getInstance(), false);
		FunctionManager.getInstace().register("BACKWARD", BackwardFunction.getInstance(), false);
		FunctionManager.getInstace().register("BACK", BackwardFunction.getInstance(), false);
		FunctionManager.getInstace().register("BK", BackwardFunction.getInstance(), false);
		FunctionManager.getInstace().register("LEFTTERN", LeftFunction.getInstance(), false);
		FunctionManager.getInstace().register("LEFT", LeftFunction.getInstance(), false);
		FunctionManager.getInstace().register("LT", LeftFunction.getInstance(), false);
		FunctionManager.getInstace().register("RIGHTTERN", RightFunction.getInstance(), false);
		FunctionManager.getInstace().register("RIGHT", RightFunction.getInstance(), false);
		FunctionManager.getInstace().register("RT", RightFunction.getInstance(), false);
		
	}

}
