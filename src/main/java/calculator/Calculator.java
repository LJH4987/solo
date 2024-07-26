package calculator;

import java.util.ArrayList;

public class Calculator { // Calculator 클래스를 생성

    private static ArrayList<Integer> list = new ArrayList<>(); // 임포트한 ArrayList를 사용하여 계산 결과를 저장할 리스트 배열을 생성합니다.

    // 사칙연산 메서드
    public int calculate(int num1, int num2, char operator) { // 반환 타입은 int로 설정하고 매개변수로 num1, num2, operator(연산자)를 받습니다.
        // private로 선언하는 이유는 다른 클래스에서 접근하지 못하도록 하기 위함입니다.
        // 다른 클래스에서 접근하지 못하도록 한다면 getter와 setter를 사용하여 간접 접근을 통해 필드에 접근할 수 있도록 구현할 수 있습니다.
        // 그래서하단에 getter와 setter를 추가해줍니다.
        int result = 0; // 연산 후 값을 저장할 변수
        // 요구사항에 맞게 throw로 예외처리를 해주기위해 error 변수는 필요없어요

        // 입력받은 사칙연산자에 맞게 계산 및 결과를 출력하고 사칙연산자가 아닌 경우 혹은 연산 오류에는 오류 메시지를 출력합니다.
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) { // 두번째 입력을 0으로 받았을 때 예외처리
                throw new ArithmeticException("0으로 나눌 수 없습니다!"); // 0으로 나눌 수 없는 경우 예외처리 , 요구사항에 맞게 throw로 예외처리를 해줍니다.
                // ArithmeticException : 숫자 연산 오류를 처리해주는 예외처리 클래스
            } else { // 0으로 나누지 않은 경우 정상 실행
                result = num1 / num2;
            }
        } else {
            throw new IllegalArgumentException("사칙연산자가 아닙니다!"); // 사칙연산자가 아닌 경우 예외처리 ,
            // IllegalArgumentException : 잘못된 인수를 전달했을 때 발생하는 예외처리 클래스
        }

        list.add(result); // 연산 결과를 리스트 배열에 저장합니다. list.add(result)를 사용 시 다른 클래스에서도 list 배열에 저장된 값을 가져올 수 있습니다.
        return result; // 연산 결과를 반환합니다.
    }

    public ArrayList<Integer> getList() {
        // 요구사항을 만족하기 간접 접근을 통해 필그에 접근하여ㅑ 가져 올 수 있도록 구현하기 위해서 getter를 사용하여 리스트 배열을 가져옴
        // public ArrayList<Integer> getList() { // 반환 타입 : ArrayList<Integer> , getlist = 리스트 배열을 가져옴 , 반환 값 : list 배열
        //app에서 사용 시 list.add(result)를 사용하여 리스트 배열에 저장된 연산 결과 값을 가져올 수 있습니다.
        return list; // 리스트 배열을 반환합니다.
    }

    public void setList (ArrayList<Integer> list) {
        // 요구사항을 만족하기 간접 접근을 통해 필드에 접근하여 변경할 수 있도록 구현하기 위해서 setter를 사용하여 리스트 배열을 변경
        // public void setList(ArrayList<Integer> list) { // 반환 타입 : void , setList = 리스트 배열을 변경 , 매개변수 : list 배열
        // 반환 값 : 없음 번환 값이 없는 이유는 리스트 배열을 변경하기만 하기 때문입니다.
        this.list = list; // 리스트 배열을 변경합니다.
        // app에서 사용시 list.remove(0)을 사용하여 리스트 배열에 저장된 0,1,2,3과같은 수를 입력하여 인덱스 값에 따라 삭제할 수 있습니다.
    }

}

