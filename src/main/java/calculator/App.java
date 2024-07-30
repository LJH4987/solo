/**
 * 스캐너를 통해서 콘솔 창에 숫자와 사칙연산자를 입력 받고 마지막에 결과를 반환합니다.
 * 값을 무한히 저장하고 출력하기 위해 ArrayList를 사용했습니다
 * remove를 추가하여 리스트의 맨 앞에 있는 값을 삭제하고 메세지를 통해 보다 이해하기쉽게 만들었습니다.
 * 매서드란 클래스 내부에 구현된 함수를 의미합니다. 예시) public int calculate(int num1, int num2, char operator) { }
 * = 해석하면 public 접근제어자를 가진 반환타입이 int이고 calculate라는 이름을 가진 매개변수로 num1, num2, operator를 받는 함수를 의미합니다.
 * 임포트한 calculator.Calculator를 통해 calculate 클래스를 사용해 계산을 하고 결과를 출력합니다.
 */

package calculator; // calculator 패키지
/*
 * import calculator.Calculator;를 삭제하고 package calculator; 를 추가하여 Calculator 클래스를 사용할 수 있도록 변경
 * package calculator를 해석하면 calculator 패키지 사용을 의미
 * 패키지란 클래스 파일을 담는 디렉토리로 클래스 파일을 구분하기 위해 사용합니다.
 * 패키지를 사용하면 클래스 파일을 쉽게 찾을 수 있고, 클래스 파일의 중복을 피할 수 있습니다.
 * 이런 방식으로 같은 패키지 내에 있는 클래스는 import 없이도 사용이 가능하고
 * 다른 패키지에 있는 클래스를 사용하려면 import를 사용하여 가져와야 합니다.
 */

import java.util.Scanner; // 스캐너를 사용하기 위한 임포트
import java.util.ArrayList; // ArrayList를 사용하기 위해 임포트

public class App {
    public static void main(String[] args) { // 메인이 될 메서드
        /*
         * public static void main(String[] args) { -> 프로그램 실행을 위해 반드시 필요한 메서드로 메인 메서드라고 합니다.
         * 메인 메서드는 프로그램을 실행할 때 가장 먼저 실행되는 메서드입니다
         * 메인 메서드는 public static void main(String[] args) { } 형태로 작성되어야 합니다.
         * main은 메서드 이름이며, String[] args는 문자열 배열 타입의 매개변수입니다.
         * string을 사용하는 이유는 문자열을 사용하기 위함입니다.
         * args는 argument의 약자로 매개변수를 의미합니다.
         * 매개변수는 메서드를 호출할 때 전달하는 값으로, 전달된 값은 메서드 내부에서 사용할 수 있습니다.
         */

        Calculator calculator = new Calculator(); // 해석하면  Calculator calculator = new Calculator(); -> calculator 클래스사용을 위한 새로운 객체를 생성합니다.
        /*
         * 해당 객체를 통해 Calculator 클래스의 메서드를 사용할 수 있습니다.
         * 이 코드가 없다면 Calculator 클래스의 메서드를 사용할 수 없습니다.
         * 이러한 분리 작업으로 캡슐화를 통해 코드의 보안성을 높이고 재사용성을 높이기 위함입니다.
         * 객체 내부 상태를 외부에서 직접 접근하지 못하도록 하기 위해 private로 선언된 필드에 접근할 수 있도록 getter와 setter를 이용한 간접 접근을 통해 필드에 접근할 수 있습니다.
         * 필드란 클래스 내부에 선언된 변수를 의미합니다.
         */
        Scanner sc = new Scanner(System.in);
        /*
         * Scanner sc = new Scanner(System.in); -> scanner sc는 콘솔창에서 입력받기 위한 스캐너 ,
         * System.in은 키보드 입력을 의미 , new scanner은 새로운 스캐너 객체를 생성한다는 의미
         */

        while (true) {

            // 사칙연산 외에 반복문에 사칙연산을 할지 원의 넓이를 구할지 선택지를 만들엊ㅜㅂ니다
            System.out.println("원의 넓이를 구하려면 1번 , 사칙연산을 하려면 2번을 입력하세요 : ");
            int select = sc.nextInt(); // select 변수에 스캐너로 입력받은 값을 저장
            int choice = 0; // choice 변수를 0으로 초기화

            if (select != 1 && select != 2) { // select가 1 또는 2가 아닌 경우 예외처리를 합니다.
                System.out.println("1번과 2번 중에 하나만 입력해주세요!! "); // 1번과 2번 중에 선택하라는 메세지를 출력합니다.
                continue; // continue를 사용하여 반복문을 다시 실행합니다.
            }

            if (select == 1) { // select가 1인 경우 원의 넓이를 구하는 메서드를 실행합니다.
                choice = 1; // choice 변수에 1을 저장
                System.out.println("반지름을 입력하세요 : ");
                int radius = sc.nextInt(); // radius 변수에 스캐너로 입력받은 값을 저장
                double result = calculator.calculateCircleArea(radius); // calculateCircleArea 메서드를 통해 원의 넓이를 계산합니다.
                System.out.println("결과 : " + result); // calculateCircleArea 메서드를 통해 계산 결과를 콘솔에 출력합니다.
            }

            if (select == 2) { // select가 2인 경우 사칙연산을 실행합니다.
                choice = 2; // choice 변수에 2를 저장
                System.out.println("사칙연산을 시작합니다.");

                System.out.println("첫 번째 숫자를 입력하세요 : ");
                int num1 = sc.nextInt();

                System.out.println("두 번째 숫자를 입력하세요 : ");
                int num2 = sc.nextInt();

                System.out.println("사칙연산자를 입력하세요 : ");
                char operator = sc.next().charAt(0); // charAt(0)을 통해 문자열의 첫번째 문자를 가져옴 , chrAt은 문자열의 인덱스를 가져오는 메서드

                try {
                    int result = calculator.calculate(num1, num2, operator); // int result에 calculate 메서드를 통해 계산 결과 값을 저장
                    System.out.println("결과 : " + result); // calculate 메서드를 통해 계산 결과를 콘솔에 출력합니다.
                } catch (ArithmeticException e) {
                    System.out.println("에러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 ArithmeticException 메세지를 가져와서 에러메세지를 출력!!
                } catch (IllegalArgumentException e) {
                    System.out.println("에러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 IllegalArgumentException 메세지를 가져와서 에러메세지를 출력!!
                }

            } // if문 종료

            if (choice == 1) { // choice 가 1인 경우 원의 넓이와 관련된 배열이나 명령어를 실행합니다.
                ArrayList<Double> list = calculator.getCircleArea(); // getCircleArea 메서드로 배열을 가져옵니다 , 이렇게 한다면 다른 클래스에서도 list 배열을 가져올 수 있습니다.
                System.out.println("리스트 배열에 저장된 값: " + list); // 리스트 배열에 저장된 값을 출력

                System.out.println("더 계산하시겠습니까? 아무키나 입력해주세요 (exit 입력 시 종료 , inquiry 입력 시 조회 ,  remove 입력 시 맨 앞리스트만 삭제) : ");
                String answer = sc.next(); //  스트링 answer에 스캐너로 입력받은 값을 저장
                // 명령어가 아닌 아무키나 입력받는다면 계속해서 계산합니다

                if (answer.equalsIgnoreCase("exit")) {// answer.equalsIgnoreCase("exit")로 입력받은 값이 exit인 경우 프로그램을 종료합니다,
                    break;
                } else if (answer.equalsIgnoreCase("inquiry")) { // answer.equalsIgnoreCase("inquiry")로 입력받은 값이 inquiry인 경우 리스트 배열에 저장된 값을 조회합니다.
                    calculator.inquiryCircleArea(); // inquiryCircleArea 메서드를 호출하여 리스트 배열에 저장된 값을 조회합니다.
                } else if (answer.equalsIgnoreCase("remove")) { // answer.equalsIgnoreCase("remove")로 입력받은 값이 remove인 경우 리스트 배열에 저장된 맨 앞의 값을 삭제합니다.
                    calculator.removeFirstCircleArea(); // removeFirstCircleArea 메서드를 호출하여 리스트 배열에 저장된 맨 앞의 값을 삭제합니다.
                }
            } // if문 종료

            if (choice == 2) { // choice 가 2인 경우 사칙연산과 관련된 배열이나 명령어를 실행합니다.
                ArrayList<Integer> list = calculator.getList(); // getList 메서드로 배열을 가져옵니다 , 이렇게 한다면 다른 클래스에서도 list 배열을 가져올 수 있습니다.
                System.out.println("리스트 배열에 저장된 값: " + list); // 리스트 배열에 저장된 값을 출력

                System.out.println("더 계산하시겠습니까? 아무키나 입력해주세요 (exit 입력 시 종료 , inquiry 입력 시 조회 ,  remove 입력 시 맨 앞리스트만 삭제) : ");
                String answer = sc.next(); //  스트링 answer에 스캐너로 입력받은 값을 저장
                // 명령어가 아닌 아무키나 입력받는다면 계속해서 계산합니다

                if (answer.equalsIgnoreCase("exit")) {// answer.equalsIgnoreCase("exit")로 입력받은 값이 exit인 경우 프로그램을 종료합니다,
                    /*
                     * answer.equalsIgnoreCase()는 대소문자를 구분하지 않고 비교하고 싶을 때 사용합니다.
                     * 대소문자 비교가 필요없다면 equals...()를 사용하면 됩니다.
                     *answer은 스트링이기 때문에 equals...()를 사용하여 비교할 수 있습니다.
                     */
                    break;
                } else if (answer.equalsIgnoreCase("inquiry")) { // answer.equalsIgnoreCase("inquiry")로 입력받은 값이 inquiry인 경우 리스트 배열에 저장된 값을 조회합니다.
                    calculator.inquiryList(); // inquiryList 메서드를 호출하여 리스트 배열에 저장된 값을 조회합니다.
                } else if (answer.equalsIgnoreCase("remove")) { // answer.equalsIgnoreCase("remove")로 입력받은 값이 remove인 경우 리스트 배열에 저장된 맨 앞의 값을 삭제합니다.
                    calculator.removeFirstList(); // removeFirstList 메서드를 호출하여 리스트 배열에 저장된 맨 앞의 값을 삭제합니다.
                }
            } // if문 종료

        } // while문 종료

        sc.close(); // 스캐너 종료
        /*
         * 스캐너 종료가 맨 마지막에 있는 이유는 스캐너를 사용하고 난 뒤에는 반드시 닫아주어야 하기 때문입니다.
         * 닫아주지 않는다면 메모리 누수가 발생할 수 있습니다. 이런 방식의 메모리 누수는 프로그램이 종료될 때까지 계속해서 누적되어 쌓이게 됩니다.
         *  즉, 루트 밖에 마지막에 스캐너 종료가 맨 마지막에 있는 이유는 스캐너를 사용 한 후 리소스를 반환하여 메모리 누수를 방지하기 위함입니다.
         */
    } //  main 메서드 종료 ( 괄호 위치 확인용 주석 )
} // App 클래스 종료 ( 괄호 위치 확인용 주석 )
