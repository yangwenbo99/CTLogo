package ctlogo.data;

import ctlogo.exception.CTConversionNotSupportedException;
import ctlogo.execute.util.DoubleParser;
import ctlogo.execute.util.LongParser;

class BooleanIntegerConverter extends CTValueConverter {
	
	BooleanIntegerConverter () {
		super(CTBoolean.getTypeMarkerStatic(), 
				CTInteger.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (from.equals((Object) CTBoolean.TRUE))
			return CTInteger.ONE;
		else
			return CTInteger.ZERO;
	}

	@Override
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class BooleanStringConverter extends CTValueConverter {
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
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class IntegerBooleanConverter extends CTValueConverter {
	
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
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class IntegerDoubleConverter extends CTValueConverter {
	
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
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class BooleanDoubleConverter extends CTValueConverter {
	
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
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class DoubleBooleanConverter extends CTValueConverter {
	
	DoubleBooleanConverter() {
		super(CTDouble.getTypeMarkerStatic(), CTBoolean.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (!(from instanceof CTDouble)) {
			throw new CTConversionNotSupportedException("Wrong converter used.");
		}
		
		CTDouble dblFrom = (CTDouble) from;
		double dbVaue = dblFrom.getNumericalValue().doubleValue();
		
		return dbVaue == 0 || Double.isNaN(dbVaue) ? 
				CTBoolean.FALSE : CTBoolean.TRUE;
	}

	@Override
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class DoubleIntegerConverter extends CTValueConverter {
	
	DoubleIntegerConverter () {
		super(CTDouble.getTypeMarkerStatic(), CTInteger.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
		if (!(from instanceof CTDouble)) {
			throw new CTConversionNotSupportedException("Wrong converter used.");
		}
		
		CTDouble intFrom = (CTDouble) from;
		
		return new CTInteger(intFrom.getNumericalValue().longValue());
	}

	@Override
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class ToStringConverter extends CTValueConverter {

	ToStringConverter(TypeMarker from) {
		super(from, CTString.getTypeMarkerStatic());
	}


	@Override
	public CTValue convert(CTValue from) {
		return new CTString(from.toString());
	}

	@Override
	boolean isConvertible(CTValue from) {
		return true;
	}
}	

class StringBooleanConverter extends CTValueConverter {
	
	StringBooleanConverter () {
		super(CTString.getTypeMarkerStatic(), CTBoolean.getTypeMarkerStatic());
	}

	@Override
	public CTValue convert(CTValue from) {
        String froms = from.toString();
        if (froms.length() == 0)
            return CTBoolean.FALSE;
        if (froms.toUpperCase().equals("FALSE"))
            return CTBoolean.FALSE;

        if (from.isConvertibleTo(CTDouble.getTypeMarkerStatic()))
            return from.convertTo(CTDouble.getTypeMarkerStatic()).
                convertTo(CTBoolean.getTypeMarkerStatic());
        
        boolean resv = froms.length() > 0;
        
        return new CTBoolean(resv);
	}

	@Override
	boolean isConvertible(CTValue from) {
		return true;
	}
	
}

class StringIntegerConverter extends CTValueConverter {
	
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
    boolean isConvertible(CTValue from) {
        String froms = from.toString();
        return LongParser.isParseable(froms) || DoubleParser.isParseable(froms);
    }
}

class StringDoubleConverter extends CTValueConverter {
	
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
    boolean isConvertible(CTValue from) {
        String froms = from.toString();
        return LongParser.isParseable(froms) || DoubleParser.isParseable(froms);
    }
}

class ConvertInitilizer {
	public static void registerAll() {

        CTValueConverterManager.getInstance().register(new BooleanIntegerConverter());
        CTValueConverterManager.getInstance().register(new BooleanStringConverter());
        CTValueConverterManager.getInstance().register(new BooleanDoubleConverter());
        CTValueConverterManager.getInstance().register(new DoubleBooleanConverter());
        CTValueConverterManager.getInstance().register(new DoubleIntegerConverter());
        CTValueConverterManager.getInstance().register(new IntegerBooleanConverter());
        CTValueConverterManager.getInstance().register(new IntegerDoubleConverter());
        CTValueConverterManager.getInstance().register(new StringIntegerConverter());
        CTValueConverterManager.getInstance().register(new StringDoubleConverter());
        CTValueConverterManager.getInstance().register(new StringBooleanConverter());

        CTValueConverterManager.getInstance().register(
                new ToStringConverter(CTInteger.getTypeMarkerStatic()));
        CTValueConverterManager.getInstance().register(
                new ToStringConverter(CTDouble.getTypeMarkerStatic()));
        CTValueConverterManager.getInstance().register(
                new ToStringConverter(CTUndefined.getTypeMarkerStatic()));
	}
}
