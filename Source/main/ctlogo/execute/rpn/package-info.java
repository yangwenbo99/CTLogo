/**
 * Used for implementing code "compiling". 
 *
 * <p>RPN is the abbreviation of reverse Polish notation</p>
 *
 * <p>
 * From RPN to Expression object:
 * </p>
 *
 * <ul>
 * <li> An unary operator will eat one RPN object and put one RPN object 
 *   back to stack</li>
 * <li> A binary operator will eat two and push two</li>
 * <li> A function call will eat all RPN objects until function terminator 
 *   object eaten.</li>
 * <li> The final RPN object possesses the final expression</li>
 * </ul>
 *     
 */
package ctlogo.execute.rpn;

