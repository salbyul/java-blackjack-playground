package nextstep.blackjack;

import java.util.Objects;

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
