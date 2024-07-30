// 해당 클래스는 나눗셈을 담당하는 클래스

package calculator;

public class DivideOperator implements Operator {

    @Override
    public boolean supports(char operator) {
        return operator == '/';
    }

    @Override
    public double apply(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다!");
        }
        return num1 / num2;
    }
}
