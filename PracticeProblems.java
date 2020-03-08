import java.util.InputMismatchException;
import java.util.Scanner;

public class PracticeProblems <T extends TwoDimensions> {
    private T shape;

    public PracticeProblems(T shape) {
        this.shape = shape;
    }

    private static Scanner scanner = new Scanner(System.in);

    /*
    Intent: To create practice for each shapes
    Post-condition: calls comparePerimeter() method and compareArea methods
     */
    public void practiceProblems() {
        System.out.println();
        System.out.println("Let's practice solving perimeter and area.\n");
        //shows the dimensions from each shape
        System.out.println("Given : " + shape);
        
        comparePerimeter(); // calls this method to compare perimeters
        compareArea(); // calls this method to compare area

        System.out.print("Press \"ENTER\" to go to the main menu:  ");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

    }
    /*
    Intent: Get the user input for perimeter
    Post-condition: User enters a valid answer
    Post-condition : returns user answer as a double
     */

    public  double getPerimeterInput(){
        boolean isMatch= true;
        double perimeter = 1;
        while(isMatch){

            System.out.print("Solve the perimeter = ");
            //check to make sure user enters a valid input
            try{
                perimeter = scanner.nextDouble();
                isMatch = false;
            }catch(InputMismatchException ex){
                scanner.next();
                System.out.println("Invalid Input! Please try again.\n");
            }
        }
        return perimeter;
    }

    /*
    Intent: Compare user answer to the correct perimeter
    Post-condition: calls getPerimeterInput() method and compares it to the correct perimeter
                       by calling the class getPerimeter method.
                    Displays solution and feedback
     */

    public void comparePerimeter() {
        // if user answer is incorrect, provide a solution
        if (getPerimeterInput() != shape.getPerimeter() ){
            System.out.println("Your solution is incorrect!\n");
        } else {
            System.out.println("Good Job!");
        }
    }

    /*
    Intent: To get the input from user
    Post-condition: User enters an answer for the area
    Post-condition:returns area as a type double
     */
    public double getAreaInput() {
        boolean isMatch = true;
        double area = 1;
        while (isMatch) {
            System.out.print("Solve the Area = ");
            try {
                area = scanner.nextDouble();
                isMatch = false;
            } catch (InputMismatchException ex) {
                scanner.next();
                System.out.println("Invalid Input! Please try again.\n");
            }
        }
        return area;
    }

    /*
    Intent: To compare the user answer to the correct area
    Post-condition: calls getAreaInput() method and compares it to the correct area by calling the class getArea method.
                    Displays solution and feedback
     */

    public void compareArea(){
        if (getAreaInput()!= shape.getArea()) {
            System.out.println("Your solution is incorrect!");
        } else {
            System.out.println("Good Job!\n");
        }
    }

}
