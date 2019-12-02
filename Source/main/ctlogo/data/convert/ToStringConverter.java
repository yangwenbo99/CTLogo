package ctlogo.data.convert;

import ctlogo.data.CTString;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.data.TypeMarker;

public class ToStringConverter extends CTValueConverter {

	ToStringConverter(TypeMarker from) {
		super(from, CTString.getTypeMarkerStatic());
	}


	@Override
	public CTValue convert(CTValue from) {
		return new CTString(from.toString());
	}

	@Override
	protected boolean isConvertible(CTValue from) {
		return true;
	}
}