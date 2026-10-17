import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.LinkedList;


public class cardExchange extends Thread {
    private Player player;
    private CardDeck[] decks;
    private int maxPlayers;
    private CardDeck drawDeck;
    private CardDeck discardDeck;

    cardExchange(Player plr, int number) {
        this.player = plr;
        this.maxPlayers = number;
    }

    public void run(CardDeck[] decks) {
        int ID = player.getID();
        drawDeck = decks[ID]
        if (ID + 1 >= maxPlayers) {
            discardDeck = decks[0]
        }
        else {
            discardDeck = deck[ID + 1]
        }

        Card drawnCard = drawDeck.drawCard();
        int freeSpace = removeTargetedCard();
    }
}

public class main  {
    
    public static void main(String args[]) {
        CardDeck sharedDeck = new CardDeck(0);

        Scanner players = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many players would you like?");

        int number = players.nextInt();  // Read user input
        System.out.println("There are " + number + " players.");

        Player[] gamePlayers = new Player[number];
        CardDeck[] gameDecks = new CardDeck[number];

        int i = 0;
        for (i = 0; i < number; i++) {
            Player player = new Player(i);
            gamePlayers[i] = player;

            CardDeck deck = new CardDeck(i);
            gameDecks[i] = deck;
        }
        initialiseGame(number, sharedDeck, gamePlayers,gameDecks);
    } 

    public static void initialiseGame(int numberOfPlayers, CardDeck sharedDeck, Player[] gamePlayers, CardDeck[] gameDecks){    
        Random rand = new Random();
        switch (numberOfPlayers) {
            case 2:
                for (int i = 0; i < 4; i++) {
                    sharedDeck.addCard(new Card(1, 0));
                    sharedDeck.addCard(new Card(2, 0));
                }
                for (int i = 0; i < 8; i++) {
                    int randomNum = rand.nextInt(18) + 3;
                    sharedDeck.addCard(new Card(randomNum, 0));
                }
                
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    sharedDeck.addCard(new Card(1, 0));
                    sharedDeck.addCard(new Card(2, 0));
                    sharedDeck.addCard(new Card(3, 0));
                }
                for (int i = 0; i < 12; i++) {
                    int randomNum = rand.nextInt(18) + 4;
                    sharedDeck.addCard(new Card(randomNum, 0));
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    sharedDeck.addCard(new Card(1, 0));
                    sharedDeck.addCard(new Card(2, 0));
                    sharedDeck.addCard(new Card(3, 0));
                    sharedDeck.addCard(new Card(4, 0));
                }
                for (int i = 0; i < 16; i++) {
                    int randomNum = rand.nextInt(18) + 5;
                    sharedDeck.addCard(new Card(randomNum, 0));
                }
                break;
            default:
                System.out.println("Invalid number of players");
        }
        sharedDeck.shuffle();
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < 4; j++) {
                gamePlayers[i].addCardtoHand(sharedDeck.drawCard(), j);
                gameDecks[i].addCard(sharedDeck.drawCard());
            }

            gamePlayers[i].printHand(gamePlayers[i].getID());
        }
    }
}
