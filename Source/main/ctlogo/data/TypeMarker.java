/**
 * 
 */
package ctlogo.data;

/**
 * @author Paul Yang
 *
 */
class TypeMarker {
	
	private String s;

	public TypeMarker(String s) {
		this.s = s;
	}
	
	@Override
	public String toString() {
		return String.format("Type marker for %s", s);
	}

}
