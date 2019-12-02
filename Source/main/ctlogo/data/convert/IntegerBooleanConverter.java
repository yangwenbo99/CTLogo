package ctlogo.data.convert;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTInteger;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;

public class IntegerBooleanConverter extends CTValueConverter {
	
	IntegerBooleanConverter () {
		super(CTInteger.getTypeMarkerStatic(), CTBoolean.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (from.equals((Object) CTInteger.ZERO))
			return CTBoolean.FALSE;
		else
			return CTBoolean.TRUE;
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}