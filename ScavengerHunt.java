import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ScavengerHunt {

    private static Scanner scanner = new Scanner(System.in);

    /*
    Intent: Create a list of questions
    Post-condition: reads the text file " questions.txt"
                   : Returns list
     */
    public  List<String> getQuestions() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
                BufferedReader in = new BufferedReader(new FileReader("questions.txt"))){
            while ((str = in.readLine()) != null) {
                list.add(str);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File was not found.....");
        }
        return list;
    }

    /*
    Intent: to create a list of answer key
    Post-condition: reads the text file " answers.txt"
                    : Returns a list
     */
    public  List<Double> getAnswers() throws IOException {
        String dbl;
        List<Double> list = new ArrayList<>();

        try (
                BufferedReader in = new BufferedReader(new FileReader("answers.txt"))){
            while ((dbl = in.readLine()) != null) {
                list.add(Double.parseDouble(dbl));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File was not found.....");
        }
        return list;
    }

    /*
    Intent: to create a list of letters as a code
    Post-condition: reads the text file " letters.txt"
                    : returns a  list
     */
    public  List<String> getLetters() throws IOException {
        String str;
        List<String> list = new ArrayList<>();

        try (
                BufferedReader in = new BufferedReader(new FileReader("letters.txt")) ) {
            while((str =in.readLine())!=null)
                list.add(str);

        } catch (FileNotFoundException ex) {
            System.out.println("File was not found.....");
        }
        return list;
    }

    /*
    Intent: to play the scavenger hunt
    Post-condition: displays the questions for the challenge
                    ask user input to answer
                    validates the answer
                    calls checkCode method
     */
    public  void getChallenge() throws IOException {
        displayMessage();
        System.out.println();

        //creates a list for questions, answers and letters for the code
        List<String> questions = getQuestions();
        List<Double> answers = getAnswers();
        List<String> letters = getLetters();
        ArrayList<String> code = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            boolean isCorrect = true;

            while (isCorrect) {
                System.out.println(questions.get(i));

                boolean isMatch = true;
                double answer = 0;

                // ask user for the answer.
                while(isMatch){
                    System.out.print("Please enter your answer in the nearest hundredth if possible: ");
                    try{
                        answer = scanner.nextDouble();
                        isMatch = false;

                    }catch (InputMismatchException ex){
                        scanner.next();
                        System.out.println("Invalid Answer! Please try again.\n");
                    }
                }

                System.out.println();

                // check the answer. If correct show the code, if not ask to enter a new answer
                if(answer == answers.get(i)){
                    code.add(letters.get(i));
                    System.out.println("That is correct!");
                    System.out.println("Here's your clue for the code: " + code);
                    System.out.println();
                    isCorrect= false;
                }
                else{
                    System.out.println("That is incorrect. Please try again!\n");
                }

            }
        }

        checkCode();
    }

    /*
    Intent: to check the code against the user answer
    Post-condition: checks the code and display a message
     */
    public  void checkCode(){

        String  code = "ALGORITHMS";
        boolean isCorrect = true;
        while(isCorrect){
            System.out.print(" Please enter the code: ");
            String answer = scanner.next();

            if(answer.toUpperCase().equals(code)){
                System.out.println("!!!!!!!!!!CONGRATULATIONS! YOU SUCCESSFULLY CRACK THE CODE!!!!!!!!!!");
                isCorrect = false;
            }
            else{
                System.out.println("The code is incorrect. Please try again.");
            }
        }
    }

    
    public  void displayMessage () {
        System.out.println("*********SCAVENGER HUNT**********");
        System.out.println("You have 10 ten questions to answer.\n");
        System.out.println("Each correct answer correspond to a letter that will form a ten-letter word.\n" +
                "You need to re-arrange the letters to crack the code\n");
        System.out.println("Good Luck and Have Fun!!!!!!!!");
    }

}

