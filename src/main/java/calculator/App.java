/*
 * 추가적인 클래스 구현을 통한 상속과 다형성 과정에서 공부하면서 작성한 주석떄문에 너무 코드가 복잡해보여져서
 * 주석을 제거 또는 최소화하고 코드를 간결하게 수정하였습니다.
 */

package calculator;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("원의 넓이를 구하려면 1번 , 사칙연산을 하려면 2번을 입력하세요 : ");
            int select = sc.nextInt();
            int choice = 0;

            if (select != 1 && select != 2) {
                System.out.println("1번과 2번 중에 하나만 입력해주세요!! ");
                continue;
            }

            if (select == 1) {
                choice = 1;
                System.out.println("반지름을 입력하세요 : ");
                int radius = sc.nextInt();
                double result = circleCalculator.calculateCircleArea(radius);
                System.out.println("결과 : " + result);
            }

            if (select == 2) {
                choice = 2;
                System.out.println("사칙연산을 시작합니다.");

                System.out.println("첫 번째 숫자를 입력하세요 : ");
                double num1 = sc.nextDouble();

                System.out.println("두 번째 숫자를 입력하세요 : ");
                double num2 = sc.nextDouble();

                System.out.println("사칙연산자를 입력하세요 : ");
                char operator = sc.next().charAt(0);

                try {
                    double result = arithmeticCalculator.calculate(num1, num2, operator);
                    System.out.println("결과 : " + result);
                } catch (ArithmeticException e) {
                    System.out.println("에러 발생 : " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("에러 발생 : " + e.getMessage());
                }
            }

            if (choice == 1) {
                ArrayList<Double> list = circleCalculator.getCircleArea();
                System.out.println("리스트 배열에 저장된 값: " + list);

                System.out.println("더 계산하시겠습니까? 아무키나 입력해주세요 (exit 입력 시 종료 , inquiry 입력 시 조회 ,  remove 입력 시 맨 앞리스트만 삭제 newlist 입력 시 리스트 배열 추가) : ");
                String answer = sc.next();

                if (answer.equalsIgnoreCase("exit")) {
                    break;
                } else if (answer.equalsIgnoreCase("inquiry")) {
                    circleCalculator.inquiryCircleArea();
                } else if (answer.equalsIgnoreCase("remove")) {
                    circleCalculator.removeFirstCircleArea();
                } else if (answer.equalsIgnoreCase("newlist")) {
                    ArrayList<Double> newCircleAreas = new ArrayList<>();
                    System.out.println("새로운 원의 넓이 리스트를 입력하세요 (끝내려면 exit 입력): ");
                    while (true) {
                        String endlist = sc.next();
                        if (endlist.equalsIgnoreCase("exit")) break;
                        newCircleAreas.add(Double.parseDouble(endlist));
                    }
                    circleCalculator.setCircleArea(newCircleAreas);
                    System.out.println("새로운 원의 넓이 리스트가 저장된 값 : " + newCircleAreas);
                }
            }

            if (choice == 2) {
                ArrayList<Double> list = arithmeticCalculator.getList();
                System.out.println("리스트 배열에 저장된 값: " + list);

                System.out.println("더 계산하시겠습니까? 아무키나 입력해주세요 (exit 입력 시 종료 , inquiry 입력 시 조회 ,  remove 입력 시 맨 앞리스트만 삭제 , newlist 입력 시 리스트 배열 추가) : ");
                String answer = sc.next();

                if (answer.equalsIgnoreCase("exit")) {
                    break;
                } else if (answer.equalsIgnoreCase("inquiry")) {
                    arithmeticCalculator.inquiryList();
                } else if (answer.equalsIgnoreCase("remove")) {
                    arithmeticCalculator.removeFirstList();
                } else if (answer.equalsIgnoreCase("newlist")) {
                    ArrayList<Double> newList = new ArrayList<>();
                    System.out.println("새로운 리스트를 입력하세요 (끝내려면 exit 입력): ");
                    while (true) {
                        String endlist = sc.next();
                        if (endlist.equalsIgnoreCase("exit")) break;
                        newList.add(Double.parseDouble(endlist));
                    }
                    arithmeticCalculator.setList(newList);
                    System.out.println("새로운 리스트가 저장된 값 : " + newList);
                }
            }
        }
        sc.close();
    }
}
