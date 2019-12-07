package ctlogo.data.convert;

import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTUndefined;
import ctlogo.data.CTValueConverterManager;

public class ConvertInitilizer {
	private ConvertInitilizer() { } 

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
