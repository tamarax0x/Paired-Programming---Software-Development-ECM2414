import java.util.Scanner;

public class main  {
    public static void main(String args[]) {
        Scanner players = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many players would you like?");

        String number = players.nextLine();  // Read user input
        System.out.println("There are" + number + "players.");
    } 
}
