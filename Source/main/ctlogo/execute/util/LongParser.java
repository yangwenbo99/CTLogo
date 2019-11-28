/**
 * 
 */
package ctlogo.execute.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Paul Yang
 *
 */
public class LongParser {

    private LongParser () {}

    private static final Map<Integer, Pattern> matchers = new HashMap<>();

    static {
        final String signPatternSymbol = "(?<sign>[+-]?)";

        final Pattern parsableDecimalPattern = 
            Pattern.compile(signPatternSymbol + "(?<body>[1-9]\\d*|0)");
        final Pattern parsableBinaryPattern = 
            Pattern.compile(
                    signPatternSymbol + 
                    "(?i:0b)" + 
                    "(?<body>[01]+)");
        final Pattern parsableOctalPattern = 
            Pattern.compile(
                    signPatternSymbol + 
                    "(?i:0)" + 
                    "(?<body>[0-7]+)");
        final Pattern parsableHexadecimalPattern = 
            Pattern.compile(
                    signPatternSymbol + 
                    "(?i:0x)" + 
                    "(?<body>[0-9A-Fa-f]+)");
        matchers.put(10, parsableDecimalPattern);
        matchers.put(2,  parsableBinaryPattern);
        matchers.put(8,  parsableOctalPattern);
        matchers.put(16, parsableHexadecimalPattern);
    }

    private static class LongMatch {
        private boolean isNegative;
        private String body;
        private int radix;

        /**
         * @param isNegative
         * @param body
         * @param radix
         */
        public LongMatch(boolean isNegative, String body, int radix) {
            this.isNegative = isNegative;
            this.body = body;
            this.radix = radix;
        }

        /**
         * @return should the number have negative sign
         */
        public boolean isNegative() {
            return isNegative;
        }

        /**
         * @return the body of the matched number 
         */
        public String getBody() {
            return body;
        }

        /**
         * @return the radix
         */
        public int getRadix() {
            return radix;
        }
    }

    public static boolean isParseable(String s) {
        for (Entry<Integer, Pattern> entry : matchers.entrySet()) {
            if (entry.getValue().matcher(s).matches())
                return true;
        }
        return false;
    }

    /**
     *
     *
     * @param s
     * @throws NumberFormatException is the string is not parsable as long
     * @return the matched LongMatch
     */
    private static LongMatch getMatch(String s) {
        int radix = -1;
        Matcher matcher = null;
        for (Entry<Integer, Pattern> entry : matchers.entrySet()) {
            Matcher tmpMatcher = entry.getValue().matcher(s);
            if (tmpMatcher.matches()) {
                radix = entry.getKey();
                matcher = tmpMatcher;
            }
        }

        if (radix <= 0)
            throw new NumberFormatException("The string is not parsable");

        return new LongMatch(
                matcher.group("sign").equals("-"),
                matcher.group("body"),
                radix);
    }

    /**
     * Long parser, which behaves like C++'s {@code: strtol} with base 0.  
     *
     * <p>
     * The behavior of this function is well documented in code... If you
     * do not want to see the code, then following is a brief introduction 
     * of this function, the function expects the String passed in to be 
     * consisted of the following part: 
     * </p>
     * <ol>
     *     <li>An optional sign character (+ or -)</li>
     *     <li>An optional prefix indicating binary, octal or hexadecimal base, 
     *         for example, 0b, 0 and 0x.</li>
     *     <li>A sequence of characters allowed in the number with that radix 
     *         (base)</li>
     * </ol>
     *
     * @param s the string to parse
     * @throws NumberFormatException is the string is not parsable as long
     * @return the parsed long
     */
    public static long parseLong(String s) {
        LongMatch match = getMatch(s);
        long parsedLong = Long.parseLong(match.getBody(), match.getRadix());
        if (match.isNegative())
            parsedLong *= -1;
        return parsedLong;
    }

}
