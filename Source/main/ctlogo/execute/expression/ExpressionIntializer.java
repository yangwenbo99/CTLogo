package ctlogo.execute.expression;

public class ExpressionIntializer {

	public static void registerAll() {
        OperatorManager.getInstance().registerUnaryOperator("+", PositiveOperator.class);
        OperatorManager.getInstance().registerUnaryOperator("-", NegativeOperator.class);

        OperatorManager.getInstance().registerBinaryOperator("+", PlusOperator.class, 0);
        OperatorManager.getInstance().registerBinaryOperator("-", MinusOperator.class, 0);
        OperatorManager.getInstance().registerBinaryOperator("*", MultiplyOperator.class, 10);
        OperatorManager.getInstance().registerBinaryOperator("/", DivisionOperator.class, 10);
        OperatorManager.getInstance().registerBinaryOperator("%", ModuloOperator.class, 10);
	}

}
