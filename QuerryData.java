import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuerryData {
    public static final String DB_NAME = "quiz.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\CS 622\\GEST\\" + DB_NAME;


    public static final String TABLE_STUDENTS = "STUDENTS";

    public static final String COLUMN_STUDENTID = "STUDENT_ID";
    public static final String COLUMN_FIRSTNAME = "FIRST_NAME";
    public static final String COLUMN_LASTNAME = "LAST_NAME";
    public static final int STUDENT_ID_INDEX = 1;
    public static final int FIRST_NAME_INDEX = 2;
    public static final int LAST_NAME_INDEX = 3;

    public static final String TABLE_SCORES = "SCORES";

    public static final String COLUMN_ID = "STUDENT_ID";
    public static final String COLUMN_SCORES = "SCORES";
    public static final int ID_INDEX = 1;
    public static final int SCORES_INDEX = 2;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_DESC = 2;
    public static final int ORDER_BY_ASC = 3;

    public static final String QUERY_FOR_STUDENTS = "SELECT " + " * " + " FROM " + TABLE_STUDENTS;
    public static final String QUERY_FOR_STUDENTS_SORT = " ORDER  BY " + LAST_NAME_INDEX + " COLLATE NOCASE ";

    //query to inner join students and scores tables on student_id
    public static final String QUERY_SCORES_FOR_STUDENTS = "SELECT " + COLUMN_FIRSTNAME + ", "  + COLUMN_LASTNAME + ", " + COLUMN_SCORES +
            " FROM " + TABLE_STUDENTS + " INNER JOIN " +
            TABLE_SCORES + " ON " + TABLE_STUDENTS + "." + COLUMN_STUDENTID +
            " = " + TABLE_SCORES + "." + COLUMN_ID;

    //order by scores
    public static final String QUERY_SCORES_FOR_STUDENTS_SORT = " ORDER BY " + COLUMN_SCORES + " ";


    private Connection conn;

    /*
    Intent: to connect database
    Post-condition: Returns true if database can  be open, false if otherwise.
     */
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    /*
    Intent: To close database
    Post-condition: Returns true if the database can be open, false is otherwise.
     */
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }
    /*
    Intent: To query from a database and make a list
    Post-condition: Returns a list of students
     */
    public List<Students> queryStudents(int sortOrder) {
        //query for students with with id, first name and last name.
        StringBuilder sb = new StringBuilder(QUERY_FOR_STUDENTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_FOR_STUDENTS_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            // create an object for students
            List<Students> students = new ArrayList<>();

            //update students id, first name and last name
            while (results.next()) {
                Students student = new Students();
                student.setStudentId(results.getInt(STUDENT_ID_INDEX));
                student.setFirstName(results.getString(FIRST_NAME_INDEX));
                student.setLastName(results.getString(LAST_NAME_INDEX));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    /*
    Intent: To query  two tables from the database and make a list.
    Post-condition: Returns a list of scores for each students
     */
    public List<ScoresForEachStudents> queryScoresForStudents(int sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_SCORES_FOR_STUDENTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_SCORES_FOR_STUDENTS_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {
            //create a list of scores for each students
            List<ScoresForEachStudents> studentScores = new ArrayList<>();

            while (results.next()) {
                ScoresForEachStudents score = new ScoresForEachStudents();

                //update the class with first name, last name and scores.
                score.setFirstName(results.getString(COLUMN_FIRSTNAME));
                score.setLastName(results.getString(COLUMN_LASTNAME));
                score.setScore(results.getDouble(COLUMN_SCORES));
                studentScores.add(score);
            }
            return studentScores;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }


    }
}
