import java.util.Random;
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

    public void  removeCardfromHand(int i) {
        this.hand[i]= null;
    }

    public boolean winningHand() {

        for (int i = 0; i < 4; i++) {
            if (hand[0].getValue() != hand[i].getValue()) 
            {
                return false;
            }
        }
        return true;
    }

    public int modeOfHand(){
        int mode = hand[0].getValue();
        int maxCount = 0;
        for (int i = 0; i < hand.length; i++) {
            int value = hand[i].getValue();
            int count = 0;
            for (int j = 0; j < hand.length; j++) {
                if (hand[j].getValue() == hand[i].getValue()) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = value;
            }
        }
        if(maxCount > 1){
            return mode;
        }
        return -1;
    }

    public void removeTargetedCard(){
        Random rand = new Random();
        for(int i = 0; i < hand.length; i++){
            if(!targetedDenomination(hand[i])){
                
               removeCardfromHand(i);    
               return;
            }
            
            
        }  
        hand[rand.nextInt(4)] = null;


    }
    
    public boolean targetedDenomination(Card card){
        if(card.getValue() == playerID){
            return true;
        }
        return false;
    }

}

