package nextstep.blackjack;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Player;
import nextstep.blackjack.participant.Players;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.ResultView;

import java.util.List;

public class Application {

    public static void run() {
        InputView inputView = new InputView();
        List<Player> playerList = inputView.getPlayer();
        Players players = new Players(playerList);
        Deck.giveTwoCards(players);
        ResultView.printParticipantAfterReceiveTwoCards(players);
        inputView.getUserInputGetOneMoreCard(players);
        Dealer.judgeGetOneMoreCard();
        ResultView.printSum(players);
    }
}
