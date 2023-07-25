package nextstep.blackjack.participant;

import nextstep.blackjack.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Participant {

    public static final int VALUE_OF_THREE_ACES_CASE = 13;
    public static final int VALUE_OF_ACE_ELEVEN_CASE = 11;
    public static final int VALUE_OF_ACE_ONE_CASE = 1;
    public static final int MAXIMUM_VALUE = 21;
    public static final int ACE_CARD = 1;

    private final List<Card> cards = new ArrayList<>();
    private final String name;
    private double income;

    public Participant(final String name) {
        this.name = name;
    }

    public void receiveCard(Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public String getName() {
        return this.name;
    }

    public int getResultValue() {
        int sumWithoutAce = cards.stream()
                .map(Card::getValue)
                .filter(value -> value != ACE_CARD)
                .reduce(0, Integer::sum);
        long countsOfAce = cards.stream()
                .map(Card::getValue)
                .filter(value -> value == ACE_CARD)
                .count();
        return calculateAce(sumWithoutAce, countsOfAce);
    }

    private int calculateAce(final int sum, final long countsOfAce) {
        if (countsOfAce == 0) {
            return sum;
        } else if (countsOfAce == 3) {
            return VALUE_OF_THREE_ACES_CASE;
        }
        List<Integer> allCases = getAllCases(sum, countsOfAce);
        return allCases.stream()
                .filter(value -> value <= MAXIMUM_VALUE)
                .max(Comparator.naturalOrder())
                .orElse(0); // 존재하지 않을 가능성은 없다.
    }

    private List<Integer> getAllCases(final int sum, final long countsOfAce) {
        List<Integer> cases = new ArrayList<>();
        if (countsOfAce == 1) {
            cases.add(sum + VALUE_OF_ACE_ELEVEN_CASE);
            cases.add(sum + VALUE_OF_ACE_ONE_CASE);
            return cases;
        }
        cases.add(sum + VALUE_OF_ACE_ONE_CASE + VALUE_OF_ACE_ELEVEN_CASE);
        cases.add(sum + VALUE_OF_ACE_ONE_CASE + VALUE_OF_ACE_ONE_CASE);
        return cases;
    }

    public void setIncome(final double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }
}