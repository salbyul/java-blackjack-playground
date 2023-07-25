package nextstep.blackjack.view;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Participant;
import nextstep.blackjack.participant.Player;
import nextstep.blackjack.participant.Players;

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
        printParticipantCards(Dealer.getDealer());
        players.getPlayerList()
                .forEach(ResultView::printParticipantCards);
    }

    public static void printParticipantCards(final Participant participant) {
        StringBuilder stringBuilder = new StringBuilder(participant.getName() + ": ");

        participant.getCards().forEach(card -> stringBuilder.append(card.getWholeName()).append(", "));
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    }
}
