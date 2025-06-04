import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean playAgain;

        do {

            System.out.println("Welcome to Guessing Game! You have 5 guesses before the game ends. " +
                    "Please choose one of the following levels: ");

            int choice;
            while (true) {
                System.out.println("1. Easy\n" + "2. Medium\n" + "3. Hard");

                if (input.hasNextInt()) {
                    choice = input.nextInt();
                    if (choice >= 1 && choice <= 3) {
                        break;
                    } else {
                        System.out.println("Invalid number! Please enter a number between 1 and 3: ");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                    input.next();
                }
            }

            switch (choice) {

                case 1:
                    playGame(1, 50, 5, input);
                    break;
                case 2:
                    playGame(1, 100, 5, input);
                    break;
                case 3:
                    playGame(1, 200, 5, input);
                    break;
            }
            System.out.println("Would you like to play again? (y/n)");
            String answer = input.next().trim().toLowerCase();
            playAgain = answer.equals("y");
        } while (playAgain);
        System.out.println("Thanks for playing!");
        input.close();
    }

    public static void playGame(int min, int max, int maxGuesses, Scanner input) {
    int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
    int score = 0;
        // Only for testing code
        System.out.println(randomNumber);
        System.out.println("Guess the number between " + min + " and " + max );
        for (int i = 0; i < maxGuesses; i++) {
            System.out.println("Enter guess #" + (i + 1) + ":");
            int guess = input.nextInt();
            if(guess == randomNumber) {
                System.out.println("You guessed correctly! Congratulations!");
                break;
            }
            else {
                int remainingTries = maxGuesses - i - 1;
                if (remainingTries > 0) {
                    System.out.println("Incorrect! You have " + remainingTries + " tries left! Please guess again.");
                }
                else {
                    System.out.println("Incorrect! You lost the game!");
                }

    }
}
    }
}
