import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TOTAL_QUESTIONS = 5;
    private static final int QUESTION_TIME_LIMIT = 10; // Time limit for each question in seconds
    private static final String[] QUESTIONS = {
        "1. What is the capital of France?",
        "2. Who is the author of 'To Kill a Mockingbird'?",
        "3. What is the chemical symbol for water?",
        "4. Which planet is known as the Red Planet?",
        "5. What is the largest mammal in the world?"
    };
    private static final String[][] OPTIONS = {
        {"A. London", "B. Paris", "C. Berlin", "D. Rome"},
        {"A. J.K. Rowling", "B. Harper Lee", "C. George Orwell", "D. Stephen King"},
        {"A. H", "B. O", "C. W", "D. H2O"},
        {"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"},
        {"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Hippopotamus"}
    };
    private static final char[] ANSWERS = {'B', 'B', 'D', 'B', 'B'};
    private static int currentQuestionIndex = 0;
    private static int score = 0;
    private static Timer timer;

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You will have " + QUESTION_TIME_LIMIT + " seconds to answer each question.");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                displayNextQuestion(scanner);
            }
        }, 0, QUESTION_TIME_LIMIT * 1000);

        displayNextQuestion(scanner);
    }

    private static void displayNextQuestion(Scanner scanner) {
        if (currentQuestionIndex < TOTAL_QUESTIONS) {
            System.out.println("\n" + QUESTIONS[currentQuestionIndex]);
            for (String option : OPTIONS[currentQuestionIndex]) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));
            if (userAnswer == ANSWERS[currentQuestionIndex]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + ANSWERS[currentQuestionIndex]);
            }
            currentQuestionIndex++;
        } else {
            endQuiz();
        }
    }

    private static void endQuiz() {
        timer.cancel();
        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + "/" + TOTAL_QUESTIONS);
        System.out.println("Thank you for participating!");
    }
}
