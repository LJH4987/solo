// SPR을 통해 책임을 분리시킨 클래스들을 상속받아 사칙연산을 수행하는 클래스

package calculator;

import java.util.ArrayList;

public class Calculator {
    protected ArrayList<Double> list;

    public Calculator() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Double> getList() {
        return list;
    }

    public void setList(ArrayList<Double> list) {
        this.list = list;
    }

    public void inquiryList() {
        if (!list.isEmpty()) {
            System.out.println("리스트 배열에 저장된 값 : " + list);
        } else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!");
        }
    }

    public void removeFirstList() {
        if (!list.isEmpty()) {
            System.out.println("리스트 배열의 맨 앞의 값이 삭제되었습니다. 삭제된 값 : " + list.get(0));
            list.remove(0);
            System.out.println("현재 리스트 배열에 저장된 값 : " + list);
        } else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!");
        }
    }
}