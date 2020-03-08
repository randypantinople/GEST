import java.sql.*;

public class CreateInsertData {
    public static final String DB_NAME = "quiz.db"; // database
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\CS 622\\GEST\\" + DB_NAME; // connect to jdbc

    public static final String TABLE_STUDENTS= "STUDENTS"; // students table
    public static final String COLUMN_STUDENTID = "STUDENT_ID"; // student id column
    public static final String COLUMN_FIRSTNAME= "FIRST_NAME"; // first name column
    public static final String COLUMN_LASTNAME = "LAST_NAME"; // last name column

    public static final String TABLE_SCORES = "SCORES"; // scores table
    public static final String COLUMN_ID = "STUDENT_ID"; // student id column
    public static final String COLUMN_SCORES = "SCORES"; // scores column
    /*
    Intent: to create a table in the database
    Post-condition: Table students is created in the database with columns of student id, first name and lastname
    Post-condition: Table scores is created in the database with columns of student id and scores.
     */
    public void createTable () {
        try( Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement())
        {
            //create a table for students. The columns are student id, first name and last name.
            statement.execute("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_STUDENTS +
                                    "(" + COLUMN_STUDENTID   + " integer PRIMARY KEY, " +
                                          COLUMN_FIRSTNAME + " text, " +
                                           COLUMN_LASTNAME + " text" +
                                            ")" );


            // create a table for scores. The columns are student id and scores
            statement.execute("DROP TABLE IF EXISTS " + TABLE_SCORES);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_SCORES +
                    "(" + COLUMN_ID   + " integer, " +
                    COLUMN_SCORES + " double, " + "FOREIGN KEY (" + COLUMN_ID + ") REFERENCES " + TABLE_STUDENTS +
                    "(" + COLUMN_STUDENTID + ") )" ) ;

        }catch(SQLException ex){
            System.out.println("Something went wrong : " + ex.getMessage());

        }
    }

    /*
    Intent: update data for students table
    Post-condition: New students id, first name and last name were updated in the database
     */
    public  void insertStudent( int id, String firstName, String lastName) {
        String sql = "INSERT INTO " + TABLE_STUDENTS + " (" +
                      COLUMN_STUDENTID + ", " +
                      COLUMN_FIRSTNAME + ", " +
                      COLUMN_LASTNAME +
                     ") VALUES( ? , ? , ?)";

        try( Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            // Column 1 fors student_id, column 2 for first name, column 3 for last name
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Something went wrong : " + ex.getMessage());
        }
    }

    /*
    Intent: update data for scores table
    Post-condition: Students id and scores are updated in the database
     */
    public  void insertScore(int id, double score) {
        String sql = "INSERT INTO " + TABLE_SCORES + " (" +
                COLUMN_ID + ", " +
                COLUMN_SCORES +
                ") VALUES( ?, ? ) ";

        try( Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             //Column 1 for student_id and 2 for scores
             PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, score);
            preparedStatement.executeUpdate();

        }catch(SQLException ex){
            System.out.println("Something went wrong : " + ex.getMessage());

        }
    }
}
