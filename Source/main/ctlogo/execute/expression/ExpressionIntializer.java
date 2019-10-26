package ctlogo.execute.expression;

public class ExpressionIntializer {

	public static void registerAll() {
        OperatorManager.getInstance().registerUnaryOperator("+", PositiveOperator.class);
        OperatorManager.getInstance().registerUnaryOperator("-", NegativeOperator.class);

        OperatorManager.getInstance().registerBinaryOperator("+", PlusOperator.class);
        OperatorManager.getInstance().registerBinaryOperator("-", MinusOperator.class);
        OperatorManager.getInstance().registerBinaryOperator("*", MultiplyOperator.class);
        OperatorManager.getInstance().registerBinaryOperator("/", DivisionOperator.class);
        OperatorManager.getInstance().registerBinaryOperator("%", ModuloOperator.class);
	}

}
