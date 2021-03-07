package hu.meiit.haladojava.calculator;

import hu.meiit.haladojava.calculator.logic.Operator;

import java.util.regex.Pattern;

public class Splitter {
    private final String input;

    public Splitter(ReaderWriter readerWriter) {
        this.input = readerWriter.readFromConsole();
    }

    Exception tooLong = new Exception("It's too long");
    Exception justString = new Exception("It's just a string");

    public String[] splitWithSpace() throws Exception {
        if (input.contains(" ")) {
            String[] splitString = input.split(" ");
            if ((splitString.length == 3) && (Operator.isOperator(splitString[1]))) {
                return splitString;
            } else
                throw tooLong;
        }

        if (input.contains(Operator.ADDITION.getSymbol())) {
            return splitWithoutSpace(Operator.ADDITION);
        }

        if (input.contains(Operator.SUBTRACTION.getSymbol())) {
            return splitWithoutSpace(Operator.SUBTRACTION);
        }

        if (input.contains(Operator.MULTIPLICATION.getSymbol())) {
            return splitWithoutSpace(Operator.MULTIPLICATION);
        }

        if (input.contains(Operator.DIVISION.getSymbol())) {
            return splitWithoutSpace(Operator.DIVISION);
        }

        throw justString;
    }

    private String[] splitWithoutSpace(Operator operator) throws Exception {
        String[] splitString;
        splitString = input.split(Pattern.quote(operator.getSymbol()));
        if (splitString.length == 2) {
            return new String[]{splitString[0], operator.getSymbol(), splitString[1]};
        }

        throw tooLong;
    }
}
