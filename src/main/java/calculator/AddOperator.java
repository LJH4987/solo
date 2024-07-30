// 해당 클래스는 덧셈을 담당하는 클래스

package calculator;

public class AddOperator implements Operator {
    @Override
    public boolean supports(OperatorType operator) {
        return operator == OperatorType.ADD;
        // OperatorType에서 ADD를 받으면 true를 반환해서 apply 메소드를 실행합니다 다른 클래스들도 이러한 방식입니다
    }

    @Override
    public double apply(double num1, double num2) {
        return num1 + num2;
    }
}

