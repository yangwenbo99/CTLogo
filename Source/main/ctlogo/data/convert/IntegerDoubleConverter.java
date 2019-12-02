package ctlogo.data.convert;

import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.exception.CTConversionNotSupportedException;

public class IntegerDoubleConverter extends CTValueConverter {
	
	IntegerDoubleConverter () {
		super(CTInteger.getTypeMarkerStatic(), CTDouble.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (!(from instanceof CTInteger)) {
			throw new CTConversionNotSupportedException("Wrong converter used.");
		}
		
		CTInteger intFrom = (CTInteger) from;
		
		return new CTDouble(intFrom.getNumericalValue().doubleValue());
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}