// 해당 클래스는 사칙연산을 수행하는 클래스입니다.
// 호출될 시 계산 후 결과값을 반환합니다.
// + 2-7까지 기존 if 문이였던 사칙연산을 switch 문으로 변경하여 가독성을 높였었습니다.

package calculator;

public class ArithmeticCalculator extends Calculator {

    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다!");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("사칙연산자가 아닙니다!");
        }

        list.add((double) result); // double로 형변환하여 list에 add(추가)합니다.
        // double로 변형하는 이유는 Calculator 클래스의 list는 원의 넓이까지 고려하여 double로 선언했기 ㅒ문입니다.
        return result; // 결과값을 반환
    }
}
