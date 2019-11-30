package ctlogo.execute.rpn;

/**
 * Used for implementing code "compiling". 
 *
 *
 * From RPN to Expression object:
 * - An unary operator will eat one RPN object and put one RPN object 
 *   back to stack
 * - A binary operator will eat two and push two
 * - A function call will eat all RPN objects until function terminator 
 *   object eaten.
 * - The final RPN object possesses the final expression
 *     
 */
