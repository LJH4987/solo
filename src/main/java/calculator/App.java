import java.util.Scanner;

/**
 * 스캐너를 통해서 콘솔 창에 숫자와 사칙연산자를 입력 받고 마지막에 결과를 반환합니다.
 */

public class App {
    public static void main(String[] args) {
        // 연산 결과 10개를 저장할 수 있는 배열을 선언하고 연산의 결과를 저장합니다.
        // 인덱스 0 번부터이기 떄문에 9까지 배열을 생성합니다.
        int[] arr = new int[9];
        // 무한 루프를 사용하여 빠져 나올 떄까지 계속 계산
        while (true) {
            // Scanner를 통하여 콘솔로부터 입력을 받습니다.
            Scanner sc = new Scanner(System.in);

            // ! = 부정하다 , sc.hasNextInt() = 입력받은 값이 정수인지
            // 콘솔에 정수가 아닌 입력을 받았을 때 오류 메시지를 출력하고 다시 입력받습니다.
            // 첫 번째 숫자 입력
            System.out.print("첫 번째 숫자 입력: ");
            while (!sc.hasNextInt()) { // 입력받은 값이 정수가 아닌 경우
                sc.next(); // 입력받은 값을 버림
                System.out.println("숫자를 입력해주세요!"); // 오류 메시지 출력
                System.out.print("첫 번째 숫자 입력: "); // 다시 입력받기
                //whil 반복문을 통해 숫자가 아닌 입력을 받았을 때 오류 메시지를 출력하고 다시 입력
            }
            int num1 = sc.nextInt();

            // 두 번째 숫자 입력
            System.out.print("두 번째 숫자 입력: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("숫자를 입력해주세요!");
                System.out.print("첫 번째 숫자 입력: ");

            }
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
                // 연산 결과를 배열에 저장
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        System.out.print("인덱스" + "[" + i + "]" + "번" + " 저장 값: " + arr[i] + " ");
                    }
                }
                // 저장된 배열을 불러옴
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 0) {
                        arr[i] = result;
                        System.out.println("새로 배열에 저정된 값: " + arr[i]);
                        break;
                    }
                }
                System.out.println("결과: " + result);
                System.out.println("더 계산하시겠습니까? 아무키나 입력 (exit 입력 시 종료)");
                String exit = sc.next();
                //  if (exit.equals("exit")) -> 입력받은 문자열이 "exit"인 경우 종료합니다.
                // exit=종료 , equals=같다 , "exit"=exit라는 문자열일 경우
                // break; -> 반복문을 종료하고 무한 루프에서 벗어납니다.
                if (exit.equals("exit")) {
                    break;
                }
            }
        }
    }
}