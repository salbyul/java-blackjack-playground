package nextstep.blackjack;

import java.util.Objects;

public class Card {

    public static final int NUMBER_OF_SHAPES = 4;
    public static final int NUMBER_OF_EACH_SHAPES = 13;
    public static final int VALUE_OF_ACE = 1;
    private static final String ACE_FIRST_LETTER = "A";
    private static final String KING_FIRST_LETTER = "K";
    private static final String QUEEN_FIRST_LETTER = "Q";
    private static final String JACK_FIRST_LETTER = "J";
    public static final int MAXIMUM_VALUE_OF_ONE = 10;
    private final Shape shape;
    private final int value;

    public Card(final Shape shape, final int value) {
        this.shape = shape;
        this.value = value;
    }

    public String getWholeName() {
        if (this.value == 1) {
            return ACE_FIRST_LETTER + shape.getValue();
        } else if (this.value == 11) {
            return KING_FIRST_LETTER + shape.getValue();
        } else if (this.value == 12) {
            return QUEEN_FIRST_LETTER + shape.getValue();
        } else if (this.value == 13) {
            return JACK_FIRST_LETTER + shape.getValue();
        }
        return value + shape.getValue();
    }

    public int getValue() {
        return Math.min(this.value, MAXIMUM_VALUE_OF_ONE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Card card = (Card) o;
        return value == card.value && shape == card.shape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, value);
    }
}
