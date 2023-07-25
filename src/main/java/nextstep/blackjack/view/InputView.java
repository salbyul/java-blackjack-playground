package nextstep.blackjack.view;

import nextstep.blackjack.Deck;
import nextstep.blackjack.participant.Player;
import nextstep.blackjack.participant.Players;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final String START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String ERROR_BET_AMOUNT = "배팅 금액은 숫자만 입력이 가능합니다.";
    private static final String ERROR_DUPLICATE_NAME = "이름은 중복될 수 없습니다.";
    public static final String ERROR_ONE_MORE_CARD = "y 혹은 n만 입력이 가능합니다.";
    private final Scanner scanner = new Scanner(System.in);

    public List<Player> getPlayer() {
        printStartMessage();
        List<Player> playerList = null;
        try {
            playerList = getPlayerNames(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPlayer();
        }
        printBlankLine();
        getInputBetAmount(playerList);
        return playerList;
    }

    private void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public List<Player> getPlayerNames(final String input) {
        String[] playerNames = input.split(",");
        List<Player> players = Arrays.stream(playerNames)
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
        Set<String> nameSet = players.stream()
                .map(Player::getName).collect(Collectors.toSet());
        if (nameSet.size() != players.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
        return players;
    }

    private void getInputBetAmount(final List<Player> playerList) {
        try {
            getAndSetBetAmount(playerList);
        } catch (InputMismatchException e) {
            System.out.println(ERROR_BET_AMOUNT);
            getInputBetAmount(playerList);
        }
    }

    private void getAndSetBetAmount(final List<Player> playerList) {
        playerList.forEach(player -> {
            System.out.println(player.getName() + "의 배팅 금액은?");
            player.bet(parseAmount(scanner.nextLine()));
            printBlankLine();
        });
    }

    private int parseAmount(final String input) {
        return Integer.parseInt(input.trim().replaceAll(",", ""));
    }

    public void getUserInputGetOneMoreCard(Players players) {
        getUserInputGetOneMoreCard(players.getPlayerList());
    }

    public void getUserInputGetOneMoreCard(List<Player> playerList) {
        List<Player> unAcceptedPlayerList = new ArrayList<>(playerList);
        try {
            setAcceptedPlayers(unAcceptedPlayerList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getUserInputGetOneMoreCard(unAcceptedPlayerList);
        }
    }

    private void setAcceptedPlayers(final List<Player> unAcceptedPlayerList) {
        while (unAcceptedPlayerList.size() != 0) {
            Player player = unAcceptedPlayerList.get(0);
            printGetOneMoreCard(player);
            String input = scanner.nextLine();
            addCardIfYes(unAcceptedPlayerList, player, input);
            printBlankLine();
        }
    }

    private void addCardIfYes(final List<Player> unAcceptedPlayerList, final Player player, final String input) {
        if (isYes(input)) {
            unAcceptedPlayerList.remove(player);
            player.receiveCard(Deck.getCard());
            ResultView.printParticipantCards(player);
        }
    }

    private void printGetOneMoreCard(final Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    private boolean isYes(final String input) {
        if (!(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N"))) {
            throw new IllegalArgumentException(ERROR_ONE_MORE_CARD);
        }
        return input.equals("y") || input.equals("Y");
    }

    private void printBlankLine() {
        System.out.println();
    }
}
