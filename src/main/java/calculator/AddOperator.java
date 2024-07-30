// 해당 클래스는 덧셈을 담당하는 클래스

package calculator;

public class AddOperator implements Operator<Number> {
    @Override
    public boolean supports(char operator) {
        return operator == '+';
    }

    @Override
    public Number apply(Number num1, Number num2) {
        if (num1 instanceof Double || num2 instanceof Double) {
            return num1.doubleValue() + num2.doubleValue();
        } else {
            return num1.intValue() + num2.intValue();
        }
    }
}

/*
*  public Number apply(Number num1, Number num2) {
*   if (num1 instanceof Double || num2 instanceof Double) {
*   return num1.doubleValue() + num2.doubleValue();
*   } else {
*   return num1.intValue() + num2.intValue();
*  }
*  위와 같은 방식으로 변경하여 if 문을 통해 num1와 num2가 실수인지 정수인지 구분하여 연산합니다
*  if 문에서 비교 연산자를 통해 num1과 num2가 실수인지 정수인지 구분하고
*  실수라면 doubleValue() 메소드를 통해 실수로 변환하고, 정수라면 else로 이동하여 intValue() 메소드를 통해 정수로 변환합니다.
*  다른 연산관련 클래스들도 이방법으로 변경하여 연산을 진행함으로 정수와 실수를 구분하여 연산합니다
*/
