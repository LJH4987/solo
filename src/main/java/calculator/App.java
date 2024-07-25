/**
 * 스캐너를 통해서 콘솔 창에 숫자와 사칙연산자를 입력 받고 마지막에 결과를 반환합니다.
 * 값을 무한히 저장하고 출력하기 위해 ArrayList를 사용했습니다
 * remove를 추가하여 리스트의 맨 앞에 있는 값을 삭제하고 메세지를 통해 보다 이해하기쉽게 만들었습니다.
 */

import java.util.Scanner; // 스캐너를 사용하기 위한 import
import java.util.ArrayList; // ArrayList를 사용하기 위해 import

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(); // 무한하게 값을 저장하고 출력하기 위해 ArrayList를 사용합니다.
        Scanner sc = new Scanner(System.in);
        // 스캐너를 루프 밖에서 생성하여 반복문이 실행될 때마다 새로운 스캐너를 생성하지 않고 사용하게 변경했습니다.
        // ArrayList를 사용하여 계산 결과를 저장할 리스트 배열을 생성합니다.
        // 리스트에도 무한으로 값을 넣기위해 while문을 통한 반복문으로 계속 값을 입력받고 저장할생각입니다!
        // 무한이 아니라 리스트에 제한을 걸고 싶으면 리스트 인덱스를 통해 제한을 걸면됩니다.
        // 리스트 인덱스 제한 예시 : if (list.size() > 10) { list.remove(0); } -> 리스트 배열에 10개 이상의 값이 들어가면 맨 앞에 있는 값을 삭제합니다.
        // list.size는 리스트 배열에 저장된 값의 개수를 의미 .remove는 리스트 배열에 저장된 값을 삭제하는 메소드
        while (true) {
            // ! = 부정하다 , sc.hasNextInt() = 입력받은 값이 정수인지
            // 콘솔에 정수가 아닌 입력을 받았을 때 오류 메시지를 출력하고 다시 입력받습니다.
            // 첫 번째 숫자 입력
            System.out.print("첫 번째 숫자 입력: ");
            // 입력받은 값이 정수가 아닌 경우 , !sc.hasNextInt()는 입력받은 값이 정수가 아닌 경우를 의미해요
            // !는 부정을 의미하고 sc.hasNextInt()는 입력받은 값이 정수인지 확인합니다!
            while (!sc.hasNextInt()) {
                sc.next(); // 입력받은 값을 버림
                System.out.println("숫자를 입력해주세요!"); // 오류 메시지 출력
                System.out.print("첫 번째 숫자 입력: "); // 다시 입력받기
                //whil 반복문을 통해 숫자가 아닌 입력을 받았을 때 오류 메시지를 출력하고 다시 입력
            }
            int num1 = sc.nextInt(); // 콘솔로 입력받은 정수를 스캐너를 통해 num1에 저장합니다.

            // 두 번째 숫자 입력 , 원리는 위와 동일
            System.out.print("두 번째 숫자 입력: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("숫자를 입력해주세요!");
                System.out.print("두 번째 숫자 입력: ");

            }
            int num2 = sc.nextInt();

            // 입력받은 사칙연산 연산자를 char 타입 변수 operator에 저장합니다.
            // char operator = sc.next().charAt(0); -> 입력받은 문자열 중 첫 번째 문자만 가져옵니다.
            // 문자열중 첫번째만 가쟈오는 이유는 사칙연산자는 한글자이기 때문에 첫번째 문자만 가져오면 되기도 하고 사칙연산자를 중복으로 입력받는것을 방지하기 위함입니다.
            System.out.print("사칙연산 입력(+, -, *, /): ");
            char operator = sc.next().charAt(0);
            int result = 0; // 연산 후 값을 저장할 변수
            int error = 0; // 에러가 발생할 경우 예외처리를 위한 변수

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

            // 리스트 배열에 결과를 저장하고 출력
            if (error == 0) { // 에러가 없는 경우
                list.add(result); // 리스트 배열에 결과를 저장해요
                System.out.println("결과: " + result); // 결과 메세지와 함께 결과를 출력해요
            }

            // 리스트 배열에 저장된 결과를 출력
            System.out.print("기록된 리스트: "); // 리스트 배열에 저장된 값을 불러주기위한 메세지
            for (int i = 0; i < list.size(); i++) { // 리스트를 루트하며 값을 출력 하기위함! 현재 리스트의 길이만큼 더해가며 반복합니다
                System.out.print(list.get(i) + " "); // 리스트 배열에 저장된 값을 출력해요 루프를 통해서 get(i)를 통해 값을 불러오면서 빈 스트링을 통해 띄어쓰며 출력해요
            }
            System.out.println(); // 그냥 줄바꿈용

            // 계산을 더 할 것인지 물어보고,더 하지 않는다면 exit를 입력하여 종료합니다.
            System.out.print("계속 계산하시겠습니까? 아무키나 입력후 엔터하거나 다음과 같은 명령어를 확인 후 입력해주세요"); // 계속 계산할 것인지 물어보기
            System.out.println(); // 줄바꿈용
            System.out.println("remove: 리스트의 맨 앞에 있는 값 삭제, exit: 계산기 종료"); // remove와 exit 명령어 안내 메세지
            String exit = sc.next(); // exit입력 했는지 확인하기 위해 String 변수에 저장
            // remove를 입력하면 리스트의 맨 앞에있는 값을 삭제합니다
            if (exit.equals("remove")) { // remove 스트링을 입력하면
                if (list.size() > 0) { // 리스트 배열에 값이 있을 경우
                    System.out.println("삭제된 리스트 값 : " + list.get(0)); // 삭제된 값 출력 , list.get(0)은 리스트 배열의 맨 앞에 있는 값을 불러올떄 사용해요!
                    list.remove(0); // 리스트 배열의 맨 앞에 있는 값을 삭제해요 삭제전 삭제할 리스트를 알려주기위해 앞의 메세지보다 뒤에 있어요
                    System.out.println("리스트의 맨 앞에 있는 값이 삭제되었습니다."); // 삭제 메세지 출력
                    System.out.println("현재 리스트에 저장된 값 : " + list); // 현재 리스트에 저장된 값 출력
                    // 별도의 코드 추가없이도 아무키나 입력해도 계속 계산이 가능하도록 하기 위해 while문을 사용했어서 remove를 입력하면 계속 계산이 가능합니다.
                    // while문을 사용하지 않고 remove를 입력하면 계산이 종료되도록 하려면 remove를 입력한 후 break;를 통해 반복문을 탈출하면됩니다!

                } else { // 리스트 배열에 값이 없을 경우
                    System.out.println("삭제할 리스트 값이 없습니다."); // 값이 없다는 메세지 출력
                }
            } else
            if (exit.equals("exit")) { // exit를 입력하면 앱을 종료
                break; // 탈출!!!!
            }
        }
    }
}


