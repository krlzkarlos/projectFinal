package certificate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class certificateGenerator {
    public static void main(String[] args) {
        int averageScore;
        String studentName;
        Scanner studentNameInput = new Scanner(System.in);
        System.out.print("Enter the name of the student: ");
        studentName = studentNameInput.nextLine();
        Scanner gradesListInput = new Scanner(System.in);
        gradesListInput.useDelimiter("[\\s,]+");
        System.out.print("Enter five numbers separated by a space or a comma: ");
        List<Integer> gradesList = getListOfGrades(gradesListInput.nextLine());
        averageScore = getAverageScore(gradesList);
        printCertificate(gradesList, averageScore, studentName);
    }

    static List<Integer> getListOfGrades(String grades) {
        List<Integer> list = new ArrayList<>();
        for(String i:grades.split(",")){
            list.add(Integer.parseInt(i));
        }
        return list;
    }

    static int getAverageScore(List<Integer> grades) {
        int sumAll = 0;
        for (int i : grades) {
            sumAll = sumAll + i;
        }
        return sumAll/grades.size();
    }

    static void printCertificate(List<Integer> grades, int averageScore, String studentName) {
        String[] courses = { "Math I", "Geography", "Literature II", "Russian A2", "Programming" };
        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Completion Certificate |%n");
        System.out.format("+-----------------+------+%n");
        System.out.format("| " + studentName +  " |%n");
        System.out.format("+-----------------+------+%n");
        System.out.format("| Courses      | Grade   |%n");
        System.out.format("+-----------------+------+%n");
        for (int i = 0; i < grades.size(); i++) {
            System.out.format(leftAlignFormat, courses[i], grades.get(i));
        }
        System.out.format("+-----------------+------+%n");
        System.out.format(leftAlignFormat, "Average grade", averageScore);
        System.out.format("+-----------------+------+%n");
    }
}
