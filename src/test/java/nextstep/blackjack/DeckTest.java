package nextstep.blackjack;

import nextstep.blackjack.card.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DeckTest {

    @Test
    @DisplayName("게임 시작 후 초기화된 덱에 52장의 카드가 있는지")
    void initDeck() {
        assertThat(Deck.size()).isEqualTo(52);
    }
}
