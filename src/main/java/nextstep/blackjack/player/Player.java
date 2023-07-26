package nextstep.blackjack.player;

import java.util.Scanner;

public class Player extends Participant {

    public static final String ERROR_AMOUNT_NOT_NUMBER = "숫자만 입력이 가능합니다.";
    public static final String ERROR_AMOUNT_NOT_POSITIVE = "배팅금액은 양수만 입력이 가능합니다.";

    private int betAmount;

    public Player(final String name) {
        super(name);
    }

    public void bet(final Scanner scanner) {
        try {
            System.out.println(getName() + "의 배팅금액은?");
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
