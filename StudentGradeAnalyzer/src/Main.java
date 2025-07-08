import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String calculateGrade(int score){
        return
                (score >= 90) ? "A" :
                (score >= 80) ? "B" :
                (score >= 70) ? "C" :
                (score >= 60) ? "D" : "F";
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of Students: ");
        int numOfStudents = scanner.nextInt();
        scanner.nextLine();

        double highestScore = -1, totalScore = 0;
        int countGrade[] = new int[5];
        List<Student> students = new ArrayList<>();
        List<String> topStudents = new ArrayList<>();


        for (int i = 0; i < numOfStudents; i++){
            System.out.print("\nEnter name of Student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter score for " + name + ": ");
            int score = scanner.nextInt();
            String grade = calculateGrade(score);
            System.out.println(name + " got grade: " + grade);
            scanner.nextLine();
            students.add(new Student(name, grade, score));

            // getting the top student
            if(score > highestScore){
                highestScore = score;
                topStudents.clear();
                topStudents.add(name);
            } else if(score == highestScore){
                topStudents.add(name);
            }

            // for average
            totalScore += score;
        }

        for(Student student : students){
            switch (student.grade){
                case "A": countGrade[0]++; break;
                case "B": countGrade[1]++; break;
                case "C": countGrade[2]++; break;
                case "D": countGrade[3]++; break;
                case "F": countGrade[4]++; break;
            }
        }

        //computation of average score
        double averageScore = totalScore / numOfStudents;
        averageScore = Math.round(averageScore * 100.0) / 100.0;

        System.out.println("\n----- Class Summary -----");
        System.out.println("Average Score: " + averageScore);
        System.out.println("Grade Counts: " +
                "A:" + countGrade[0] +
                " B:" + countGrade[1] +
                " C:" + countGrade[2] +
                " D:" + countGrade[3] +
                " F:" + countGrade[4]
        );
        System.out.println("Top Student(s): "
                + String.join(", ", topStudents)
                + " (" + highestScore + ")"
        );

    }
}

class Student {
    String name;
    String grade;
    double score;

    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }
}