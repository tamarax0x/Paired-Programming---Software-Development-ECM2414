public class Player {

    private int playerID;
    private Card[] hand;

    public Player(int i) {
        this.playerID = i;
        this.hand = new Card[4];
    }

    public int getID() {
        return this.playerID;
    }

    public void addCardtoHand(Card card, int i) {
        this.hand[i] = card;
    }

    public int removeCardfromHand(Card card) {
        return 0;
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