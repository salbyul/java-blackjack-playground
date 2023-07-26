package nextstep.blackjack.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private final List<PlayingCard> cards = new ArrayList<>();

    public Cards() {
        this.cards.add(Deck.getCard());
        this.cards.add(Deck.getCard());
    }

    public int size() {
        return this.cards.size();
    }

    public void add(final PlayingCard card) {
        this.cards.add(card);
    }

    public boolean isBust() {
        return getResulValue() > 21;
    }

    public String getCardListByString() {
        StringBuilder stringBuilder = new StringBuilder();
        cards.forEach(card -> stringBuilder.append(card).append(", "));
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    public boolean isLessThanSevenTeen() {
        return getResulValue() < 17;
    }

    private int getResulValue() {
        return cards.stream()
                .map(PlayingCard::getValue)
                .reduce(0, Integer::sum);
    }

    public boolean isBlackjack() {
        if (cards.size() == 2) {
            return hasAce() && hasTen();
        }
        return false;
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(PlayingCard::isAce);
    }

    private boolean hasTen() {
        return cards.stream()
                .anyMatch(PlayingCard::isTen);
    }

    public int getResultValue() {
        int sumWithoutAce = cards.stream()
                .filter(card -> !card.isAce())
                .map(PlayingCard::getValue)
                .reduce(0, Integer::sum);
        long countsOfAce = cards.stream()
                .filter(PlayingCard::isAce)
                .map(PlayingCard::getValue)
                .count();
        return calculateResultValue(sumWithoutAce, countsOfAce);
    }

    private int calculateResultValue(final int sumWithoutAce, final long countsOfAce) {
        if (countsOfAce == 0) {
            return sumWithoutAce;
        }
        if (sumWithoutAce + 11 <= 21) {
            return sumWithoutAce + 11;
        }
        return sumWithoutAce + 1;
    }
}
