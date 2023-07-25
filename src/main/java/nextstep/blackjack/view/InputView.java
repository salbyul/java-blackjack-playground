package nextstep.blackjack.view;

import nextstep.blackjack.participant.Player;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final String START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String ERROR_BET_AMOUNT = "배팅 금액은 숫자만 입력이 가능합니다.";
    private static final String ERROR_DUPLICATE_NAME = "이름은 중복될 수 없습니다.";
    private final Scanner scanner = new Scanner(System.in);

    public List<Player> getPlayer() {
        System.out.println(START_MESSAGE);
        List<Player> playerList = null;
        try {
            playerList = getPlayerNames(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPlayer();
        }
        getInputBetAmount(playerList);
        return playerList;
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
        });
    }

    private int parseAmount(final String input) {
        return Integer.parseInt(input.trim().replaceAll(",", ""));
    }

}
