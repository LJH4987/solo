/**
 * 스캐너를 통해서 콘솔 창에 숫자와 사칙연산자를 입력 받고 마지막에 결과를 반환합니다.
 * 값을 무한히 저장하고 출력하기 위해 ArrayList를 사용했습니다
 * remove를 추가하여 리스트의 맨 앞에 있는 값을 삭제하고 메세지를 통해 보다 이해하기쉽게 만들었습니다.
 * 매서드란 클래스 내부에 구현된 함수를 의미합니다. 예시) public int calculate(int num1, int num2, char operator) { }
 * = 해석하면 public 접근제어자를 가진 반환타입이 int이고 calculate라는 이름을 가진 매개변수로 num1, num2, operator를 받는 함수를 의미합니다.
 * 임포트한 calculator.Calculator를 통해 calculate 클래스를 사용해 계산을 하고 결과를 출력합니다.
 */

import java.util.Scanner; // 스캐너를 사용하기 위한 임포트
import java.util.ArrayList; // ArrayList를 사용하기 위해 임포트
import calculator.Calculator; // Calculator 클래스를 사용하기 위해 임포트

public class App {
    public static void main(String[] args) { // 메인이 될 메서드

        Calculator calculator = new Calculator(); // 해석하면  Calculator calculator = new Calculator(); -> calculator 클래스사용을 위한 새로운 객체를 생성합니다.
        // 해당 객체를 통해 Calculator 클래스의 메서드를 사용할 수 있습니다.
        // 이 코드가 없다면 Calculator 클래스의 메서드를 사용할 수 없습니다.
        // 이러한 분리 작업을 통해 코드의 가독성을 높이고 유지보수를 용이하게 합니다.
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
            } catch (ArithmeticException e) {
                System.out.println("에러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 ArithmeticException 메세지를 가져와서 에러메세지를 출력!!
            } catch (IllegalArgumentException e) {
                System.out.println("에러 발생 : " + e.getMessage()); // getMessage() 메서드를 통해 throw한 IllegalArgumentException 메세지를 가져와서 에러메세지를 출력!!
            }

            ArrayList<Integer> list = calculator.getList(); // getList 메서드로 배열을 가져옵니다 , 이렇게 한다면 다른 클래스에서도 list 배열을 가져올 수 있습니다.
            System.out.println("리스트 배열에 저장된 값: " + list); // 리스트 배열에 저장된 값을 출력

            System.out.println("더 계산하시겠습니까? 아무키나 입력해주세요 (exit 입력 시 종료 , inquiry 입력 시 조회 ,  remove 입력 시 맨 앞리스트만 삭제) : ");
            String answer = sc.next(); //  스트링 answer에 스캐너로 입력받은 값을 저장
            // 명령어가 아닌 아무키나 입력받는다면 계속해서 계산합니다
            if (answer.equalsIgnoreCase("exit")) {// answer.equalsIgnoreCase("exit")로 입력받은 값이 exit인 경우 프로그램을 종료합니다,
                // answer.equalsIgnoreCase()는 대소문자를 구분하지 않고 비교하고 싶을 때 사용합니다.
                // 대소문자 비교가 필요없다면 equals...()를 사용하면 됩니다.
                //answer은 스트링이기 때문에 equals...()를 사용하여 비교할 수 있습니다.
                break;
            } else if (answer.equalsIgnoreCase("inquiry")) { // answer.equalsIgnoreCase("inquiry")로 입력받은 값이 inquiry인 경우 리스트 배열에 저장된 값을 조회합니다.
                System.out.println("리스트 배열에 저장된 값: " + list);
            } else if (answer.equals("remove")) {
                if (!list.isEmpty()) { // = !list.isEmpty()를 통해 리스트 배열에 저장된 값이 없는 경우,
                    // isEmpty()는 리스트 배열이 비어있는지 확인하는 메서드 엠티 = 비어있다 = !부정.리스트.비어있다 리스트가 비어있는지에 대한 조건
                    System.out.println("리스트 배열에 저장된 값: " + list.get(0) + " 가 삭제되었습니다.");
                    list.remove(0); // 리스트 배열에 저장된 맨 앞의 값을 삭제합니다.
                    // 만약 리스트 맨 앞의값이 아닌 다른값을 삭제시키고 싶다면 list.remove(0)을 list.remove(1)로 변경하면 됩니다.
                    // 즉, 안에 숫자는 인덱스를 의미합니다.
                    calculator.setList(list); // setList 메서드를 통해 리스트 배열을 변경합니다.
                    // 이코드가 없다면 리스트 배열에 저장된 값이 삭제되지 않습니다.
                    // 이코드의 존재 이유는 list.remove(0)을 통해 리스트 배열에 맨 앞에 저장된 값을 삭제하고 변경된 리스트 배열을 가져오기 위함입니다.
                    System.out.println("리스트 배열에 저장된 값: " + list);
                } else {
                    System.out.println("리스트 배열에 저장된 값이 없습니다.");
                }
            }
        }
        sc.close(); // 스캐너 종료가 맨 마지막에 있는 이유는 스캐너를 사용하고 난 뒤에는 반드시 닫아주어야 하기 때문입니다.
        // 닫아주지 않는다면 메모리 누수가 발생할 수 있습니다. 이런 방식의 메모리 누수는 프로그램이 종료될 때까지 계속해서 누적되어 쌓이게 됩니다.
        // 즉, 루트 밖에 마지막에 스캐너 종료가 맨 마지막에 있는 이유는 스캐너를 사용 한 후 리소스를 반환하여 메모리 누수를 방지하기 위함입니다.
    }
}
