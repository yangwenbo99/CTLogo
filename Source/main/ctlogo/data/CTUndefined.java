package ctlogo.data;

import ctlogo.exception.CTDataUndefinedException;
import ctlogo.exception.CTOperationUndefinedException;

public class CTUndefined extends AbstractCTValue {
    private final static TypeMarker typeMarker = new TypeMarker("string");

    public static TypeMarker getTypeMarkerStatic() {
        return typeMarker;
    }

    public TypeMarker getTypeMarker() {
        return typeMarker;
    }

    public final static CTUndefined UNDEFINED = new CTUndefined();

    @Override
    public CTBoolean equals(CTValue another) {
        return CTBoolean.FALSE;
    }

    @Override
    public CTInteger compareTo(CTValue another) {
        throw new CTOperationUndefinedException("Do not try to compare undeined in Java");
    }

    @Override
    public boolean isCompareableTo(CTValue another) {
       return false;
    }

    @Override
    public CTValue and(CTValue another) {
        if (another.equals((Object) CTBoolean.FALSE))
            return CTBoolean.FALSE;
        return UNDEFINED;
    }

    @Override
    public CTValue or(CTValue another) {
        if (another.equals((Object) CTBoolean.TRUE))
            return CTBoolean.TRUE;
        return UNDEFINED;
    }

    @Override
    public CTValue not() {
        return UNDEFINED;
    }

}
