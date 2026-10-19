import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.FileWriter;
import java.io.File;

public class main  {
    
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CardDeck sharedDeck = new CardDeck(0);

        FileWriter p1Writer = new FileWriter("player1_output.txt", true);
        FileWriter p2Writer = new FileWriter("player2_output.txt", true);
        FileWriter p3Writer = new FileWriter("player3_output.txt", true);
        FileWriter p4Writer = new FileWriter("player4_output.txt", true);

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

        Thread[] playerThreads = new Thread[number];
        AtomicBoolean running = new AtomicBoolean(true);

        for (int j = 0; j < number; j++) {
            Player player = gamePlayers[j];
            
            

            int threadNumber = j + 1;

            int ID = player.getID();

            CardDeck drawDeck = gameDecks[ID];
            CardDeck discardDeck;

            if (ID + 1 >= number) {
                discardDeck = gameDecks[0];
            } else {
                discardDeck = gameDecks[ID + 1];
            }

            playerThreads[j] = new Thread(() -> {
                try {
                    startSignal.await();

                    while (running.get()) {
                        

                        if (player.winningHand()) {
                            running.set(false);

                            break;          
                        }

                        Card drawnCard = drawDeck.drawCard();
                        
                        writeToFile("player"+(_output.txt", sb.toString(), drawnCard, player, true);

                        Card discardCard = player.findTargetedCard();
                        writeToFile("player"+(player.getID()+1).toString()+"_output.txt", discardCard, player, false);

                        int emptySlot = discardCard.getHandNo();
                        player.removeCardfromHand(emptySlot);
                        player.addCardtoHand(drawnCard, emptySlot);
                        discardDeck.addCard(discardCard);

                        Thread.sleep(200);
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }});

                playerThreads[j].start();
        }

        Thread controller = new Thread(() -> {
            try {
                // trigger start and stop
                startSignal.countDown();
                Thread.sleep(2000);
                running.set(false);

                for (Thread playerThread : playerThreads) {
                    playerThread.interrupt();
                }

                for (Thread playerThread : playerThreads) {
                    playerThread.join();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }});

        controller.start();
        controller.join();

    }

    public static void initialiseGame(int numberOfPlayers, CardDeck sharedDeck, Player[] gamePlayers, CardDeck[] gameDecks){    
        Random rand = new Random();
        File player1File = new File("player1_output.txt");
        File player2File = new File("player2_output.txt");
        File player3File = new File("player3_output.txt");
        File player4File = new File("player4_output.txt");
        File deck1File = new File("Deck1_output.txt");
        File deck2File = new File("Deck2_output.txt");
        File deck3File = new File("Deck3_output.txt");
        File deck4File = new File("Deck4_output.txt");
                
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
                try {
                    player1File.createNewFile();
                    player2File.createNewFile();
                    deck1File.createNewFile();
                    deck2File.createNewFile();
                } catch (Exception e) {
                    System.out.println("An error occurred while creating the files.");
                    e.printStackTrace();
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
                try {
                    player1File.createNewFile();
                    player2File.createNewFile();
                    player3File.createNewFile();
                    deck1File.createNewFile();
                    deck2File.createNewFile();
                    deck3File.createNewFile();
                } catch (Exception e) {
                    System.out.println("An error occurred while creating the files.");
                    e.printStackTrace();
                    
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
                try {
                    player1File.createNewFile();
                    player2File.createNewFile();
                    player3File.createNewFile();
                    player4File.createNewFile();
                    deck1File.createNewFile();
                    deck2File.createNewFile();
                    deck3File.createNewFile();
                    deck4File.createNewFile();
                } catch (Exception e) {
                    System.out.println("An error occurred while creating the files.");
                    e.printStackTrace();
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
    public void writeToFile(String fileName, Card card,Player player,Boolean Drawn) {
        try {
            
            FileWriter writer = new FileWriter(fileName, true);
            
            StringBuilder sb = new StringBuilder();
            if(Drawn){
                sb.append("Player " + (player.getID() + 1).toString() + " draws a " + card.getValue().toString() + " from deck " + card.getDeckNo().toString() + "\n");
            }
            else{
                sb.append("Player " + (player.getID() + 1).toString() + " discards a " + card.getValue().toString() + " to deck " + card.getDeckNo().toString() + "\n");
            }
            sb.append("Player " + (player.getID() + 1).toString() + "'s Hand: " + player.hand[0].getValue().toString() + ", " + player.hand[1].getValue().toString() + ", " + player.hand[2].getValue().toString() + ", " + player.hand[3].getValue().toString() + "\n");
            writer.write(sb.toString());
            
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + fileName);
            e.printStackTrace();
        }
    }
}
