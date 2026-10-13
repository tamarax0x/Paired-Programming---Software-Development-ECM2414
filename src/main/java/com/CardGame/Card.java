public class Card {
    private int value;
    private int deckNo;
    private int handNo;
    private boolean inHand;

    public Card(int n, int deckValue) {
        this.value = n;
        this.deckNo = deckValue;
        this.handNo = 0;
        this.inHand = false;
    }

    public void setDeckNo(int deck) {
        this.deckNo = deck;
    }

    public void setHandNo(int hand) {
        this.handNo = hand;
    }

    public int getValue() {
        return this.value;
    }

    public int getDeckNo() {
        return this.deckNo;
    }

    public int getHandNo() {
        return this.handNo;
    }

    
}