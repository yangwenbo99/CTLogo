package ctlogo.config;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ctlogo.config.ConfigReader;

public class TestConfigReader {

	@Test
	public void testIsConfigSetable() {
		Assertions.assertEquals(true,ConfigReader.isConfigSetable("setting1"));
		Assertions.assertEquals(true,ConfigReader.isConfigSetable("setting2"));
		Assertions.assertEquals(true,ConfigReader.isConfigSetable("setting3"));
		Assertions.assertEquals(false,ConfigReader.isConfigSetable("setting4"));
	}

	@Test
	public void testGetSetConfig() {
		Assertions.assertEquals(null,ConfigReader.getStringConfig("setting1"));
		ConfigReader.setStringConfig("setting1","s1value");
		Assertions.assertEquals("s1value",ConfigReader.getStringConfig("setting1"));

		Assertions.assertEquals(null,ConfigReader.getBooleanConfig("setting2"));
		ConfigReader.setBooleanConfig("setting2",true);
		Assertions.assertEquals(true,ConfigReader.getBooleanConfig("setting2"));

		Assertions.assertEquals(null,ConfigReader.getIntegerConfig("setting3"));
		ConfigReader.setIntegerConfig("setting3",4);
		Assertions.assertEquals(4,ConfigReader.getIntegerConfig("setting3"));
		ConfigReader.setIntegerConfig("setting3",30);
		Assertions.assertEquals(30,ConfigReader.getIntegerConfig("setting3"));

	}
	
}
