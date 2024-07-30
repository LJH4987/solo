package calculator;

public class MultiplyOperator implements Operator {
    @Override
    public double apply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public boolean supports(char operator) {
        return operator == '*';
    }
}
