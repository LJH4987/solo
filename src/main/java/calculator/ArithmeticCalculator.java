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

    public double calculate(double num1, double num2, char operator) {
        for (Operator op : operators) {
            if (op.supports(operator)) {
                double result = (double) op.apply(num1, num2);
                list.add(result);
                return result;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 사칙연산자입니다람쥐: " + operator);
    }
}