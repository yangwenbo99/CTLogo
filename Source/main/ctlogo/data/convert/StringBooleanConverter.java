package ctlogo.data.convert;

import ctlogo.data.CTBoolean;
import ctlogo.data.CTDouble;
import ctlogo.data.CTString;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;

public class StringBooleanConverter extends CTValueConverter {
	
	StringBooleanConverter () {
		super(CTString.getTypeMarkerStatic(), CTBoolean.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
        String froms = from.toString();

        if (froms.toUpperCase().equals("FALSE"))
            return CTBoolean.FALSE;

        if (from.isConvertibleTo(CTDouble.getTypeMarkerStatic()))
            return from.convertTo(CTDouble.getTypeMarkerStatic()).
                convertTo(CTBoolean.getTypeMarkerStatic());
        
        boolean resv = froms.length() > 0;
        
        return new CTBoolean(resv);
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
	
}