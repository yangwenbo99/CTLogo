package ctlogo.function;

import java.util.List;

import ctlogo.data.CTValue;
import ctlogo.execute.Context;

public interface Function {
	
	/**
	 * @param context
	 * @param cTValueList
	 * @return
	 */
	public CTValue execute(Context context, List<CTValue> cTValueList);
	
	/**
	 * @return
	 */
	public Integer getDefaultParameterNumber();
	
	/**
	 * @return
	 */
	public Integer getMinParameterNumber();

	/**
	 * @return
	 */
	public Integer getMaxParameterNumber();

}
