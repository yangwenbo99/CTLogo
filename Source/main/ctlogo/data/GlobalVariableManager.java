/**
 * 
 */
package ctlogo.data;

import ctlogo.exception.CTVariableNotDefinedException;

/**
 * @author Paul
 *
 */
public class GlobalVariableManager extends AbstractVariableManager implements VariableManager {

    @Override
    public boolean isDefined(String name) {
        return isDefinedLocally(name);
    }

    @Override
    public CTValue tryGetValue(String name) {
        return tryGetLocalValue(name);
    }

    @Override
    public CTValue getValue(String name) {
        CTValue res = tryGetValue(name);
        if (res == null) 
            throw new CTVariableNotDefinedException(String.format(
                        "%s not defined", name));

        return res;
    }

    @Override
    public CTValue setVariable(String name, CTValue value) {
        if (isDefinedLocally(name)) {
            return setLocalValue(name, value);
        } else {
            createLocalVariable(name, value);
            return null;
        }
    }

}
