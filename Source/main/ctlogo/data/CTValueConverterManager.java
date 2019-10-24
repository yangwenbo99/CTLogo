package ctlogo.data;

import java.util.Map;

import ctlogo.exception.CTOperationUndefinedException;

import java.util.HashMap;

class CTValueConverterManager {
	private static final CTValueConverterManager theInstance = 
			new CTValueConverterManager();
	public static CTValueConverterManager getInstance() {
		return theInstance;
	}

	private Map<TypeConversionDirection, CTValueConverter> map;
	
	private CTValueConverterManager() {
		map = new HashMap<TypeConversionDirection, CTValueConverter>();
	}
	
	public boolean isConvertible(CTValue fromValue, TypeMarker toType) {
		return map.containsKey(
				new TypeConversionDirection(fromValue.getTypeMarker(), toType));
	}

	public CTValue convert(CTValue fromValue, TypeMarker toType) {
		CTValueConverter converter = 
				map.get(new TypeConversionDirection(fromValue.getTypeMarker(), toType));
		if (converter == null)
			throw new CTOperationUndefinedException(
					String.format(
							"Cannot convert from %s to %s", 
							fromValue.getTypeMarker().toString(),
							toType.toString())
					);
		return converter.convert(fromValue);
	}
	
	public void register(CTValueConverter converter) {
		if (this.map.containsKey(converter.getTcd()))
			throw new IllegalArgumentException(
					"Registerring an converter twice not allowed.");
		this.map.put(converter.getTcd(), converter);
	}
}
