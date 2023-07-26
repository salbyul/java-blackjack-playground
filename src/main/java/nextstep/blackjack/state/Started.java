package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;

public abstract class Started implements State {

    public final Cards cards;

    public Started(final Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return this.cards;
    }
}
