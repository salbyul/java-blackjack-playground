package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String START_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final Scanner scanner = new Scanner(System.in);

    public List<Player> getPlayerNames() {
        System.out.println(START_MESSAGE);
        return getPlayerNames(scanner.nextLine());
    }

    public List<Player> getPlayerNames(final String input) {
        String[] playerNames = input.split(",");
        return Arrays.stream(playerNames)
                .map(name -> new Player(name.trim()))
                .collect(Collectors.toList());
    }
}
