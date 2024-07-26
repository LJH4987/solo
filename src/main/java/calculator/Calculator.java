package calculator;

import java.util.ArrayList;

public class Calculator { // Calculator 클래스를 생성

    private ArrayList<Integer> list; // private로 선언된 리스트 배열을 생성합니다.
    /* 생성자가 있기 때문에 static을 사용하지 않아도 됩니다.
    * static은 클래스 변수로 클래스가 로딩될 때 메모리에 할당되고 프로그램이 종료될 때까지 메모리에 남아있는 변수를 사용합니다.
    * 이전에는 static을 사용하여 메모리에 할당되어 프로그램이 종료될 때까지 메모리에 남아있는 변수를 사용했지만,
    * 이번에는 생성자를 사용하여 객체를 생성하여 메모리에 할당하고 프로그램이 종료될 때 메모리에서 해제되는 방식을 사용합니다.
    * 이 방법을 통해 보다 효율적인 메모리 사용이 가능합니다.
    *  private ArrayList<Integer> list; = private로 선언하여 다른 클래스에서 접근하지 못하고 getter와 setter를 사용하여 간접 접근이 가능한 list 배열을 만듭니다.
    * (요약 : static은 종료시에 메모리에 남지만 생성자는 종료시에 메모리에서 해제됩니다.)
    */
    public Calculator() { // 생성자 생성.
        this.list = new ArrayList<>(); // 생성자를 통해 리스트 배열을 초기화합니다.
        /* 생성자 = 클래스명과 돌일한 이름을 가지고 있는 객체이며 생성 시 호출되는 메서드로 객체를 초기화하는 역할을 합니다.
        * 이렇게 생성자를 사용해 객체를 초기화하는 이유는 객체를 생성할 때 필드를 초기화하기 위함입니다.
        * 생성자는 반환 타입이 없고 클래스명과 동일한 이름을 가지고 있습니다.
        * 이런방식으로 필드를 초기화 한다면 다른 클래스에서도 필드를 가져와 사용할 수 있습니다.
        * 다른 클래스 필드 가져오는 예시 : app에서 사용 시 list.add(result)를 사용하여 리스트 배열에 저장된 연산 결과 값을 가져올 수 있습니다.
        * 이 생성자가 없다면 예시 : app에서 사용 시 list.add(result)를 사용하여 리스트 배열에 저장된 연산 결과 값을 가져올 수 없습니다.
        * 시도할 경우 에러가 발생합니다.
        */

    }

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

    // 요구사항을 구현하기 app 클래스의 메인에서 사용할수있는 리스트 맨 앞의 값을 삭제하는 메서드를 추가
    public void removeFirstList() { //
        // public void public void removeFirstList() { //() { // 반환 타입 : void ,     public void removeFirstList() { // = 리스트 배열의 맨 앞의 값을 삭제 , 매개변수 : 없음 ,
        // 반환 값 : 없음 , 반환값과 매개변수가 없는 이유는 리스트 배열의 맨 앞의 값을 삭제하기만 하기 때문입니다.
        //매개변수란 메서드를 호출할 때 전달하는 값입니다.
        // 이 경우에는 호출을 할 때 전달하는 값이 없기 때문에 매개변수가 없습니다.
        if (!list.isEmpty()) { // 조건 : 리스트 배열에 저장된 값이 없는 경우가 아닌 경우, !가 부정을 의미하기 떄문에 리스트 배열에 저장된 값이 있는 경우입니다.
            // isEmpty()는 리스트 배열이 비어있는지 확인하는 메서드 엠티 = 비어있다 = !부정.리스트.비어있다 리스트가 비어있는지에 대한 조건
            System.out.println("리스트 배열의 맨 앞의 값이 삭제되었습니다. 삭제된 값 : " + list.get(0)); // 리스트 배열의 맨 앞의 값이 삭제된 경우
            list.remove(0); // 리스트 배열에 저장된 맨 앞의 값을 삭제합니다.
            // 만약 리스트 맨 앞의값이 아닌 다른값을 삭제시키고 싶다면 list.remove(0)을 list.remove(1)로 변경
            // 즉, 안에 숫자는 인덱스를 의미합니다.
            System.out.println("현재 리스트 배열에 저장된 값: " + list); // 리스트 배열에 저장된 값을 출력합니다.
        }
        else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!"); // 리스트 배열에 저장된 값이 없는 경우
        }
    }

    public void inquiryList() { // 리스트 배열에 저장된 값을 조회하는 메서드를 추가
        // public void inquiryList() { // 반환 타입 : void , inquiryList = 리스트 배열에 저장된 값을 조회 , 매개변수 : 없음 ,
        // 반환 값 : 없음 , 반환값과 매개변수가 없는 이유는 리스트 배열에 저장된 값을 조회하기만 하기 때문입니다.
        if (!list.isEmpty()) { // 조건 : 리스트 배열에 저장된 값이 없는 경우가 아닌 경우, !가 부정을 의미하기 떄문에 리스트 배열에 저장된 값이 있는 경우입니다.
            // isEmpty()는 리스트 배열이 비어있는지 확인하는 메서드 엠티 = 비어있다 = !부정.리스트.비어있다 리스트가 비어있는지에 대한 조건
            System.out.println("리스트 배열에 저장된 값: " + list); // 리스트 배열에 저장된 값을 출력합니다.
        }
        else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!"); // 리스트 배열에 저장된 값이 없는 경우
        }
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
        // integer = 정수 데이터를 저장하는 변수 타입 int와 차이점은 int는 기본 데이터 타입이고 integer는 참조 데이터 타입입니다.
        //참조 데이터는 객체를 참조하는 데이터 타입이고 객체를 참조하는 데이터 타입이기 때문에 객체를 생성해야 사용할 수 있습니다.
        // 즉 , int는 객체를 생성하지 않아도 사용할 수 있지만 integer는 객체를 생성해야 사용할 수 있습니다.
        this.list = list; // 리스트 배열을 변경합니다.
        // app에서 사용시 list.remove(0)을 사용하여 리스트 배열에 저장된 0,1,2,3과같은 수를 입력하여 인덱스 값에 따라 삭제할 수 있습니다.
    }

// 배열을 변경하고 적용하기위해 removeFirstList()를 먼저 호출하고 setList()를 호출하여 변경된 리스트 배열을 가져옵니다.

}

