/**
 * 
 */
package ctlogo.function;

import ctlogo.function.drawing.BackwardFunction;
import ctlogo.function.drawing.CleanFunction;
import ctlogo.function.drawing.ClearScreenFunction;
import ctlogo.function.drawing.ForwardFunction;
import ctlogo.function.drawing.LeftFunction;
import ctlogo.function.drawing.PendownFunction;
import ctlogo.function.drawing.PenupFunction;
import ctlogo.function.drawing.RightFunction;
import ctlogo.function.drawing.SetxFunction;
import ctlogo.function.drawing.SetxyFunction;
import ctlogo.function.drawing.SetyFunction;
import ctlogo.function.drawing.XcorFunction;
import ctlogo.function.drawing.YcorFunction;
import ctlogo.function.math.AcosFunction;
import ctlogo.function.math.AsinFunction;
import ctlogo.function.math.Atan2Function;
import ctlogo.function.math.AtanFunction;
import ctlogo.function.math.CosFunction;
import ctlogo.function.math.SinFunction;
import ctlogo.function.math.TanFunction;

/**
 * @author Paul Yang
 *
 */
public class BuildInFunctionRegistrator {
	
	private BuildInFunctionRegistrator() { }
	
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
		
		// Drawing Functions - Relative
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
		
		// Drawing Functions - Absolute
		FunctionManager.getInstace().register("SETX", SetxFunction.getInstance(), false);
		FunctionManager.getInstace().register("SETXY", SetxyFunction.getInstance(), false);
		FunctionManager.getInstace().register("SETY", SetyFunction.getInstance(), false);
		
		// Drawing Functions - query
		FunctionManager.getInstace().register("XCOR", XcorFunction.getInstance(), false);
		FunctionManager.getInstace().register("YCOR", YcorFunction.getInstance(), false);
		
		
		// Drawing - Misc functions
		FunctionManager.getInstace().register("Penup", PenupFunction.getInstance(), false);
		FunctionManager.getInstace().register("PU", PenupFunction.getInstance(), false);
		FunctionManager.getInstace().register("Pendown", PendownFunction.getInstance(), false);
		FunctionManager.getInstace().register("PD", PendownFunction.getInstance(), false);
		
		// Drawing - clean
		FunctionManager.getInstace().register("CleanScreen", ClearScreenFunction.getInstance(), false);
		FunctionManager.getInstace().register("CS", ClearScreenFunction.getInstance(), false);
		FunctionManager.getInstace().register("Clean", CleanFunction.getInstance(), false);
	}

}
