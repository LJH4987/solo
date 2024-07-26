package calculator;

import java.util.ArrayList;

public class Calculator { // Calculator 클래스를 생성

    private static ArrayList<Integer> list = new ArrayList<>(); // 임포트한 ArrayList를 사용하여 계산 결과를 저장할 리스트 배열을 생성합니다.

    // 사칙연산 메서드
    public int calculate(int num1, int num2, char operator) { // 반환 타입은 int로 설정하고 매개변수로 num1, num2, operator(연산자)를 받습니다.
        int result = 0; // 연산 후 값을 저장할 변수
        // 요구사항에 맞게 throw로 예외처리를 해주기위해 error 변수는 필요없어요

        // 입력받은 사칙연산자에 맞게 계산 및 결과를 출력하고 사칙연산자가 아닌 경우 혹은 연산 오류에는 오류 메시지를 출력합니다.
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) { // 두번째 입력을 0으로 받았을 때 예외처리
                throw new ArithmeticException("0으로 나눌 수 없습니다!"); // 0으로 나눌 수 없는 경우 예외처리 , 요구사항에 맞게 throw로 예외처리를 해줍니다.
                // ArithmeticException : 숫자 연산 오류를 처리해주는 예외처리 클래스
            } else { // 0으로 나누지 않은 경우 정상 실행
                result = num1 / num2;
            }
        } else {
            throw new IllegalArgumentException("사칙연산자가 아닙니다!"); // 사칙연산자가 아닌 경우 예외처리 ,
            // IllegalArgumentException : 잘못된 인수를 전달했을 때 발생하는 예외처리 클래스
        }

        list.add(result); // 연산 결과를 리스트 배열에 저장합니다.
        return result; // 연산 결과를 반환합니다.
    }

    /*
    // 테스트를 위한 main 메서드
    public static void main(String[] args) { // 이렇게 작성해서 테스트한걸 기준으로 App에 적용할 예정입니다
        Calculator calculator = new Calculator(); // Calculator 객체를 생성

        // calculate 메서드를 통해 계산 결과를 출력합니다.
        try {
            System.out.println("덧샘: " + calculator.calculate(5, 5, '+')); // calculate.calculate를 통해 계산 결과를 콘솔에 출력합니다.
            System.out.println("뺄샘: " + calculator.calculate(5, 5, '-'));
            System.out.println("곱샘: " + calculator.calculate(5, 5, '*'));
            System.out.println("나눗샘: " + calculator.calculate(9, 3, '/'));
            System.out.println("에러나눗샘: " + calculator.calculate(10, 0, '/'));

        } catch (ArithmeticException e) {
            System.out.println("예러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 메세지를 가져와서 에러메세지를 출력!!
        }

        try {
            System.out.println("이상한놈 : " + calculator.calculate(5, 5, 'ㅋ')); // 입력한게 사칙연산자가 아닌경우 예외처리 테스트
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 : " + e.getMessage()); // IllegalArgumentException을 잡아 처리
        }

        System.out.println("리스트 배열에 저장된 값: " + list); // 리스트 배열에 저장된 값 출력
    } */
}

