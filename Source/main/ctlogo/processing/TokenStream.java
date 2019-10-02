package ctlogo.processing;

import java.util.List;

/**
 * Stream-like objects for reading Logo tokens
 * 
 * @author Paul Yang
 * 
 * All methods for reading elements may throw IllegalStateException and 
 * NoSuchElementException if nessisary
 *
 */
public interface TokenStream {
	/**
	 * Push a string to the end of the stream (the last to be popped)
	 * 
	 * @param s the content to push
	 * 
	 * @return whether the push is success
	 * 
	 * @note if the stream does not support push, the return value will
	 *       always be false.
	 */
	boolean pushBack(String s);

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
	boolean hasBack();
	
	/**
	 * Get the next token from the stream
	 * 
	 * @return: the next token
	 */
	String getBack();
	
	/**
	 * Get the next token from the stream and remove it from stram
	 * 
	 * @return: the next token
	 */
	String popBack();
	
	/**
	 * Check whether there is any lines
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
