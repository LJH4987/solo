/**
 * 스캐너를 통해서 콘솔 창에 숫자와 사칙연산자를 입력 받고 마지막에 결과를 반환합니다.
 * 값을 무한히 저장하고 출력하기 위해 ArrayList를 사용했습니다
 * remove를 추가하여 리스트의 맨 앞에 있는 값을 삭제하고 메세지를 통해 보다 이해하기쉽게 만들었습니다.
 */

import java.util.Scanner; // 스캐너를 사용하기 위한 임포트
import java.util.ArrayList; // ArrayList를 사용하기 위해 임포트
import calculator.Calculator; // Calculator 클래스를 사용하기 위해 임포트

public class App {
    public static void main(String[] args) { // 메인이 될 메서드
        ArrayList<Integer> list = new ArrayList<Integer>(); // 값을 저장할 리스트 배열
        Calculator calculator = new Calculator(); // Calculator 객체를 생성
        Scanner sc = new Scanner(System.in);
        //  Scanner sc = new Scanner(System.in); -> scanner sc는 콘솔창에서 입력받기 위한 스캐너 ,
        //  System.in은 키보드 입력을 의미 , new scanner은 새로운 스캐너 객체를 생성한다는 의미

        while (true) {
            System.out.println("첫 번째 숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요 : ");
            int num2 = sc.nextInt();

            System.out.println("사칙연산자를 입력하세요 : ");
            char operator = sc.next().charAt(0); // charAt(0)을 통해 문자열의 첫번째 문자를 가져옴 , chrAt은 문자열의 인덱스를 가져오는 메서드

            try {
                int result = calculator.calculate(num1, num2, operator); // int result에 calculate 메서드를 통해 계산 결과 값을 저장
                System.out.println("결과 : " + result); // calculate 메서드를 통해 계산 결과를 콘솔에 출력합니다.
                list.add(result); // 연산 결과를 리스트 배열에 저장합니다.
            } catch (ArithmeticException e) {
                System.out.println("에러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 ArithmeticException 메세지를 가져와서 에러메세지를 출력!!
            } catch (IllegalArgumentException e) {
                System.out.println("에러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 IllegalArgumentException 메세지를 가져와서 에러메세지를 출력!!
            }

            System.out.println("리스트 배열에 저장된 값: " + list);

            System.out.println("더 계산하시겠습니까? 아무키나 입력해주세요 (exit 입력 시 종료 , inquiry 입력 시 조회 ,  remove 입력 시 맨 앞리스트만 삭제) : ");
            String answer = sc.next();
            if (answer.equals("exit")) {
                break;
            } else if (answer.equals("inquiry")) {
                System.out.println("리스트 배열에 저장된 값: " + list);
            } else if (answer.equals("remove")) {
                System.out.println("리스트 배열에 저장된 값: " + list.get(0) + " 가 삭제되었습니다.");
                list.remove(0);
                System.out.println("리스트 배열에 저장된 값: " + list);
            }
        }
        sc.close(); // 스캐너 종료가 맨 마지막에 있는 이유는 스캐너를 사용하고 난 뒤에는 반드시 닫아주어야 하기 때문입니다.
        // 닫아주지 않는다면 메모리 누수가 발생할 수 있습니다. 이런 방식의 메모리 누수는 프로그램이 종료될 때까지 계속해서 누적되어 쌓이게 됩니다.
        // 즉, 루트 밖에 마지막에 스캐너 종료가 맨 마지막에 있는 이유는 스캐너를 사용 한 후 리소스를 반환하여 메모리 누수를 방지하기 위함입니다.
    }
}
