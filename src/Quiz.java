import DataSource.CreateInsertData;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.IntStream;

public class Quiz {

    /* Intent: to collect answers from the user.
    Post-condition : a list of questions will be collected from getQuestions() method.
                   : returns a list of answers from the user
     */
    public  List<Double> getUserAnswer() {
        List<QuizQuestions> questions = getQuestions();
        List<Double> userAnswer = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (QuizQuestions question : questions) {
            System.out.println(question);
            System.out.print("Answer(round to the nearest hundredth): ");
            double answer = scanner.nextDouble();
            System.out.println();
            userAnswer.add(answer);
        }
        return userAnswer;
    }

    /*
    Intent: To create a list of double value as an answer key
    Post-condition: returns a list of double values as an answer key
     */
    public  List<Double> getAnswerKey(){

        //add all answer in the ansewer key
        List<Double> answerKey = new ArrayList<>();
        answerKey.add(60.0);
        answerKey.add(56.52);
        answerKey.add(6.0);
        answerKey.add(300.0);
        answerKey.add(90.0);
        answerKey.add(68.0);
        answerKey.add(24.0);
        answerKey.add(48.0);
        answerKey.add(52.0);
        answerKey.add(314.0);

        return answerKey;
    }

    /*
    Intent: to give the quiz to the user, collect the answer and grade them.
    Post-condition : answers from the user will be collected from getUserAnswer() method.
                    : answer key will be collected from getAnswerKey() method.
                    : returns the grade and show answers that are correct
     */
    public double gradeTheQuiz() throws SQLException {
        message();

        //get user id, first name and last name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your student id: ");
        int id = scanner.nextInt();
        System.out.print("Please enter your first name: ");
        String firstName = scanner.next();
        System.out.print("Please enter your last name: ");
        String lastName = scanner.next();
        System.out.println();

        //create an instance of sqldata and call the method insertStudents to store the data in the quiz.db database
        CreateInsertData data = new CreateInsertData();
        data.insertStudent(id,  firstName, lastName);

        //get the answer from the user and make a list
        List<Double> userAnswer = getUserAnswer();

        //get the answer key
        List<Double> answerKey = getAnswerKey();

        // create a stream of integers from 0 t0 9
        double score = IntStream.range(0, userAnswer.size())
                                //compare if the user answer matches the key and create a new stream of correct answers
                                .filter(x->(userAnswer.get(x).compareTo(answerKey.get(x))==0))
                                // display all correct answers from the stream
                                .peek(x-> System.out.println("Correct Answer : question " + (x +1) + " : " + userAnswer.get(x)))
                                // count all correct answers and multply by 10 to get the score
                                .count() * 10;

        //store the score in the data base quiz.db
        data.insertScore(id, score);

        System.out.println();
        // display the score
        System.out.println("Your score is " + score + "%");
        System.out.println();

        return score;
    }

    /*
    Intent: write and read questions to and from the binary file.
    Post-condition : returns a list of questions
     */
    public List<QuizQuestions> getQuestions() {
        List<QuizQuestions> questions = new ArrayList<>();
        try {
            try (ObjectOutputStream outfile = new ObjectOutputStream(new
                    FileOutputStream("quizQuestions.dat"));) {
                outfile.writeObject(new QuizQuestions("1.Given: Rectangle{base = 10 , height = 6}. Find the area."));
                outfile.writeObject(new QuizQuestions("2.Given: Circle{radius = 3}. Find the circumference ."));
                outfile.writeObject(new QuizQuestions("3.Given: Right Triangle{base = 3 , height = 4, hypotenuse= 5}. Find the area."));
                outfile.writeObject(new QuizQuestions("4.Given: Parallelogram{base = 20 , height = 15, slant height = 10}. Find the area."));
                outfile.writeObject(new QuizQuestions("5.Given: Trapezoid{base1 = 12 , base2 = 8, height = 9, slant side1 = 10, slant side 2= 10}. Find the area."));
                outfile.writeObject(new QuizQuestions("6.Given: Square{ side = 17}. Find the perimeter."));
                outfile.writeObject(new QuizQuestions("7.Given: Right Triangle{ base = 6, height = 8, hypotenuse = 10 }. Find the perimeter."));
                outfile.writeObject(new QuizQuestions("8.Given: Parallelogram{ base = 18 , height = 16, slant height= 6}. Find the perimeter."));
                outfile.writeObject(new QuizQuestions("9.Given: Rectangle{ base = 11 , height = 15}. Find the perimeter."));
                outfile.writeObject(new QuizQuestions("10.Given: Circle{ radius = 10}. Find the area."));
            }

            try (ObjectInputStream infile = new ObjectInputStream(new
                    FileInputStream("quizQuestions.dat"));) {
                while (true) {
                    questions.add((QuizQuestions) (infile.readObject()));
                }
            }
        } catch (EOFException ex) {
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IOException");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
            ex.printStackTrace();
        }
        return questions;
    }


    public void message(){
        System.out.println();
        System.out.println("******************** QUIZ SECTION ********************");
        System.out.println("Each question is worth 10 %. Your grade as well as your correct answers will be shown at the end");
        System.out.println("Good Luck!\n");
    }
}


class QuizQuestions implements Serializable {

    String questions;

    public QuizQuestions(String questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Question  " + questions;
    }

}







