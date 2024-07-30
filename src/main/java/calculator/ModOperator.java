// 해당 클래스는 나머지 (%) 담당 클래스

package calculator;

public class ModOperator implements Operator {
    @Override
    public double apply(double num1, double num2) {
        return num1 % num2;
    }

    @Override
    public boolean supports(char operator) {
        return operator == '%';
    }
}
