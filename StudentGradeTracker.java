import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = inputGrades(scanner);
        
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            displayStatistics(grades);
        }

        scanner.close();
    }

    private static ArrayList<Double> inputGrades(Scanner scanner) {
        ArrayList<Double> grades = new ArrayList<>();
        System.out.println("Enter grades for the students (type 'done' to finish):");
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                grades.add(Double.parseDouble(input));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value or 'done' to finish.");
            }
        }

        return grades;
    }

    private static void displayStatistics(ArrayList<Double> grades) {
        double average = computeAverage(grades);
        double highest = findHighest(grades);
        double lowest = findLowest(grades);

        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }

    private static double computeAverage(ArrayList<Double> grades) {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    private static double findHighest(ArrayList<Double> grades) {
        return grades.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
    }

    private static double findLowest(ArrayList<Double> grades) {
        return grades.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
    }
}
