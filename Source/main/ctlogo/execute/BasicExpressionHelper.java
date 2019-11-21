/**
 * 
 */
package ctlogo.execute;

import java.util.List;

import ctlogo.execute.util.*;
import ctlogo.data.*;
import ctlogo.exception.CTSyntaxException;
import ctlogo.execute.rpn.*;
import ctlogo.execute.expression.*;
import ctlogo.execute.rpn.RPNExpressionManager;
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
            token.charAt(0) == '"' && 
            token.charAt(token.length()-1) == '"';
    }

    private static boolean isDoubleLiteral(String token) {
        return DoubleParser.isParseable(token);
    }

    private static boolean isIntegerLiteral(String token) {
        return LongParser.isParseable(token);
    }

    /**
     * Parse a literal.
     */
    static Expression parseLiteral(String token) {
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

    private static LiteralExpression fromStringToken(String token) {
        return new LiteralExpression(new CTString(token.substring(1, token.length()-1)));
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

    static int getDefaultParamNum(String token) {
        return FunctionManager.getInstace().getDefaultParameterNum(token);
    }

    static Expression constructFunctionExpression(
            String token, List<Expression> exps) throws CTSyntaxException {
        return FunctionManager.getInstace().getFunctionExpression(
                token, exps);
    }

}

