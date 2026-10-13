import java.util.Scanner;

public class main  {
    public static void main(String args[]) {
        Scanner players = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many players would you like?");

        int number = players.nextInt();  // Read user input
        System.out.println("There are " + number + " players.");

        Player[] gamePlayers = new Player[number];
        int i = 0;
        for (i = 0; i < number; i++) {
            Player player = new Player(i);
            gamePlayers[i] = player;
            System.out.println(player.getID());
        }
    } 
}
