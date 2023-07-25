package nextstep.blackjack;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Player;
import nextstep.blackjack.participant.Players;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.ResultView;

import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();

    public static void run() {
        List<Player> playerList = inputView.getPlayer();
        Players players = new Players(playerList);
        Deck.giveTwoCards(players);
        ResultView.printCardsAfterReceiveTwoCards(players);
        inputView.getUserInputGetOneMoreCard(players);
        Dealer.judgeGetOneMoreCard();
        ResultView.printSum(players);
        ResultView.printResultIncome(players);
    }
}
