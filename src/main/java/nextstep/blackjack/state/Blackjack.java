package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.state.Finished;

public class Blackjack extends Finished {

    public Blackjack(final Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 1.5;
    }

}
