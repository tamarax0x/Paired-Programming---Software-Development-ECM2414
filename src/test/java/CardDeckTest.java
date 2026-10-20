import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void cardsAreDrawnInOrder() {
        CardDeck deck = new CardDeck(0);
        Card first = new Card(2, 0);
        Card second = new Card(3, 0);
        Card third = new Card(4, 0);

        deck.addCard(first);
        deck.addCard(second);
        deck.addCard(third);

        assertSame(first, deck.drawCard());
        assertSame(second, deck.drawCard());
        assertSame(third, deck.drawCard());
    }

    @Test
    void cardAddAllowsDraw() {
        CardDeck deck = new CardDeck(0);
        Card card = new Card(5, 0);

        deck.addCard(card);

        assertSame(card, deck.drawCard());
    }

    @Test
    void deckKeepsCardValues() {
        CardDeck deck = new CardDeck(0);
        deck.addCard(new Card(7, 0));

        Card drawn = deck.drawCard();

        assertEquals(7, drawn.getValue());
    }
}