package nextstep.blackjack.participant;

import nextstep.blackjack.Card;
import nextstep.blackjack.Deck;
import nextstep.blackjack.view.ResultView;

public class Dealer extends Participant {

    private static final Dealer dealer = new Dealer();
    private static final String DEALER_NAME = "딜러";
    public static final int NUMBER_CAN_NOT_DRAW = 17;

    private Dealer() {
        super(DEALER_NAME);
    }

    public static Dealer getDealer() {
        return dealer;
    }

    public static void judgeGetOneMoreCard() {
        if (dealer.lessThanSevenTeen()) {
            ResultView.printDealerOneMoreCard();
            dealer.getCards().add(Deck.getCard());
        }
    }

    public boolean lessThanSevenTeen() {
        Integer resultNumber = getCards().stream()
                .map(Card::getValue)
                .reduce(0, Integer::sum);
        return resultNumber < NUMBER_CAN_NOT_DRAW;
    }
}
