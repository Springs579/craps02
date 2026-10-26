import java.util.Random;
import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        String again;

        System.out.println("=== Welcome to Craps ===\n");

        do {
            // Initial (come-out) roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.printf("Roll: Die1 = %d, Die2 = %d, Sum = %d%n", die1, die2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crapped out! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("The point is now " + point + ".");

                boolean gameOver = false;
                while (!gameOver) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.printf("Roll: Die1 = %d, Die2 = %d, Sum = %d%n", die1, die2, sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        gameOver = true;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point (" + point + ")...");
                    }
                }
            }

            System.out.print("\nPlay again? (y/n): ");
            again = input.nextLine().trim();
            System.out.println();

        } while (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing. Goodbye!");
        input.close();
    }
}