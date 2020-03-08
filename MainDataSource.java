import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Create an object for QueryData class
        QuerryData querryData = new QuerryData();
        //opens the data
        if(!querryData.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        //call the method queryStudents and make a list of students
        List<Students> students = querryData.queryStudents(2);

        //if no students in the students class
        if(students == null) {
            System.out.println("No students!");
            return;
        }

        //Display all students id, first name and last name. Order by Last name in descending order.
        for(Students student : students) {
            System.out.println("Student ID = " + student.getStudentId() + "\t" +
                                "Last Name = " + student.getLastName() +  "\t" +
                                 "First Name = " + student.getFirstName());
        }

        System.out.println();
        System.out.println("*************Scores for each student***************************");
        System.out.println();

        //call the method queryScoresForEachStudents and make a list
        List<ScoresForEachStudents> scores = querryData.queryScoresForStudents(QuerryData.ORDER_BY_DESC);

        // if it's empty
        if(scores == null){
            System.out.println("No scores");
            return;
        }
        //Display students' first name, last name and scores. Order by scores in descending order
        for(ScoresForEachStudents score : scores){
            System.out.println("First Name = " + score.getFirstName() + "\t" +
                               "Last Name = " + score.getLastName() + "\t" +
                               "Score = " + score.getScore() );
        }

        querryData.close();

    }
}
