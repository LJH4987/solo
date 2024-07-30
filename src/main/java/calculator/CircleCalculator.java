// 해당 클래스는 Calculator 클래스를 상속받아 원의 넓이를 계산하는 클래스입니다.
// 원의 넓이를 계산하는 calculateCircleArea 메소드를 구현하고, 해당 메소드를 호출할 때마다 계산된 원의 넓이를 리스트 배열에 저장합니다.

package calculator;

import java.util.ArrayList;

public class CircleCalculator extends Calculator {
    private ArrayList<Double> circleArea;

    public CircleCalculator() {
        this.circleArea = new ArrayList<>();
    }

    public double calculateCircleArea(double radius) {
        double area = Math.PI * radius * radius;
        circleArea.add(area);
        return area;
    }

    public ArrayList<Double> getCircleArea() {
        return circleArea;
    }

    public void setCircleArea(ArrayList<Double> circleArea) {
        this.circleArea = circleArea;
    }

    public void inquiryCircleArea() {
        if (!circleArea.isEmpty()) {
            System.out.println("리스트 배열에 저장된 값 : " + circleArea);
        } else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!");
        }
    }

    public void removeFirstCircleArea() {
        if (!circleArea.isEmpty()) {
            System.out.println("리스트 배열의 맨 앞의 값이 삭제되었습니다. 삭제된 값 : " + circleArea.get(0));
            circleArea.remove(0);
            System.out.println("현재 리스트 배열에 저장된 값 : " + circleArea);
        } else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!");
        }
    }
}
