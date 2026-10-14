
import java.util.*;


public class CardDeck {

    private LinkedList<Card> Cards;
    private int deckID;

    public CardDeck(int i) {
        this.Cards = new LinkedList<>();
        this.deckID = i;
    }

    public Card drawCard() {
        Card top = Cards.peek();
        Cards.remove(top);
        return top;
    }

    public void addCard(Card card) {
        Cards.add(card);
    }
    
}
