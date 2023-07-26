package nextstep.blackjack.state;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.card.PlayingCard;

public interface State {

    Cards cards();

    State draw(final PlayingCard card);

    State stay();

    boolean isFinished();

    double profit(final double betAmount);

    boolean isBlackjack();
}
