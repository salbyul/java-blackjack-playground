package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.card.PlayingCard;
import nextstep.blackjack.player.Dealer;

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

    @Override
    public double profit(final double betAmount) {
        Dealer dealer = Dealer.INSTANCE;
        int dealerValue = dealer.getState().cards().getResultValue();
        if (cards.getResultValue() == dealerValue) {
            return 0;
        } else if (cards.getResultValue() < dealerValue) {
            return (earningRate() * betAmount) * -1;
        }
        return earningRate() * betAmount;
    }

    @Override
    public boolean isBlackjack() {
        return this instanceof Blackjack;
    }
}
