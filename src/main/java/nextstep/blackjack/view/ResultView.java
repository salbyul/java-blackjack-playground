package nextstep.blackjack.view;

import nextstep.blackjack.participant.Dealer;
import nextstep.blackjack.participant.Participant;
import nextstep.blackjack.participant.Players;

public class ResultView {

    public static final String MESSAGE_DEALER_GET_ONE_MORE_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public static void printCardsAfterReceiveTwoCards(final Players players) {
        printParticipantsGetTwoCards(players);
        printParticipantsCards(players);
    }

    private static void printParticipantsGetTwoCards(final Players players) {
        StringBuilder stringBuilder = new StringBuilder("딜러와 ");
        players.getPlayerList()
                .forEach(player -> stringBuilder.append(player.getName()).append(", "));
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2) + "에게 2장의 카드를 나누었습니다.");
    }

    private static void printParticipantsCards(final Players players) {
        printParticipantCards(Dealer.getDealer());
        blankLine();
        players.getPlayerList()
                .forEach(player -> {
                    printParticipantCards(player);
                    blankLine();
                });
    }

    public static void printParticipantCards(final Participant participant) {
        StringBuilder stringBuilder = new StringBuilder(participant.getName() + ": ");

        participant.getCards().forEach(card -> stringBuilder.append(card.getWholeName()).append(", "));
        System.out.print(stringBuilder.substring(0, stringBuilder.length() - 2));
    }

    public static void printDealerOneMoreCard() {
        System.out.println(MESSAGE_DEALER_GET_ONE_MORE_CARD);
    }

    public static void printSum(final Players players) {
        printSum(Dealer.getDealer());
        players.getPlayerList().forEach(ResultView::printSum);
    }

    private static void printSum(Participant participant) {
        printParticipantCards(participant);
        System.out.print(" - 결과: " + participant.getResultValue());
        blankLine();
    }

    private static void blankLine() {
        System.out.println();
    }

    public static void printResultIncome(final Players players) {
        System.out.println("## 최종 수익");
        players.setPlayerIncome();
        Dealer dealer = Dealer.getDealer();
        System.out.println(dealer.getName() + ": " + (int) dealer.getIncome());
        players.getPlayerList()
                .forEach(player -> System.out.println(player.getName() + ": " + (int) player.getIncome()));
    }
}
