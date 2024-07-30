// 해당클래스는 뺄셈 담당 클래스

package calculator;

public class SubtractOperator implements Operator {
    @Override
    public double apply(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public boolean supports(char operator) {
        return operator == '-';
    }
}
