/**
 * 
 */
package ctlogo.data;

import java.util.HashMap;
import java.util.Map;

import ctlogo.exception.CTVariableAlreadyDefinedException;
import ctlogo.exception.CTVariableNotDefinedException;

/**
 * @author Paul Yang
 *
 * This class is left package-visible intentionally. 
 *
 */
abstract class AbstractVariableManager implements VariableManager {
    
    private Map<String, CTVariable> variables;

    private static String processName(String name) {
        return VariableNameProcessor.process(name);
    }

    /**
     * Constructor. 
     *
     * This method is left package-visible intentionally. 
     */
    AbstractVariableManager() {
        variables = new HashMap<>();
    }

    private CTVariable tryGetVariable(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "Variable name cannot be null");
        }
        name = processName(name);
        CTVariable variable = variables.get(processName(name));
        return variable;
    }

    /**
     *
     * @throws IllegalArgumentException if name is null
     *
     * @return
     */
    protected CTValue tryGetLocalValue(String name) {
        CTVariable variable = tryGetVariable(name);
        if (variable == null)
            return null;
        else
            return variable.getValue();
    }

    /**
     * Set local value. 
     *
     * @return the original value (before change) 
     * @throws CTVariableNotDefinedException if the variable name is not defined.
     * @throws IllegalArgumentException if trying to set the variable to null (
     *                                  (in Java) or the name is null
     *
     * The difference behaviour between this method and {@code: setValue} is because
     * of the supposed behaviour of the two methods. To be short, {@code: setValue}
     * shall be like CTLogo language, which is permissive. On the other 
     * hand, this method is for internal usage, meaning that should be 
     * strict, and this is also benificial for further implementation.
     */
    protected CTValue setLocalValue(String name, CTValue value) {
            if (value == null) 
                throw new IllegalArgumentException(String.format(
                            "Trying to set variable %s to null", 
                            name));

            CTVariable variable = tryGetVariable(name);
            if (variable == null)
                throw new CTVariableNotDefinedException(String.format(
                            "%s is not defined", name));

            CTValue res = variable.getValue();
            variable.setValue(value);
            return res;
    }

    /**
     * @throws CTVariableAlreadyDefinedException if it is already defined.
     * @throws IllegalArgumentException if trying to set the variable to null (
     *                                  (in Java)
     */
    protected void createLocalVariable(String name, CTValue value) {
        try {
            name = processName(name);
            if (variables.containsKey(name)) 
                throw new CTVariableAlreadyDefinedException(String.format(
                            "%s is defined", name));
            if (value == null) 
                throw new IllegalArgumentException(String.format(
                            "Trying to set variable %s to null", 
                            name));
            variables.put(name, new CTVariable(value));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(
                    "Variable name cannot be null",
                    e);
        }
    }
    
    public CTValue setLocalVariable(String name, CTValue value) {
    	if (isDefinedLocally(name)) {
    		return setLocalValue(name, value);
    	} else {
    		createLocalVariable(name, value);
    		return null;
    	}
    }

    @Override
    public boolean isDefinedLocally(String name) {
        try {
            name = processName(name);
            return variables.containsKey(processName(name));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(
                    "Variable name cannot be null",
                    e);
        }
    }

}
