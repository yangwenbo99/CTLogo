/**
 * 
 */
package ctlogo.data;

import java.util.Objects;

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
		return String.format("<Type marker for %s at %x>", s, Objects.hashCode(this));
	}

}
