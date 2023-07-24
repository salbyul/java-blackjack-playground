package nextstep.blackjack;

import java.util.Arrays;

public enum Shape {
    HEART("하트", 0), DIAMOND("다이아몬드", 1), SPADE("스페이드", 2), CLOVER("클로버", 3);

    public static final String ERROR_INDEX = "잘못된 인덱스 값입니다.";
    private final String value;
    private final int index;

    Shape(final String value, final int index) {
        this.value = value;
        this.index = index;
    }

    public static Shape getShapeByIndex(final int index) {
        return Arrays.stream(values())
                .filter((shape) -> shape.index == index)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INDEX));
    }
}
