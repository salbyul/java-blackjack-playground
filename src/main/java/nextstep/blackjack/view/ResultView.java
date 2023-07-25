package nextstep.blackjack.view;

import nextstep.blackjack.Card;
import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Players;

import java.util.List;

public class ResultView {

    public static void printParticipantAfterReceiveTwoCards(final Players players) {
        printParticipantsGetTwoCards(players);
        printParticipantsCards(players);
    }

    private static void printParticipantsGetTwoCards(final Players players) {
        System.out.print("딜러와 ");
        StringBuilder stringBuilder = new StringBuilder();
        players.getPlayerList()
                .forEach(player -> stringBuilder.append(player.getName()).append(", "));
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2) + "에게 2장의 카드를 나누었습니다.");
    }

    private static void printParticipantsCards(final Players players) {
        System.out.print("딜러: ");
        printCards(Dealer.getDealer().getCards());
        players.getPlayerList()
                .forEach(player -> {
                    System.out.print(player.getName() + ": ");
                    printCards(player.getCards());
                });
    }

    private static void printCards(final List<Card> cards) {
        StringBuilder stringBuilder = new StringBuilder();

        cards.forEach(card -> stringBuilder.append(card.getWholeName()).append(", "));
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    }
}
