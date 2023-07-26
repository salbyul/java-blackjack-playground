package nextstep.blackjack.view;

import nextstep.blackjack.player.Player;
import nextstep.blackjack.state.State;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    public static final String ERROR_NO_PLAYER = "한 명 이상의 플레이어가 존재해야 합니다.";
    public static final String ERROR_PLAYER_NAME_BLANK = "플레이어의 이름은 한 글자 이상이어야 합니다.";
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        List<Player> players = getPlayer();
        setBet(players);
        ResultView.printPlayerCard(players);
    }

    private List<Player> getPlayer() {
        System.out.println(START_MESSAGE);
        try {
            return transferToPlayerList(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }

    private List<Player> transferToPlayerList(final String input) {
        validateInput(input);
        String[] splitNames = input.split(",");
        List<Player> players = Arrays.stream(splitNames)
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
        if (players.size() == 0) {
            throw new IllegalArgumentException(ERROR_NO_PLAYER);
        }
        return players;
    }

    private void validateInput(final String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ',') {
                if (i == 0 || i == input.length() - 1) {
                    throw new IllegalArgumentException(ERROR_PLAYER_NAME_BLANK);
                }
                if (input.charAt(i - 1) == ',' || input.charAt(i + 1) == ',') {
                    throw new IllegalArgumentException(ERROR_PLAYER_NAME_BLANK);
                }
            }
        }
    }

    private void setBet(List<Player> players) {
        players.forEach(player -> player.bet(scanner));
    }
}
