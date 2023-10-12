import java.util.Random;
import java.util.Scanner;

public class Ass02_Craps
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain)
        {
            int point = 0;
            int rollCount = 0;

            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;
            rollCount++;

            System.out.println("Roll " + rollCount + ": " + dice1 + " + " + dice2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("Crapped out! You lose!");
                playAgain = promptToPlayAgain(scanner);
                continue;
            }
            else if (sum == 7 || sum == 11)
            {
                System.out.println("Natural! You win!");
                playAgain = promptToPlayAgain(scanner);
                continue;
            }
            else
            {
                point = sum;
                System.out.println("Point is set to " + point);
            }

            while (true)
            {
                dice1 = rollDice(random);
                dice2 = rollDice(random);
                sum = dice1 + dice2;
                rollCount++;

                System.out.println("Roll " + rollCount + ": " + dice1 + " + " + dice2 + " = " + sum);

                if (sum == point)
                {
                    System.out.println("Made point! You win!");
                    playAgain = promptToPlayAgain(scanner);
                    break;
                }
                else if (sum == 7)
                {
                    System.out.println("Got a seven! You lose!");
                    playAgain = promptToPlayAgain(scanner);
                    break;
                }
                else
                {
                    System.out.println("Trying for point...");
                }
            }

            System.out.println();
        }

        scanner.close();
    }

    private static int rollDice(Random random)
    {
        return random.nextInt(6) + 1;
    }

    private static boolean promptToPlayAgain(Scanner scanner)
    {
        while (true)
        {
            System.out.print("Play again? (Y/N): ");
            String playAgainInput = scanner.nextLine().trim().toUpperCase();

            if (playAgainInput.equals("Y"))
            {
                return true;
            }
            else if (playAgainInput.equals("N"))
            {
                return false;
            }

            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
        }
    }
}