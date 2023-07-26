package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.card.PlayingCard;

public class Running extends Started {

    public Running(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final PlayingCard card) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(final double betAmount) {
        return 0;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }
}
