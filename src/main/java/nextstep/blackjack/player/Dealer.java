package nextstep.blackjack.player;

import nextstep.blackjack.card.Deck;

public class Dealer extends Participant {

    public static final String DEALER_NAME = "딜러";
    public static final Dealer INSTANCE = new Dealer(DEALER_NAME);

    private Dealer(final String name) {
        super(name);
    }

    public boolean isLessThanSevenTeen() {
        return getState().cards().isLessThanSevenTeen();
    }

    @Override
    public void progress(final boolean canProgress) {
        setState(getState().draw(Deck.getCard()));
    }
}
