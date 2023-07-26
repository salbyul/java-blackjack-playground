package nextstep.blackjack.view;

import nextstep.blackjack.player.Dealer;
import nextstep.blackjack.player.Player;

import java.util.List;

public class ResultView {


    public static void printPlayerCard(final List<Player> players) {
        System.out.println("딜러와 pobi, jason에게 2장의 나누었습니다.");
        Dealer.INSTANCE.printCards();
        players.forEach(Player::printCards);
    }
}
