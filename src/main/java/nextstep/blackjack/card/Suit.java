package nextstep.blackjack.card;

public enum Suit {
    HEARTS("하트"), DIAMONDS("다이아몬드"), SPADES("스페이드"), CLUBS("클로버");

    private final String suit;

    Suit(final String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
