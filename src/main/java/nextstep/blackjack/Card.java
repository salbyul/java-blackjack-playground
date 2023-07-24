package nextstep.blackjack;

public class Card {

    public static final int NUMBER_OF_SHAPES = 4;
    public static final int NUMBER_OF_EACH_SHAPES = 13;
    public static final int VALUE_OF_ACE = 1;
    private final Shape shape;
    private final int value;

    public Card(final Shape shape, final int value) {
        this.shape = shape;
        this.value = value;
    }
}
