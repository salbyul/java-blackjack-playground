package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.card.PlayingCard;

public class Hit extends Running {

    public Hit(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final PlayingCard card) {
        cards.add(card);
        if (cards.isBust()) {
            return new Bust(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }
}
