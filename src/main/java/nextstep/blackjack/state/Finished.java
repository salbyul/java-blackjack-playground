package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.card.PlayingCard;

public abstract class Finished extends Started {

    public Finished(final Cards cards) {
        super(cards);
    }

    public abstract double earningRate();

    @Override
    public State draw(final PlayingCard card) {
        return this;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
