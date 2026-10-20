import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void winningHandReturnsTrue() {
        Player player = new Player(0);

        for (int i = 0; i < 4; i++) {
            player.addCardtoHand(new Card(3, 0), i);
        }

        assertTrue(player.winningHand());
    }

    @Test
    void winningHandReturnsFalse() {
        Player player = new Player(0);

        player.addCardtoHand(new Card(3, 0), 0);
        player.addCardtoHand(new Card(3, 0), 1);
        player.addCardtoHand(new Card(3, 0), 2);
        player.addCardtoHand(new Card(4, 0), 3);

        assertFalse(player.winningHand());
    }

    @Test
    void playerTargetsCorrectLocation() {
        Player player = new Player(0);

        assertTrue(player.targetedDenomination(
            new Card(1, 0)
        ));
        assertFalse(player.targetedDenomination(
            new Card(2, 0)
        ));
    }

    @Test
    void findTargetedCardReturnsCard() {
        Player player = new Player(0);

        Card preferred = new Card(1, 0);
        Card discard = new Card(2, 0);
        Card other = new Card(3, 0);
        Card preferredAgain = new Card(1, 0);

        player.addCardtoHand(preferred, 0);
        player.addCardtoHand(discard, 1);
        player.addCardtoHand(other, 2);
        player.addCardtoHand(preferredAgain, 3);

        assertSame(discard, player.findTargetedCard());
        assertEquals(1, discard.getHandNo());
    }

    @Test
    void findTargetedCardReturnsNull() {
        Player player = new Player(0);

        for (int i = 0; i < 4; i++) {
            player.addCardtoHand(new Card(1, 0), i);
        }

        assertNull(player.findTargetedCard());
    }
}