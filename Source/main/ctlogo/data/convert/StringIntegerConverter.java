package ctlogo.data.convert;

import ctlogo.data.CTInteger;
import ctlogo.data.CTString;
import ctlogo.data.CTValue;
import ctlogo.data.CTValueConverter;
import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.execute.util.DoubleParser;
import ctlogo.execute.util.LongParser;

public class StringIntegerConverter extends CTValueConverter {
	
	StringIntegerConverter () {
		super(CTString.getTypeMarkerStatic(), CTInteger.getTypeMarkerStatic());
	}

    @Override
    public CTValue convert(CTValue from) {
        String froms = from.toString();
        if (!isConvertible(from)) {
            throw new CTConversionNotSupportedException("Conversion not supported for this string");
        }
        if (LongParser.isParseable(froms))
            return new CTInteger(LongParser.parseLong(froms));
        else 
            return new CTInteger((long) DoubleParser.ParseDouble(froms));
    }

    @Override
    protected boolean isConvertible(CTValue from) {
        String froms = from.toString();
        return LongParser.isParseable(froms) || DoubleParser.isParseable(froms);
    }
}