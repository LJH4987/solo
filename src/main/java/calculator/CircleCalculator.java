// 해당 클래스는 Calculator 클래스를 상속받아 원의 넓이를 계산하는 클래스입니다.
// 원의 넓이를 계산하는 calculateCircleArea 메소드를 구현하고, 해당 메소드를 호출할 때마다 계산된 원의 넓이를 리스트 배열에 저장합니다.

package calculator;

public class CircleCalculator extends Calculator {
    private static final double PI = 3.14;

    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        list.add(area);
        return area;
    }
}
