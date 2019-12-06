package ctlogo.execute.util;

import java.util.regex.Pattern;

public class DoubleParser {
	
	private DoubleParser() { } 

    private static Pattern checkPattern;

    /**
     * Intialise the {@code: checkPattern}.
     *
     * These code are from 
     * <a hrel='https://docs.oracle.com/javase/10/docs/api/java/lang/Double.html#valueOf(java.lang.String)'>Java API's document</a>. 
     */
    static {
        final String Digits     = "(\\p{Digit}+)";
        final String HexDigits  = "(\\p{XDigit}+)";
        final String Exp        = "[eE][+-]?"+Digits;
        final String fpRegex    =
            ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
             "[+-]?(" + // Optional sign character
             "NaN|" +           // "NaN" string
             "Infinity|" +      // "Infinity" string
             "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+
             "(\\.("+Digits+")("+Exp+")?)|"+
             "((" +
              "(0[xX]" + HexDigits + "(\\.)?)|" +
              "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +
              ")[pP][+-]?" + Digits + "))" +
             "[fFdD]?))" +
             "[\\x00-\\x20]*");// Optional trailing "whitespace"
        checkPattern = Pattern.compile(fpRegex);
    }

    public static boolean isParseable(String s) {
        return checkPattern.matcher(s).matches();
    }

    public static double ParseDouble(String s) {
        return Double.parseDouble(s);
    }

}
