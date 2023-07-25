package nextstep.blackjack;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Players;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.ResultView;

public class Application {

    private static final InputView inputView = new InputView();

    public static void run() {
        Players players = new Players(inputView.getPlayer());
        Deck.giveTwoCards(players);
        ResultView.printCardsAfterReceiveTwoCards(players);
        inputView.getUserInputGetOneMoreCard(players);
        Dealer.judgeGetOneMoreCard();
        ResultView.printSum(players);
        ResultView.printResultIncome(players);
    }
}
