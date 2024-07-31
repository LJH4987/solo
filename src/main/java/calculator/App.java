// 현재 문제점 및 개선해야할 사항
// 사칙연산 개산부터 구현하느라 원의 넓이 계산을 구현하지 못해, 별도의 버튼을 만들어서 원의 넓이 계산을 구현하는 등의 방식을 취해야할것같습니다.
// 계산기의 버튼을 누를 때마다 버튼의 색상이 변하는데, 버튼을 누르고 떼었을 때 색상이 변하는 것이 아니라 버튼을 누르는 순간 색상이 변하도록 수정해야할 것으로 보입니다
// 디스플레이창에 출력된 값이 너무 늘어나면 화면에 표시되지 않는 문제, 디스플레이창에 출력된 값이 일정 길이 이상이 되면 자동으로 줄어들도록 수정하거나 스크롤바, 혹은 입력 제한을 두는 방식 등등 고민해봐야할것같습니다.
// 그 외에도 이전 레벨에 배열의 조회,추가,삭제 등 기능을 구현했던 것처럼 추가적인 버튼이나 다른 방법을 강구해서 구현해야할 것으로 보입니다.
// 별도) 그 외 이전 레벨에서 숫자가 아닌 문자를 입력했을 때 일부 예외처리가 소홀하여 에러가 발생하는 문제가 있었는데, 마지막까지 콘솔에서 띄우는 방식이였다면 보완했어야했었습니다.


package calculator;

import javax.swing.*; // Swing 라이브러리를 통해 GUI 구현을 위한 import
import java.awt.*; // AWT 라이브러리를 통해 GUI 구현을 위한 import
import java.awt.event.ActionEvent; // ActionEvent 클래스를 사용하기 위한 import / 버튼 클릭 이벤트
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; // MouseAdapter, MouseEvent 클래스를 사용하기 위한 import / 마우스 클릭 이벤트

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp app = new CalculatorApp();
            app.setVisible(true);
        });
    }
}

class CalculatorApp extends JFrame {
    private JTextField display;
    private ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
    private CircleCalculator circleCalculator = new CircleCalculator(); // 원의 넓이
    private String operator = "";
    private double num1, num2;

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // 크기 고정

        display = new JTextField();
        display.setBounds(1, 45, 288, 65);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(new Color(204, 220, 221)); // 배경색을 설정 (RGB: 204, 220, 221)
        display.setForeground(new Color(0, 0, 0)); // 텍스트 색상을 설정 (RGB: 0, 0, 0)
        add(display);

        String[] buttonImages = {
                "src/main/resources/img/7.png", "src/main/resources/img/8.png", "src/main/resources/img/9.png", "src/main/resources/img/C.png",
                "src/main/resources/img/4.png", "src/main/resources/img/5.png", "src/main/resources/img/6.png", "src/main/resources/img/percent.png",
                "src/main/resources/img/1.png", "src/main/resources/img/2.png", "src/main/resources/img/3.png", "src/main/resources/img/divide.png",
                "src/main/resources/img/0.png", "src/main/resources/img/dot.png", "src/main/resources/img/equals.png", "src/main/resources/img/plus.png",
                "src/main/resources/img/minus.png", "src/main/resources/img/multiply.png"
        };

        String[] buttonCommands = {
                "7", "8", "9", "C",
                "4", "5", "6", "%",
                "1", "2", "3", "/",
                "0", ".", "=", "+",
                "-", "*"
        };

        int[] buttonX = {
                30, 90, 150, 220,
                30, 90, 150, 220,
                30, 90, 150, 220,
                30, 90, 150, 220,
                220, 220
        };

        int[] buttonY = {
                200, 200, 200, 170,
                260, 260, 260, 220,
                320, 320, 320, 260,
                380, 380, 380, 320,
                375, 420
        };

        JButton[] buttons = new JButton[buttonImages.length];

        for (int i = 0; i < buttonImages.length; i++) {
            buttons[i] = new JButton(new ImageIcon(buttonImages[i]));
            buttons[i].setBounds(buttonX[i], buttonY[i], 50, 50);
            buttons[i].setActionCommand(buttonCommands[i]);
            buttons[i].setBorderPainted(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setFocusPainted(false);
            buttons[i].setOpaque(false);
            buttons[i].addActionListener(new ButtonClickListener());


            final int index = i;
            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buttons[index].setBackground(Color.LIGHT_GRAY);
                    buttons[index].setOpaque(true);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    buttons[index].setBackground(null);
                    buttons[index].setOpaque(false);
                }
            });

            add(buttons[i]);
        }

        JLabel background = new JLabel(new ImageIcon("src/main/resources/img/background.png"));
        background.setBounds(0, 0, 300, 500);
        add(background);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.isEmpty()) {
                return;
            }
            if (command.charAt(0) == 'C') {
                display.setText("");
                operator = "";
                num1 = num2 = 0;
            } else if (command.charAt(0) == '=') {
                num2 = Double.parseDouble(display.getText());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = arithmeticCalculator.calculate(num1, num2, '+');
                        break;
                    case "-":
                        result = arithmeticCalculator.calculate(num1, num2, '-');
                        break;
                    case "*":
                        result = arithmeticCalculator.calculate(num1, num2, '*');
                        break;
                    case "/":
                        result = arithmeticCalculator.calculate(num1, num2, '/');
                        break;
                    case "%":
                        result = arithmeticCalculator.calculate(num1, num2, '%');
                        break;
                }
                display.setText("" + result);
                operator = "";
                num1 = num2 = 0;
            } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("%")) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            } else {
                display.setText(display.getText() + command);
            }
        }
    }
}

/*
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
*/