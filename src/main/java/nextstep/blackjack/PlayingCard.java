package nextstep.blackjack;

public class PlayingCard {

    private final Denomination denomination;
    private final Suit suit;

    public PlayingCard(final Denomination denomination, final Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }
}
