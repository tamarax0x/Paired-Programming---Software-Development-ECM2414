public class Player {

    private int playerID;
    private Card[] hand;

    public Player(int i) {
        this.playerID = i;
        this.hand = new Card[4]
    }

    public addCardtoHand(Card card, int i) {
        this.hand[i] = card;
    }

    public removeCardfromHand(Card card) {

    }

    public boolean winningHand() {
        int winningCards = 0;

        for (int i = 0; i < 4; i++) {
            if (hand[i].getValue() == playerID) {
                winningCards++;
            }
        }
        
        if (winningCards == 4) {
            return true;
        }
        else {
            return false;
        }
    }
}