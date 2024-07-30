package calculator;

public class DivideOperator {
    public double operate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다!");
        }
        return num1 / num2;
    }
}
