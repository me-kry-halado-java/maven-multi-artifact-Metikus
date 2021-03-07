package hu.meiit.haladojava.logic;

public class MathExpression {

    public static final String ERROR_SOMEWHERE = "-";

    private final double op1;
    private final double op2;
    private final String operator;
    Exception notImplementedOperator = new Exception("It's an operation which did not have any implement");

    public MathExpression(double op1, double op2, String operator) {
        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }

    public String calculate() throws Exception {
        switch (Operator.getOperation(operator)) {
            case ADDITION:
                return String.valueOf(op1 + op2);

            case SUBTRACTION:
                return String.valueOf(op1 - op2);

            case MULTIPLICATION:
                return String.valueOf(op1 * op2);

            case DIVISION:
                if (op2 == 0) {
                    return MathExpression.ERROR_SOMEWHERE;
                } else {
                    return String.valueOf(op1 / op2);
                }
            default:
                throw notImplementedOperator;
        }
    }
}
