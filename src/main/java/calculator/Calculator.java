// SPR을 통해 책임을 분리시킨 클래스들을 상속받아 사칙연산을 수행하는 클래스

package calculator;

import java.util.ArrayList;

public class Calculator {
    protected ArrayList<Double> list; // 사칙연산 결과를 저장하는 리스트

    protected AddOperator addOperator;
    protected SubtractOperator subtractOperator;
    protected MultiplyOperator multiplyOperator;
    protected DivideOperator divideOperator;

    // protected 접근 제어자를 사용하여 새로 생성한
    // AddOperator, SubtractOperator, MultiplyOperator, DivideOperator 클래스를 상속받는 클래스에서 접근할 수 있도록 합니다.

    public Calculator() {
        this.list = new ArrayList<>();
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();

        // AddOperator, SubtractOperator, MultiplyOperator, DivideOperator 클래스의 인스턴스를 생성합니다.

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
