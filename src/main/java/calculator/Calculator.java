// 해당 클래스는 계산기의 기본적인 기능을 제공하는 클래스입니다.
// 기능 = 리스트 배열에 값을 저장하는 기능(setList),
// 리스트 배열의 맨 앞의 값을 삭제하는 기능(removeFirstList),
// 리스트 배열에 저장된 값을 조회하는 기능(inquiryList)을 담당합니다.

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

    public void removeFirstList() {
        if (!list.isEmpty()) {
            System.out.println("리스트 배열의 맨 앞의 값이 삭제되었습니다. 삭제된 값 : " + list.get(0));
            list.remove(0);
            System.out.println("현재 리스트 배열에 저장된 값 : " + list);
        } else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!");
        }
    }

    public void inquiryList() {
        if (!list.isEmpty()) {
            System.out.println("리스트 배열에 저장된 값 : " + list);
        } else {
            System.out.println("리스트 배열에 저장된 값이 없습니다!!!");
        }
    }
}
