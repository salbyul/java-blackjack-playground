package nextstep.blackjack.view;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.player.Dealer;
import nextstep.blackjack.player.Participant;
import nextstep.blackjack.player.Player;

import java.util.List;

public class ResultView {


    public static void printPlayerCard(final List<Player> players) {
        System.out.println("딜러와 pobi, jason에게 2장의 나누었습니다.");
        Dealer.INSTANCE.printCards();
        players.forEach(Player::printCards);
    }

    public static void printResultValue(final List<Player> players) {
        Dealer dealer = Dealer.INSTANCE;
        printResultValue(dealer);
        players.forEach(ResultView::printResultValue);
    }

    private static void printResultValue(final Participant participant) {
        StringBuilder stringBuilder = new StringBuilder();
        Cards cards = participant.getState().cards();
        stringBuilder.append(participant.getName())
                .append(" 카드: ")
                .append(cards.getCardListByString())
                .append(" - 결과: ")
                .append(cards.getResultValue());
        System.out.println(stringBuilder);
    }

    public static void printProfits(final List<Player> players) {
        double dealerProfit = players.stream().map(player -> player.getState().profit(player.getBetAmount())).reduce(0.0, Double::sum) * -1;
        Dealer dealer = Dealer.INSTANCE;
        System.out.println("## 최종수익");
        System.out.println(dealer.getName() + " : " + dealerProfit);
        players.forEach(player ->  System.out.println(player.getName() + ": " + player.getState().profit(player.getBetAmount())));
    }
}
