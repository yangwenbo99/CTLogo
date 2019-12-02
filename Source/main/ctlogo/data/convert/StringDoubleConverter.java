package ctlogo.data.convert;

import ctlogo.data.CTDouble;
import ctlogo.data.CTString;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.execute.util.DoubleParser;
import ctlogo.execute.util.LongParser;

public class StringDoubleConverter extends CTValueConverter {
	
	StringDoubleConverter () {
		super(CTString.getTypeMarkerStatic(), CTDouble.getTypeMarkerStatic());
	}

    @Override
    public CTValue convert(CTValue from) {
        String froms = from.toString();

        if (!isConvertible(from)) {
            throw new CTConversionNotSupportedException("Conversion not supported for this string");
        }
        
        return new CTDouble(DoubleParser.ParseDouble(froms));
    }

    @Override
    protected boolean isConvertible(CTValue from) {
        String froms = from.toString();
        return LongParser.isParseable(froms) || DoubleParser.isParseable(froms);
    }
}