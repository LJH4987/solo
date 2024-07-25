import java.util.Scanner;

/**
 * 스캐너를 통해서 콘솔 창에 숫자를 입력 받고 마지막에 입력한 숫자를 반환합니다.
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

        // 사칙연산 입력
        System.out.print("사칙연산 입력(+, -, *, /): ");
        char operator = sc.next().charAt(0);

        System.out.println("operator = " + operator);



        // Here, you would continue with your logic to perform the operation
    }
    // No extra closing brace here
}