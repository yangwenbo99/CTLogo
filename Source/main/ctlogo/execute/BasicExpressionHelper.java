/**
 * 
 */
package ctlogo.execute;

import java.util.List;

import ctlogo.data.CTDouble;
import ctlogo.data.CTInteger;
import ctlogo.data.CTString;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.expression.Expression;
import ctlogo.execute.expression.LiteralExpression;
import ctlogo.execute.expression.OperatorManager;
import ctlogo.execute.rpn.RPNExpressionManager;
import ctlogo.execute.util.DoubleParser;
import ctlogo.execute.util.LongParser;
import ctlogo.function.FunctionManager;

/**
 * @author Paul Yang
 *
 */
public class BasicExpressionHelper {

    static boolean isLiteral(String token) {
        return 
            isStringLitertal(token) || 
            isDoubleLiteral(token) || 
            isIntegerLiteral(token);
    }

    private static boolean isStringLitertal(String token) {
        return 
            token.length() >= 2 && 
            token.charAt(0) == '\'' && 
            token.charAt(token.length()-1) == '\'' || 
            token.length() > 1 && 
            token.charAt(0) == '"';
    }

    private static boolean isDoubleLiteral(String token) {
        return DoubleParser.isParseable(token);
    }

    private static boolean isIntegerLiteral(String token) {
        return LongParser.isParseable(token);
    }

    /**
	 * Parse a literal.
	 * @throws CTSyntaxException
	 */
	static Expression parseLiteral(String token) throws CTSyntaxException {
		  if (isStringLitertal(token)) {
            return fromStringToken(token);
        } else if (isIntegerLiteral(token)) {
            return fromIntegerToken(token);
        } else if (isDoubleLiteral(token)) {
            return fromDoubleToken(token);
        } else {
            throw new NumberFormatException("This token is not like literal");
        }
    }

	private static LiteralExpression fromStringToken(String token) throws CTSyntaxException {
		if (token.charAt(0) == '\'')
			return new LiteralExpression(new CTString(token.substring(1, token.length()-1)));
		else if (token.charAt(0) == '"')
			return new LiteralExpression(new CTString(token.substring(1)));
		else 
			throw new CTSyntaxException("String literal of incorrect format");
    }

    private static LiteralExpression fromIntegerToken(String token) {
        return new LiteralExpression(new CTInteger(LongParser.parseLong(token)));
    }

    private static LiteralExpression fromDoubleToken(String token) {
        return new LiteralExpression(new CTDouble(DoubleParser.ParseDouble(token)));
    }

    static boolean isUnaryOperator(String token) {
        return OperatorManager.getInstance().hasUnaryOperator(token);
    }

    static boolean isBinaryOperator(String token) {
        return OperatorManager.getInstance().hasBinaryOperator(token);
    }

    static OperatorTokenMark constructUnaryOperator(String token) {
        return 
            new OperatorTokenMark(
                RPNExpressionManager.getInstance().getUnaryOperator(token),
                Integer.MAX_VALUE);
    }

    static OperatorTokenMark constructBinaryOperator(String token) {
        return 
            new OperatorTokenMark(
                    RPNExpressionManager.getInstance().getBinaryOperator(token),
                    OperatorManager.getInstance().getBinaryOperationPrecedence(token)
            ); 
    }

    static OperatorTokenMark constructLeftParenthesisMarker() {
        return OperatorTokenMark.forLeftParenthesis();
    }

    static boolean isFunction(String token) {
        return FunctionManager.getInstace().hasFunction(token);
    }

	static boolean isLikeVariable(String token) {
		return token.length() > 1 && token.charAt(0) == ':';
	}

    static int getDefaultParamNum(String token) {
        return FunctionManager.getInstace().getDefaultParameterNum(token);
    }

    static Expression constructFunctionExpression(
            String token, List<Expression> exps) throws CTSyntaxException {
        return FunctionManager.getInstace().getFunctionExpression(
                token, exps);
    }

}

