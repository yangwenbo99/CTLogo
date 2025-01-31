package ctlogo.processing;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicTokenStream implements TokenStream, Closeable, AutoCloseable {

    private Deque<String> currentLine = new ArrayDeque<>();
    private Scanner sc;
    private int currentRow = -1;

    static private final String delimiters = 
        "[\\[\\](){}]";
    static private final String operators = "[+\\-\\*/%^~#\\\\_<>=!]";
    static private final String notOnLeft = "[<>!&|:]";
    static private final String notOnRight = "[<>=&|]";

    static private final Pattern splitPattern = Pattern.compile(
            "(?=" + delimiters + ")" +
            "|(?<=" + delimiters + ")" + 
            "|((?<!" + notOnLeft + ")" + "(?=" + operators + "))" +
            "|((?<=" + operators + ")" + "(?!" + notOnRight + "))" + 
            "|\\s+"
            );
    static private final Pattern stringPattern = Pattern.compile(
            "\'.*?(?<!\\\\)(\\\\\\\\)*(\'|$)");

    public BasicTokenStream(Scanner sc) {
        this.sc = sc;
    }
    
    private void parse(String input) {
        String [] currentArray = splitPattern.split(input);

        // TODO: columns
        for (String s : currentArray) {
            if (!s.trim().equals("")) {
                currentLine.addLast(s.trim());
            }
        }
    }

    private void parseNextLine() {
		currentRow++;
        String lineString = sc.nextLine();
        
        Matcher stringMatcher = stringPattern.matcher(lineString);
        
        int currentLoc = 0;
        while (stringMatcher.find(currentLoc)) {
            int nonStringStart = currentLoc;
            parse(lineString.substring(nonStringStart, stringMatcher.start()));
            currentLine.addLast(lineString.substring(
                    stringMatcher.start(), stringMatcher.end()));
            currentLoc = stringMatcher.end();
        }
        
        parse(lineString.substring(currentLoc));

        if (currentLine.size() > 0 && currentLine.getLast().equals("_")) {
            currentLine.removeLast();
            parseNextLine();
        } else {
            currentLine.addLast("\n");
        }
    }

	/**
	 * Push a string to the front of the stream (the first to be popped)
	 * 
	 * @param s: the content to push
	 * 
	 * @return whether the push is success
     *
     * This shall only be allowed when hasNext() is true. 
	 */
    @Override
    public boolean pushFront(String s) {
        /*
        if (currentLine.isEmpty()) {
            if (!hasNext())
                return false;
            parseNextLine();
        }
        */
        if (!currentLine.offerFirst(s)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean hasNext() {
        return !currentLine.isEmpty() || sc.hasNext();
    }

    @Override
    public String getNext() {
        if (currentLine.isEmpty()) {
            parseNextLine();
        }
        return currentLine.getFirst();
    }

    @Override
    public String popNext() {
        if (currentLine.isEmpty()) {
            parseNextLine();
        }
        return currentLine.removeFirst();
    }

    @Override
    public boolean hasNextLine() {
        return !currentLine.isEmpty() || sc.hasNextLine();
    }

    @Override
    public List<String> getNextLine() {
        if (currentLine.isEmpty())
            parseNextLine();

        List<String> res = new ArrayList<>(currentLine);

        while (!currentLine.isEmpty()) {
            currentLine.remove();
        }
        return res;
    }

    @Override
    public int getCurrentRow() {
        if (currentLine.isEmpty())
            parseNextLine();
        return currentRow;
    }

	@Override
	public void close() throws IOException {
		sc.close();
	}

}
