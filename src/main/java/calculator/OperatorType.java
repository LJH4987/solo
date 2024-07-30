package calculator;

public enum OperatorType {
    ADD('+'), // 덧셈
    SUBTRACT('-'), // 뺄셈
    MULTIPLY('*'), // 곱셈
    DIVIDE('/'), // 나눗셈
    MOD('%'); // 나머지

    private final char symbol; // 연산자 기호를 final로 선언하여 변경불가능한 symbol 변수를 선언

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorType fromSymbol(char symbol) {
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원되지 하지않는 연산자앙너ㅏㅇㅋ타ㅣ러!!! : " + symbol);
    }
}

// Enum 타입을 활용해 ArithmeticCalculator 클래스에서 연산자를 찾아내고, 연산자를 찾아내서 해당 연산자를 실행합니다.
// 연산자를 찾아내는 과정에서 연산자가 없다면 IllegalArgumentException(에러)을 발생시킵니다.
// for 문을 통해 순회하묘 연산자를 찾아내고, 연산자를 찾아내서 해당 연산자를 실행합니다.
// 머리아파요 사ㅓㄹ려주세요
