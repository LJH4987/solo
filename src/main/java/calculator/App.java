/*
 * 추가적인 클래스 구현을 통한 상속과 다형성 과정에서 공부하면서 작성한 주석떄문에 너무 코드가 복잡해보여져서
 * 주석을 제거 또는 최소화하고 코드를 간결하게 수정하였습니다.
 */

package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("원의 넓이를 구하려면 1번, 사칙연산을 하려면 2번을 입력하세요:");
            int select = sc.nextInt();

            if (select == 1) {
                System.out.println("반지름을 입력하세요:");
                double radius = sc.nextDouble();
                double result = circleCalculator.calculateCircleArea(radius);
                System.out.println("결과: " + result);
            } else if (select == 2) {
                System.out.println("첫 번째 숫자를 입력하세요:");
                double num1 = sc.nextDouble();
                System.out.println("두 번째 숫자를 입력하세요:");
                double num2 = sc.nextDouble();
                System.out.println("사칙연산자를 입력하세요 (+, -, *, /, %):");
                char operator = sc.next().charAt(0);

                try {
                    double result = arithmeticCalculator.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("에러 발생: " + e.getMessage());
                }
            }

            System.out.println("계속하려면 아무 키나 누르세요. 종료하려면 exit를 입력하세요:");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("명령어를 입력하세요 아무키나 누르면 첫 계산으로 돌아갑니다. (조회: inquiry, 리스트 맨 앞 삭제: remove, 리스트 배열 추가: newlist, 리스트 초기화: setlist):");
                String command = sc.next();

                switch (command.toLowerCase()) {
                    case "inquiry":
                        System.out.println("어떤 리스트를 조회하시겠습니까? (arithmetic: 사칙연산 결과, circle: 원의 넓이 결과):");
                        String listType = sc.next();
                        if (listType.equalsIgnoreCase("arithmetic")) {
                            System.out.println("조회 조건을 입력하세요 (all: 모든 결과, greater: 값보다 큰 결과, range: 범위 내 결과, equal: 값과 같은 결과, less: 값보다 작은 결과):");
                            String queryType = sc.next();
                            if (queryType.equalsIgnoreCase("all")) {
                                arithmeticCalculator.inquiryList();
                            } else {
                                System.out.println("기준 값을 입력하세요:");
                                double value = sc.nextDouble();

                                switch (queryType.toLowerCase()) {
                                    case "greater":
                                        System.out.println("조회 결과: " + arithmeticCalculator.findResultsGreaterThan(value));
                                        break;
                                    case "range":
                                        System.out.println("최소 값을 입력하세요:");
                                        double min = sc.nextDouble();
                                        System.out.println("최대 값을 입력하세요:");
                                        double max = sc.nextDouble();
                                        System.out.println("조회 결과: " + arithmeticCalculator.findResultsInRange(min, max));
                                        break;
                                    case "equal":
                                        System.out.println("조회 결과: " + arithmeticCalculator.findResultsEqualTo(value));
                                        break;
                                    case "less":
                                        System.out.println("조회 결과: " + arithmeticCalculator.findResultsLessThan(value));
                                        break;
                                    default:
                                        System.out.println("잘못된 조회 조건입니다.");
                                }
                            }
                        } else if (listType.equalsIgnoreCase("circle")) {
                            circleCalculator.inquiryCircleAreaList();
                        } else {
                            System.out.println("잘못된 리스트 타입입니다.");
                        }
                        break;
                    case "remove":
                        System.out.println("어떤 리스트의 맨 앞 값을 삭제하시겠습니까? (arithmetic: 사칙연산 결과, circle: 원의 넓이 결과):");
                        String removeType = sc.next();
                        if (removeType.equalsIgnoreCase("arithmetic")) {
                            arithmeticCalculator.removeFirstList();
                        } else if (removeType.equalsIgnoreCase("circle")) {
                            circleCalculator.removeFirstCircleArea();
                        } else {
                            System.out.println("잘못된 리스트 타입입니다.");
                        }
                        break;
                    case "newlist":
                        System.out.println("어떤 리스트에 값을 추가하시겠습니까? (arithmetic: 사칙연산 결과, circle: 원의 넓이 결과):");
                        String newListType = sc.next();
                        if (newListType.equalsIgnoreCase("arithmetic")) {
                            System.out.println("새로운 값을 추가하세요. 끝내려면 'exit'을 입력하세요.");
                            while (true) {
                                String newValue = sc.next();
                                if (newValue.equalsIgnoreCase("exit")) {
                                    break;
                                }
                                try {
                                    double valueToAdd = Double.parseDouble(newValue);
                                    arithmeticCalculator.getList().add(valueToAdd);
                                    System.out.println("값이 추가되었습니다.");
                                } catch (NumberFormatException e) {
                                    System.out.println("유효한 숫자를 입력해주세요!!");
                                }
                            }
                        } else if (newListType.equalsIgnoreCase("circle")) {
                            System.out.println("새로운 값을 추가하세요. 끝내려면 'exit'을 입력하세요.");
                            while (true) {
                                String newValue = sc.next();
                                if (newValue.equalsIgnoreCase("exit")) {
                                    break;
                                }
                                try {
                                    double valueToAdd = Double.parseDouble(newValue);
                                    circleCalculator.getCircleAreaList().add(valueToAdd);
                                    System.out.println("값이 추가되었습니다.");
                                } catch (NumberFormatException e) {
                                    System.out.println("유효한 숫자를 입력해주세요!!");
                                }
                            }
                        } else {
                            System.out.println("잘못된 리스트 타입입니다.");
                        }
                        break;
                    case "setlist":
                        System.out.println("어떤 리스트를 초기화하시겠습니까? (arithmetic: 사칙연산 결과, circle: 원의 넓이 결과):");
                        String setListType = sc.next();
                        if (setListType.equalsIgnoreCase("arithmetic")) {
                            System.out.println("정말 초기화 하시겠습니까? 취소하려면 아무키나 누르고 정말 초기화할꺼면 exit를 누르세요:");
                            String confirmation = sc.next();
                            if (confirmation.equalsIgnoreCase("exit")) {
                                arithmeticCalculator.setList(new ArrayList<>());
                                System.out.println("리스트가 초기화되었습니다.");
                                System.out.println("현재 리스트 배열에 저장된 값 : " + arithmeticCalculator.getList());
                            } else {
                                System.out.println("리스트 초기화가 취소되었습니다.");
                            }
                        } else if (setListType.equalsIgnoreCase("circle")) {
                            System.out.println("정말 초기화 하시겠습니까? 취소하려면 아무키나 누르고 정말 초기화할꺼면 exit를 누르세요:");
                            String confirmation = sc.next();
                            if (confirmation.equalsIgnoreCase("exit")) {
                                circleCalculator.setCircleAreaList(new ArrayList<>());
                                System.out.println("리스트가 초기화되었습니다.");
                            } else {
                                System.out.println("리스트 초기화가 취소되었습니다.");
                                System.out.println("현재 리스트에 저장된 값 : " + circleCalculator.getCircleAreaList());
                            }
                        } else {
                            System.out.println("잘못된 리스트 타입입니다.");
                        }
                        break;
                    default:
                        System.out.println("잘못된 명령어를 입력하셨습니다. 처음 계산으로 돌아갑니다.");
                }
            }
        }

        sc.close();
    }
}
