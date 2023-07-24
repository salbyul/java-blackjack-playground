package nextstep.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DeckTest {

    @Test
    @DisplayName("초기화 후 덱의 카드 수")
    void countCardsAfterInit() {
        assertThat(Deck.getNumberOfCards()).isEqualTo(52);
    }
}
