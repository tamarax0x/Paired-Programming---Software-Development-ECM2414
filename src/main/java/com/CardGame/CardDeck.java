import java.util.Queue;

public class CardDeck {

    private Queue<Card> Cards;
    private int deckID;

    public CardDeck(int i) {
        this.Cards = new Queue<Card>();
        this.deckID = i;
    }

    public Card getCard() {
        Card top = Cards.peek();
        Cards.remove(top);
        return top;
    }

    public void addCard(Card card) {
        Cards.add(card);
    }
}
