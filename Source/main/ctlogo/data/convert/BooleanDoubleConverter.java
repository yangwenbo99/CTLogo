package ctlogo.data.convert;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.data.CTValueConverterManager;

public class BooleanDoubleConverter extends CTValueConverter {
	
	BooleanDoubleConverter () {
		super(CTBoolean.getTypeMarkerStatic(), CTDouble.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		return CTValueConverterManager.getInstance().
				convert(from, CTInteger.getTypeMarkerStatic()).
				convertTo(CTDouble.getTypeMarkerStatic());
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}