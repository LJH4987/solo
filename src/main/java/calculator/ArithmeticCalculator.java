package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator extends Calculator {
    private List<Operator<Number>> operators;

    public ArithmeticCalculator() {
        this.operators = new ArrayList<>();
        this.operators.add(new AddOperator());
        this.operators.add(new SubtractOperator());
        this.operators.add(new MultiplyOperator());
        this.operators.add(new DivideOperator());
        this.operators.add(new ModOperator());
    }

    public double calculate(double num1, double num2, char operator) {
        for (Operator<Number> op : operators) {
            if (op.supports(operator)) {
                Number result = op.apply(num1, num2);
                double doubleResult = result.doubleValue(); // Number를 double로 변환
                list.add(doubleResult);
                return doubleResult;
            }
        }
        throw new IllegalArgumentException("지원되지 않는 연산자입니다: " + operator);
    }

    public List<Double> findResultsGreaterThan(double value) {
        return list.stream()
                .filter(result -> result > value)
                .collect(Collectors.toList());
    }

    public List<Double> findResultsInRange(double min, double max) {
        return list.stream()
                .filter(result -> result >= min && result <= max)
                .collect(Collectors.toList());
    }

    public List<Double> findResultsEqualTo(double value) {
        return list.stream()
                .filter(result -> result == value)
                .collect(Collectors.toList());
    }

    public List<Double> findResultsLessThan(double value) {
        return list.stream()
                .filter(result -> result < value)
                .collect(Collectors.toList());
    }

    public List<Double> getResults() {
        return list;
    }
}
