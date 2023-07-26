package nextstep.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HitTest {

    @Test
    @DisplayName("히트상태에서 드로우할 시 카드 한 장 추가되는지")
    void hitHasThreeCards() {
        Hit hit = new Hit(new Cards());
        State state = hit.draw(Deck.getCard());
        assertThat(state.cards().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("드로우할 경우 카드 총합 21이 넘지 않을 시 히트 반환되는지")
    void lessThanTwentyOne() {
        Hit hit = new Hit(new Cards());
        State draw = hit.draw(new PlayingCard(Denomination.ACE, Suit.CLUBS));
        assertThat(draw).isInstanceOf(Hit.class);
    }

    @Test
    @DisplayName("드로우할 경우 카드 총합 21이 넘을 시 버스트 반환되는지")
    void greaterThanTwentyOne() {
        Hit hit = new Hit(new Cards());
        State draw = hit.draw(new PlayingCard(Denomination.KING, Suit.CLUBS)).draw(new PlayingCard(Denomination.QUEEN, Suit.HEARTS));
        assertThat(draw).isInstanceOf(Bust.class);
    }

    @Test
    @DisplayName("카드를 뽑지 않을 경우 스테이 객체 반환되는지")
    void returnStay() {
        Hit hit = new Hit(new Cards());
        assertThat(hit.stay()).isInstanceOf(Stay.class);
    }

    @Test
    @DisplayName("종료된 상태인지")
    void isFinished() {
        Hit hit = new Hit(new Cards());
        assertThat(hit.isFinished()).isFalse();
    }
}
