package hu.meiit.haladojava.logic;

public enum Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");



    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static boolean isOperator(String s) {
        for (Operator operator : Operator.values()) {
            if (s.equals(operator.getSymbol())) {
                return true;
            }
        }
        return false;
    }

    public static Operator getOperation(String s) throws Exception {

        for (Operator operator : Operator.values()) {
            if (s.equals(operator.getSymbol())) {
                return operator;
            }
        }
        throw new Exception("Not Operator");
    }
}
