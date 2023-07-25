package nextstep.blackjack.participant;

import nextstep.blackjack.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Participant {

    public static final int VALUE_OF_THREE_ACES_CASE = 13;
    public static final int VALUE_OF_ACE_ELEVEN_CASE = 11;
    public static final int VALUE_OF_ACE_ONE_CASE = 1;
    public static final int MAXIMUM_VALUE = 21;
    public static final int ACE_CARD = 1;

    private final List<Card> cards = new ArrayList<>();
    private final String name;

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

    public int getResult() {
        int sumWithoutAce = cards.stream()
                .map(Card::getValue)
                .filter(value -> value != ACE_CARD)
                .reduce(0, Integer::sum);
        long numberOfAce = cards.stream()
                .map(Card::getValue)
                .filter(value -> value == ACE_CARD)
                .count();
        return calculateAce(sumWithoutAce, numberOfAce);
    }

    private int calculateAce(final int sum, final long numberOfAce) {
        if (numberOfAce == 0) {
            return sum;
        } else if (numberOfAce == 3) {
            return VALUE_OF_THREE_ACES_CASE;
        }
        List<Integer> allCases = getAllCases(sum, numberOfAce);
        return allCases.stream()
                .filter(value -> value <= MAXIMUM_VALUE)
                .max(Comparator.naturalOrder())
                .orElse(0); // 존재하지 않을 가능성은 없다.
    }

    private List<Integer> getAllCases(final int sum, final long numberOfAce) {
        List<Integer> cases = new ArrayList<>();
        if (numberOfAce == 1) {
            cases.add(sum + VALUE_OF_ACE_ELEVEN_CASE);
            cases.add(sum + VALUE_OF_ACE_ONE_CASE);
            return cases;
        }
        cases.add(sum + VALUE_OF_ACE_ONE_CASE + VALUE_OF_ACE_ELEVEN_CASE);
        cases.add(sum + VALUE_OF_ACE_ONE_CASE + VALUE_OF_ACE_ONE_CASE);
        return cases;
    }
}