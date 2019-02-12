import java.sql.*;

public class Datasource {

    private static final String DB_NAME = "candidates.db";

    private static final String CONNECTION_STATEMENT = "jdbc:sqlite:" + DB_NAME;

    //could change visibility to public if these constants are needed in other classes
    private static final String TABLE_CANDIDATES = "candidates";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE_OF_BIRTH = "dateofbirth";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PROFESSION = "profession";
    private static final String COLUMN_CITY = "city";

    private static final int INDEX_ID = 1;
    private static final int INDEX_NAME = 2;
    private static final int INDEX_EMAIL = 3;
    private static final int INDEX_PHONE = 4;
    private static final int INDEX_DATE_OF_BIRTH = 5;
    private static final int INDEX_PROFESSION = 6;
    private static final int INDEX_CITY = 7;

    private static final String CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS '" + TABLE_CANDIDATES +
            "' ('" + COLUMN_ID + "' INTEGER PRIMARY KEY AUTOINCREMENT, '"+ COLUMN_NAME +
            "' TEXT, '" + COLUMN_EMAIL + "' TEXT, '" + COLUMN_PHONE + "' TEXT, '" +
            COLUMN_DATE_OF_BIRTH + "' TEXT, '" + COLUMN_PROFESSION + "' TEXT, '" +
            COLUMN_CITY + "' TEXT)";

    private Connection conn;

    // singleton instance
    private static Datasource instance = new Datasource();

    // private constructor
    private Datasource() {

    }

    public static Datasource getInstance(){
        return instance;
    }



    //class to open the database and the prepared statements
    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STATEMENT);

            //next 3 lines make a statement to create the table if it doesn't exist, and close it
            Statement initializeIfNotExists = conn.createStatement();
            initializeIfNotExists.executeUpdate(CREATE_TABLE_IF_NOT_EXISTS);
            initializeIfNotExists.close();

           return true;
        } catch (SQLException e){
            System.out.println("Failed to connect to the database: " + e.getMessage());
            return false;
        }
    }

    //close the db conn and the statements
    public void close(){
        try{
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e){
            System.out.println("Error closing the connection: " + e.getMessage());
        }
    }


}
