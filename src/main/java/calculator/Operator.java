// 해당 인터페이스는 각 클래스들의 오버라이딩을 통해 연산자를 구현합니다.
// 각 클래스들은 Operator 인터페이스를 구현하여 연산자를 구현합니다.


package calculator;

public interface Operator<T extends Number> {
    boolean supports(char operator);
    T apply(T num1, T num2);

    // 양의 정수뿐만 아니라 실수도 연산이 가능하도록 제네릭 타입을 통해 T extends Number로 지정하여 T apply(T num1, T num2) 메소드를 구현합니다.
    // T apply의 T는 operator<T extends Number>에서 지정한 T입니다.
    // 즉,  T apply(T num1, T num2); 는 T 타입의 num1과 num2를 받아서 T 타입을 반환하는 메소드입니다.
    // 여기서 말하는 T는 Number 클래스를 상속받는 클래스들을 의미합니다.
    // extends Number = extends : 상속, Number : Number 클래스를 상속받는 클래스

}