import java.sql.*;

public class Datasource {

    private static final String DB_NAME = "candidates.db";

    private static final String CONNECTION_STATEMENT = "jdbc:sqlite:" + DB_NAME;

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

    private static final String INSERT_CANDIDATE = "INSERT INTO " + TABLE_CANDIDATES +
            " (" + COLUMN_NAME + ", " + COLUMN_EMAIL + ", " + COLUMN_PHONE + ", " +
            COLUMN_DATE_OF_BIRTH + ", " + COLUMN_PROFESSION + ", " + COLUMN_CITY + ") VALUES (?, ?, ?, ?, ?, ?)";

    private Connection conn;

    private PreparedStatement insertCandidateStatement;

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

            insertCandidateStatement = conn.prepareStatement(INSERT_CANDIDATE);

           return true;
        } catch (SQLException e){
            System.out.println("Failed to connect to the database: " + e.getMessage());
            return false;
        }
    }

    //close the db conn and the statements
    public void close(){
        try{
            if(insertCandidateStatement != null){
                insertCandidateStatement.close();
            }

            if (conn != null){
                conn.close();
            }
        } catch (SQLException e){
            System.out.println("Error closing the connection: " + e.getMessage());
        }
    }


    //inserts a candidate on the database, needs an argument of type Candidate
    //(id will be automatically added in the DB, it's a PrimaryKey and gets auto-incr'ed)
    public boolean insertCandidate(Candidate candidate){
        try {
            //IMPORTANT: Date of birth (dob) format: YYYY-MM-DD, for example 1992-02-23
            insertCandidateStatement.setString(1, candidate.getName());
            insertCandidateStatement.setString(2, candidate.getEmail());
            insertCandidateStatement.setString(3, candidate.getPhone());
            insertCandidateStatement.setString(4, candidate.getDob());
            insertCandidateStatement.setString(5, candidate.getProfession());
            insertCandidateStatement.setString(6, candidate.getCity());

            int affectedRows = insertCandidateStatement.executeUpdate();
            if(affectedRows == 1){
                return true;
            } else {
                throw new SQLException("Error inserting candidate.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //private method to construct the filter to not overpopulate the querying method
    private String constructFilter(String city, String profession, String ageFrom, String ageTo){
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_CANDIDATES);

        if(!city.isEmpty() || !profession.isEmpty() || !ageFrom.isEmpty() || !ageTo.isEmpty()){
            sb.append(" WHERE ");
        }
        if(!city.isEmpty()){
            sb.append("city = '" + city + "'");
        }
        if(!profession.isEmpty()){
            if(!city.isEmpty()){
                sb.append(" AND ");
            }
            sb.append("profession = '" + profession + "'");
        }
        if(!ageFrom.isEmpty()){
            if(!city.isEmpty() || !profession.isEmpty()){
                sb.append(" AND ");
            }
            sb.append("(strftime('%Y', 'now') - strftime('%Y', " + COLUMN_DATE_OF_BIRTH +
                    ")) - (strftime('%m-%d', 'now') < strftime('%m-%d', " + COLUMN_DATE_OF_BIRTH +
                    ")) >= " + ageFrom);
        }
        if(!ageTo.isEmpty()){
            if(!city.isEmpty() || !profession.isEmpty() || !ageFrom.isEmpty()){
                sb.append(" AND ");
            }
            sb.append("(strftime('%Y', 'now') - strftime('%Y', " + COLUMN_DATE_OF_BIRTH +
                    ")) - (strftime('%m-%d', 'now') < strftime('%m-%d', " + COLUMN_DATE_OF_BIRTH +
                    ")) <= " + ageTo);
        }
        sb.append(" ORDER  BY " + COLUMN_NAME);
        return sb.toString();
    }

    //queries the database table based on certain criteria passed as arguments
    public List<Candidate> queryCandidatesByFilters(String city, String profession, String ageFrom, String ageTo){
        List<Candidate> candidates = new ArrayList<>();
        String constructedQuery = constructFilter(city, profession, ageFrom, ageTo);

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(constructedQuery)){

            while(results.next()){
                Candidate candidate = new Candidate();
                candidate.setId(results.getInt(INDEX_ID));
                candidate.setName(results.getString(INDEX_NAME));
                candidate.setEmail(results.getString(INDEX_EMAIL));
                candidate.setPhone(results.getString(INDEX_PHONE));
                candidate.setDob(results.getString(INDEX_DATE_OF_BIRTH));
                candidate.setProfession(results.getString(INDEX_PROFESSION));
                candidate.setCity(results.getString(INDEX_CITY));
                candidates.add(candidate);
            }
        } catch(SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return candidates;
    }


}
