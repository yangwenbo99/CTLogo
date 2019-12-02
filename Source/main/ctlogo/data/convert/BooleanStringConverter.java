package ctlogo.data.convert;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTString;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;

public class BooleanStringConverter extends CTValueConverter {
	private static final CTString TRUE_S = new CTString("true");
	private static final CTString FALSE_S = new CTString("false");
	
	BooleanStringConverter () {
		super(CTBoolean.getTypeMarkerStatic(), 
				CTString.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (from.equals((Object) CTBoolean.TRUE))
			return TRUE_S;
		else
			return FALSE_S;
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}