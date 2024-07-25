import java.util.Scanner;

/**
 * 스캐너를 통해서 콘솔 창에 숫자와 사칙연산자를 입력 받고 마지막에 결과를 반환합니다.
 */

public class App {
    public static void main(String[] args) {

        // Scanner를 통하여 콘솔로부터 입력을 받습니다.
        Scanner sc = new Scanner(System.in);

        // 첫 번째 숫자 입력
        System.out.print("첫 번째 숫자 입력: ");
        int num1 = sc.nextInt();

        // 두 번째 숫자 입력
        System.out.print("두 번째 숫자 입력: ");
        int num2 = sc.nextInt();

        // 입력받은 사칙연산 연산자를 char 타입 변수 operator에 저장합니다.
        // char operator = sc.next().charAt(0); -> 입력받은 문자열 중 첫 번째 문자만 가져옵니다.
        System.out.print("사칙연산 입력(+, -, *, /): ");
        char operator = sc.next().charAt(0);
        int result = 0;
        int error = 0;

        // if문을 사용하여 입력받은 사칙연산자에 맞게 계산 및 결과를 출력하고
        // 사칙연산자가 아닌 경우 혹은 연산 오류에는 오류 메시지를 출력합니다.
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                error = -1; // 0으로 나눌 수 없는 경우
                System.out.println("0으로 나눌 수 없습니다!");
            } else {
                result = num1 / num2;
            }
        } else {
            error = -2; // 사칙연산자 (+,-,*,/) 가 아닐 경우
            System.out.println("사칙연산자가 아닙니다!");
        }

        if (error == 0) {
            System.out.println("결과 : " + result);
        }
    }
}
