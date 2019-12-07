package ctlogo.data.convert;

import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;

public class DoubleIntegerConverter extends CTValueConverter {
	
	DoubleIntegerConverter () {
		super(CTDouble.getTypeMarkerStatic(), CTInteger.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		
		CTDouble intFrom = (CTDouble) from;
		
		return new CTInteger(intFrom.getNumericalValue().longValue());
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}
