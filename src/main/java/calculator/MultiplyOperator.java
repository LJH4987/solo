// 곱하기를 담당하느 클래스

package calculator;

public class MultiplyOperator implements Operator {
    @Override
    public boolean supports(OperatorType operator) {
        return operator == OperatorType.MULTIPLY;
    }

    @Override
    public double apply(double num1, double num2) {
        return num1 * num2;
    }
}


