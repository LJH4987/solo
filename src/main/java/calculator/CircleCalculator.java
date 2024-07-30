// 해당 클래스는 Calculator 클래스를 상속받아 원의 넓이를 계산하는 클래스입니다.
// 원의 넓이를 계산하는 calculateCircleArea 메소드를 구현하고, 해당 메소드를 호출할 때마다 계산된 원의 넓이를 리스트 배열에 저장합니다.

package calculator;

import java.util.ArrayList;

public class CircleCalculator extends Calculator {
    private static final double PI = 3.14;
    private ArrayList<Double> circleAreaList;

    public CircleCalculator() {
        this.circleAreaList = new ArrayList<>();
    }

    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        circleAreaList.add(area);
        return area;
    }

    public ArrayList<Double> getCircleAreaList() {
        return circleAreaList;
    }

    public void setCircleAreaList(ArrayList<Double> circleAreaList) {
        this.circleAreaList = circleAreaList;
    }

    public void inquiryCircleAreaList() {
        if (!circleAreaList.isEmpty()) {
            System.out.println("리스트에 저장된 값 : " + circleAreaList);
        } else {
            System.out.println("리스트에 저장된 값이 없습니다!!!");
        }
    }

    public void removeFirstCircleArea() {
        if (!circleAreaList.isEmpty()) {
            System.out.println("리스트의 맨 앞의 값이 삭제되었습니다. 삭제된 값 : " + circleAreaList.get(0));
            circleAreaList.remove(0);
            System.out.println("현재 리스트에 저장된 값 : " + circleAreaList);
        } else {
            System.out.println("리스트에 저장된 값이 없습니다!!!");
        }
    }
}