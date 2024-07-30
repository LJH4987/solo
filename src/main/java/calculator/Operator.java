// 해당 인터페이스는 각 클래스들의 오버라이딩을 통해 연산자를 구현합니다.
// 각 클래스들은 Operator 인터페이스를 구현하여 연산자를 구현합니다.


package calculator;

public interface Operator {
    boolean supports(char operator);
    double apply(double num1, double num2);
}
/*
*이 코드는 Operator 인터페이스를 정의하며 supports 메서드와 apply 메서드를 선언합니다.
* supports 메서드는 연산자를 받아 해당 연산자를 지원하는지 여부를 반환하고,
* apply 메서드는 두 개의 숫자를 받아 해당 연산자를 적용한 결과를 반환합니다.
* 이를 통해 Operator로 오버라이딩을 통해 각 연산자를 구현하는 클래스들은 supports와 apply 메서드를 구현해야 합니다.
* */