import java.util.Scanner;
import java.util.Random;

public class numberguessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;  
        int guess;
        int maxAttempts = 5;
        int attempts = 0;
        boolean win = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        while (!win && attempts < maxAttempts) {
            System.out.print("Guess a number between 1 and 100: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                win = true;
                System.out.println("Congratulations! You've guessed the correct number.");
                System.out.println("It took you " + attempts + " attempts.");
            }
        }

        if (!win) {
            System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}