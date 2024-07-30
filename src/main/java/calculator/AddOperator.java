// 해당 클래스는 덧셈을 담당하는 클래스

package calculator;

public class AddOperator implements Operator {
    @Override
    public boolean supports(char operator) {
        return operator == '+';
    }

    @Override
    public double apply(double num1, double num2) {
        return num1 + num2;
    }
}
