
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        System.out.print("Enter marks for Subject 1: ");
        int subject1Marks = scanner.nextInt();
        System.out.print("Enter marks for Subject 2: ");
        int subject2Marks = scanner.nextInt();
        System.out.print("Enter marks for Subject 3: ");
        int subject3Marks = scanner.nextInt();
        
        // Calculate total marks
        int totalMarks = subject1Marks + subject2Marks + subject3Marks;
        
        // Calculate average percentage
        double averagePercentage = (double) totalMarks / 3;
        
        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
