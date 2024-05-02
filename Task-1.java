import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int rounds = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Game!");
        
        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange);
            
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    score += attemptsLimit - attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                attempts++;
            }
            
            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've exceeded the number of attempts. The correct number was: " + generatedNumber);
            }
            
            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            
            if (playAgain.equalsIgnoreCase("yes")) {
                rounds++;
            } else {
                break;
            }
        } while (true);
        
        System.out.println("Thank you for playing the Number Game! Your final score: " + score);
        scanner.close();
    }
}
