// 해당 클래스는 나눗셈을 담당하는 클래스

package calculator;

public class DivideOperator implements Operator<Number> {
    @Override
    public boolean supports(char operator) {
        return operator == '/';
    }

    @Override
    public Number apply(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다!");
        }
        if (num1 instanceof Double || num2 instanceof Double) {
            return num1.doubleValue() / num2.doubleValue();
        } else {
            return num1.intValue() / num2.intValue();
        }
    }
}


