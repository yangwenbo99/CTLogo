/**
 * 
 */
package ctlogo.data;

/**
 * Utilities used for testing ctlogo.data. 
 * @author Paul Yang
 *
 */
public class TestDataUtility {
	public static CTInteger cint(long i) {
		return new CTInteger(i);
	}

	public static CTDouble cdbl(double v) {
		return new CTDouble(v);
	}

	public static CTString cstr(String v) {
		return new CTString(v);
	}

	public static CTBoolean cbol(boolean v) {
		return new CTBoolean(v);
	}

}
