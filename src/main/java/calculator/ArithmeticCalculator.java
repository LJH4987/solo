// 해당 클래스는 사칙연산을 수행하는 계산기 클래스입니다.
// 이전 스위치를 통한 사칙연산이 아닌 public double calculate(double num1, double num2, char operator)
// 를 통해 스위치나 if를 사용하지 않고 연산자를 찾아 계산합니다.

package calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator extends Calculator {
    private List<Operator> operators;

    public ArithmeticCalculator() {
        this.operators = new ArrayList<>();
        this.operators.add(new AddOperator()); // 더하기
        this.operators.add(new SubtractOperator()); // 뺴기
        this.operators.add(new MultiplyOperator()); // 곱하기
        this.operators.add(new DivideOperator()); // 나누기
        this.operators.add(new ModOperator()); // 나머지 (퍼샌트)
    }

    public double calculate(double num1, double num2, char operator) {
        for (Operator op : operators) {
            if (op.supports(operator)) {
                double result = op.apply(num1, num2);
                list.add(result);
                return result;
            }
        }
        throw new IllegalArgumentException("사칙연산자가 아닙니다!");
    }
}