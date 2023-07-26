package nextstep.blackjack.player;

import nextstep.blackjack.card.Cards;
import nextstep.blackjack.state.Hit;
import nextstep.blackjack.state.State;

import java.util.Scanner;

public class Player {

    public static final String ERROR_NAME = "이름은 한글자 이상 입력해야 합니다.";
    public static final String ERROR_AMOUNT_NOT_NUMBER = "숫자만 입력이 가능합니다.";
    public static final String ERROR_AMOUNT_NOT_POSITIVE = "배팅금액은 양수만 입력이 가능합니다.";
    private final String name;
    private State state;
    private int betAmount;

    public Player(final String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException(ERROR_NAME);
        }
        this.name = name;
        this.state = new Hit(new Cards());
    }

    public State getState() {
        return this.state;
    }

    public void bet(final Scanner scanner) {
        try {
            System.out.println(name + "의 배팅금액은?");
            bet(parseAmount(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bet(scanner);
        }
    }

    private int parseAmount(final String input) {
        try {
            int amount = Integer.parseInt(input.trim().replaceAll(",", ""));
            validateAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_AMOUNT_NOT_NUMBER);
        }
    }

    private void validateAmount(final int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException(ERROR_AMOUNT_NOT_POSITIVE);
        }
    }

    public void bet(final int betAmount) {
        this.betAmount = betAmount;
    }

    public int getBetAmount() {
        return this.betAmount;
    }
}
