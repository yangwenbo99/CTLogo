package ctlogo.execute;

import ctlogo.data.CTValue;

public interface Expression {
	public CTValue execute(Context context);
}
