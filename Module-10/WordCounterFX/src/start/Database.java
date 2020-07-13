package start;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Collections;

/**
 * Methods used for interacting with the database.
 *
 * @author Andre Fernandez
 */

public class Database {

    /**
     * Starts the connection to the database.
     * @return Connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/word_occurrences";
            String username = "root";
            String password = "password";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("[Database.getConnection()] Successful connection to database.");
            return conn;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    } // end getConnection()


    /**
     * Inserts data into the "word" table in the database.
     * @throws Exception
     */
    public static void post(Connection conn, Word w) throws Exception{
        final String var1 = w.getText();
        final int var2 = w.count;
        try{
            //Creating Query
            PreparedStatement posted = conn.prepareStatement("INSERT INTO word (text,count) " +
                    "VALUE ('"+var1+"', '"+var2+"')");
            //Executing Query
            posted.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    } // end post()


    /**
     * Retrieves all words and counts from the database, and puts them into an Observable List
     * that will be presented in the GUI.
     * @param conn
     * @return ObservableList<Word>
     */
    public static ObservableList<Word> read(Connection conn){
        ObservableList<Word> list = FXCollections.observableArrayList();
        try{
            //Creating Query
            PreparedStatement statement = conn.prepareStatement("SELECT text,count FROM word");
            //Executing Query
            ResultSet result = statement.executeQuery();

            while (result.next()){
                Word w = new Word(result.getString("text"), result.getInt("count"));
                list.add(w);
            }

            //Sorting the Observable List
            Collections.sort(list, Collections.reverseOrder());

        }catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("[Database.read()] Data successfully retrieved from database.");
        }

        return list;
    } // end read()


    /**
     * Clears the "word" table in the database.
     * @throws Exception
     */
    public static void clearTable(Connection conn) throws Exception {
        Statement stmt = conn.createStatement();

        // Use TRUNCATE
        String sql = "TRUNCATE word";
        // Execute deletion
        stmt.executeUpdate(sql);
        // Use DELETE
        sql = "DELETE FROM word";
        // Execute deletion
        stmt.executeUpdate(sql);

        System.out.println("[Database.clearTable] Successfully flushed word table.");

    } // end clearTable()

} // end Database
