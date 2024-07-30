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
        this.operators.add(new AddOperator());
        this.operators.add(new SubtractOperator());
        this.operators.add(new MultiplyOperator());
        this.operators.add(new DivideOperator());
        this.operators.add(new ModOperator());
    }

    public double calculate(double num1, double num2, char operatorSymbol) {
        OperatorType operatorType = OperatorType.fromSymbol(operatorSymbol);
        for (Operator op : operators) {
            if (op.supports(operatorType)) {
                double result = op.apply(num1, num2);
                list.add(result);
                return result;
            }
        }
        throw new IllegalArgumentException("지원되지 하지않는 연산자앙너ㅏㅇㅋ타ㅣ러!!! : " + operatorSymbol);
    }
}

// operatorType을 통해서 연산자를 찾아내고, 연산자를 찾아내서 해당 연산자를 싫랴합니다.
// 연산자를 찾아내는 과정에서 연산자가 없다면 IllegalArgumentException(에러)을 발생시킵니다.