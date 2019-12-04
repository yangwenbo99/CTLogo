/**
 * 
 */
package ctlogo.data;

/**
 * @author yang
 *
 */
public class VariableNameProcessor {

	private VariableNameProcessor() { } 

    /**
     * Process the variable name 
     *
     * @param ins variable name 
     * @return the equivalent variable name 
     *
     * The return value of is function is guaranteed to have the 
     * following behaviour. 
     * <ul>
     *     <li>if <code>a</code> and <code>b</code> are equivalent 
     *     according to CTLogo's convention,
     *     <code>process(a).equals(process(b))</code> will be true.</li>
     *     <li>if <code>a</code> and <code>b</code> are not equivalent 
     *     according to CTLogo's convention,
     *     <code>process(a).equals(process(b))</code> will be false.</li>
     * </ul>
     * 
     */
    public static String process(String ins) {
        return ins.toUpperCase();
    }

}
