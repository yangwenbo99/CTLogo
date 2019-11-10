package ctlogo.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigReader {

	private Map<String, Object> instanceContent = new HashMap<String, Object>();
	private static ConfigReader instance;
	//TODO Specify the settings
	private List<String>setableConfigNames=new ArrayList<>( 
            List.of("setting1", 
                    "setting2", 
                    "setting3"));

	private ConfigReader() {
	}

	public static ConfigReader getInstance() {
		if (instance == null)
			instance = new ConfigReader();
		return instance;
	}

	public List<String> getSetableConfigNames() {
		return setableConfigNames;
	}
	
	private Object getInstanceContent(String name) {
		return this.instanceContent.get(name);
	}

	private void setInstanceContent(String name, Object value) {
		this.instanceContent.put(name, value);
	}

	public static String getStringConfig(String name) {
		ConfigReader ins = ConfigReader.getInstance();
		return (String) ins.getInstanceContent(name);
	}

	public static void setStringConfig(String name, String value) {
		ConfigReader ins = ConfigReader.getInstance();
		ins.setInstanceContent(name, value);
	}

	public static Boolean getBooleanConfig(String name) {
		ConfigReader ins = ConfigReader.getInstance();
		return (Boolean) ins.getInstanceContent(name);
	}

	public static void setBooleanConfig(String name, Boolean value) {
		ConfigReader ins = ConfigReader.getInstance();
		ins.setInstanceContent(name, value);
	}

	public static Integer getIntegerConfig(String name) {
		ConfigReader ins = ConfigReader.getInstance();
		return (Integer) ins.getInstanceContent(name);
	}

	public static void setIntegerConfig(String name, Integer value) {
		ConfigReader ins = ConfigReader.getInstance();
		ins.setInstanceContent(name, value);
	}
	
	public static Boolean isConfigSetable(String name) {
		ConfigReader ins = ConfigReader.getInstance();
		return ins.getSetableConfigNames().contains(name);
	}

}
