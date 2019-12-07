package ctlogo.data.convert;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTDouble;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.exception.CTConversionNotSupportedException;

public class DoubleBooleanConverter extends CTValueConverter {
	
	DoubleBooleanConverter() {
		super(CTDouble.getTypeMarkerStatic(), CTBoolean.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {

		CTDouble dblFrom = (CTDouble) from;
		double dbVaue = dblFrom.getNumericalValue().doubleValue();
		
		return dbVaue == 0 || Double.isNaN(dbVaue) ? 
				CTBoolean.FALSE : CTBoolean.TRUE;
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}