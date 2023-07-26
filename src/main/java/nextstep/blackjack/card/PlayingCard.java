package nextstep.blackjack.card;

public class PlayingCard {

    private final Denomination denomination;
    private final Suit suit;

    public PlayingCard(final Denomination denomination, final Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public int getValue() {
        return this.denomination.getValue();
    }

    public String getSuit() {
        return suit.getSuit();
    }

    @Override
    public String toString() {
        return getValue() + getSuit();
    }
}
