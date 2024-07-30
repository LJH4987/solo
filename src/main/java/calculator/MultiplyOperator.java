// 곱하기를 담당하느 클래스

package calculator;

public class MultiplyOperator implements Operator<Number> {
    @Override
    public boolean supports(char operator) {
        return operator == '*';
    }

    @Override
    public Number apply(Number num1, Number num2) {
        if (num1 instanceof Double || num2 instanceof Double) {
            return num1.doubleValue() * num2.doubleValue();
        } else {
            return num1.intValue() * num2.intValue();
        }
    }
}



