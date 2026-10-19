
import java.util.*;


public class CardDeck {

    private LinkedList<Card> Cards;
    private int deckID;

    public CardDeck(int i) {
        this.Cards = new LinkedList<Card>();
        this.deckID = i;
    }

    public int getID() {
        return this.deckID;
    }

    public Card drawCard() {
        Card top = Cards.peek();
        Cards.remove(top);
        return top;
    }

    public void addCard(Card card) {
        Cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(this.Cards);
    }

    public String printDeck() {
        int[] list = new int[4];
        int DeckNo = deckID + 1;
        for (int i = 0; i < 4; i++) {
            list[i] = this.Cards.get(i).getValue();

        }
        return ("Deck " + DeckNo + "'s Cards: " + list[0] + ", " + list[1] + ", " + list[2] + ", " + list[3]);
    }
    
    
}
