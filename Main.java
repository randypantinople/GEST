import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static Statement statement = null;

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("*********Welcome TO GEST***********");
        System.out.println("An online program to help you review area and perimeter of  two-dimensional shapes\n");
        userOption();
    }

    /*
    Intent: To provide user an options.
    Post-condition: Displays menu and switches function based on user input
     */
    public static void userOption() throws IOException, SQLException {
        System.out.println("Main Menu");
        System.out.println(
                "1: Circle\n" +
                        "2: Triangle\n" +
                        "3: Square\n" +
                        "4: Rectangle\n" +
                        "5: Parallelogram\n" +
                        "6: Trapezoid\n" +
                        "7: Play the Scavenger Hunt\n" +
                        "8: Take the quiz\n" +
                        "9: Exit the program\n");


        boolean isMatch = true;
        int choice = 0;

        while (isMatch) {
            System.out.print("Select a number from main menu: ");
            try {
                choice = scanner.nextInt();
                isMatch = false;

                try{
                    if (choice < 1 || choice > 9) {
                        isMatch= true;
                        throw new MyException("Please enter numbers from 1 to 9!");
                    }
                }catch(MyException ex){
                    System.out.println(ex.getMessage() +"\n");

                }

            } catch (InputMismatchException ex) {
                scanner.next();
                System.out.println("Invalid input! Please try again\n");

            }
        }
        switchSection(choice);

    }

     /*
     Intent: Accepts user input and navigate to the corresponding section.
     Post-condition: Instantiate each shape object.
                     call displayInformation method to display shapes information
                     call practiceProblems method to practice solving area and perimeter
      */
    public static void switchSection(int choice) throws IOException, SQLException {
        boolean isCorrect = true;

        while (isCorrect) {
            switch (choice) {
                case 1:
                    Circle circle = new Circle(10);
                    circle.displayInformation();
                    PracticeProblems<Circle> circlePractice = new PracticeProblems<>(circle);
                    circlePractice.practiceProblems();
                    userOption();
                    isCorrect = false;
                    break;
                case 2:
                    RightTriangle triangle = new RightTriangle(3, 4, 5);
                    triangle.displayInformation();
                    PracticeProblems<RightTriangle> trianglePractice = new PracticeProblems<>(triangle);
                    trianglePractice.practiceProblems();
                    userOption();
                    isCorrect = false;
                    break;
                case 3:
                    Square square = new Square(12.5);
                    square.displayInformation();
                    PracticeProblems<Square> squarePractice = new PracticeProblems<>(square);
                    squarePractice.practiceProblems();
                    userOption();
                    isCorrect = false;
                    break;
                case 4:
                    Rectangle rectangle = new Rectangle(8, 10.2);
                    rectangle.displayInformation();
                    PracticeProblems<Rectangle> rectanglePractice = new PracticeProblems<>(rectangle);
                    rectanglePractice.practiceProblems();
                    userOption();
                    isCorrect = false;
                    break;
                case 5:
                    Parallelogram parallelogram = new Parallelogram(6, 4, 10.8);
                    parallelogram.displayInformation();
                    PracticeProblems<TwoDimensions> parallelogramPractice = new PracticeProblems<>(parallelogram);
                    parallelogramPractice.practiceProblems();
                    userOption();
                    isCorrect = false;
                    break;
                case 6:
                    Trapezoid trapezoid = new Trapezoid(10, 12, 8, 16, 16);
                    trapezoid.displayInformation();
                    PracticeProblems<TwoDimensions> trapezoidPractice = new PracticeProblems<>(trapezoid);
                    trapezoidPractice.practiceProblems();
                    userOption();
                    isCorrect = false;
                    break;
                case 7:
                    ScavengerHunt play = new ScavengerHunt();
                    play.getChallenge();
                    userOption();
                    isCorrect = false;
                    break;
                case 8:
                    Quiz quiz = new Quiz();
                    quiz.gradeTheQuiz();
                    userOption();
                    isCorrect = false;
                    break;
                case 9:
                    System.out.println("Thank you for using GEST. Goodbye!");
                    isCorrect = false;
                    break;
            }
        }
    }
}
