// 해당 클래스는 나머지 (%) 담당 클래스

package calculator;

public class ModOperator implements Operator {
    @Override
    public boolean supports(OperatorType operator) {
        return operator == OperatorType.MOD;
    }

    @Override
    public double apply(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다!");
        }
        return num1 % num2;
    }
}

