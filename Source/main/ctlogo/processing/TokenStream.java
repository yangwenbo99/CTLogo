package ctlogo.processing;

import java.util.List;
import java.util.Iterator;

/**
 * Stream-like objects for reading Logo tokens
 * 
 * @author Paul Yang
 * 
 * All methods for reading elements may throw IllegalStateException and 
 * NoSuchElementException if nessisary
 *
 */
public interface TokenStream extends Iterator<String> {
	/**
	 * Push a string to the front of the stream (the first to be popped)
	 * 
	 * @param s: the content to push
	 * 
	 * @return whether the push is success
	 */
	boolean pushFront(String s);
	
	/**
	 * Check whether there is any elements
	 * 
	 * @return if there is any pending elements 
	 */
	boolean hasNext();
	
	/**
	 * Get the next token from the stream.
     *
     * In case of new line, "\n" will be returned by default.
	 * 
	 * @return: the next token
	 */
	String getNext();

    default String next() { return popNext(); }
	
	/**
	 * Get the next token from the stream and remove it from stram.
	 * 
     * In case of new line, "\n" will be returned by default.
     *
	 * @return: the next token
	 */
	String popNext();
	
	/**
	 * Check whether there is any lines.
     *
     * "\n" will not be included.
	 * 
	 * @return if there is any pending lines
	 */
	boolean hasNextLine();

	/**
	 * Get all tokens from the current unfinished line.
	 * 
	 * @return the next line of token, if nothing in current line, 
	 */
	List<String> getNextLine();
	
	/**
	 * Get current row being processed
	 * @return row number of current row
	 */
	int getCurrentRow();
	/**
	 * Get current column being processed
	 * @return column number of current row
	 */
	int getCurrentColumn();
}
