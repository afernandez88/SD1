package start;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
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
     * @param conn
     * @param w
     * @throws Exception
     */
    public static void postWord(Connection conn, Word w) throws Exception{
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
     * Inserts data into the "file" table in the database.
     * @param conn
     * @param file
     * @throws Exception
     */
    public static void postFile(Connection conn, File file) throws Exception{
        final String var1 = file.getName();
        final String var2 = Methods.prettyString(Methods.getTextFromFile(file));
        try{
            //Creating Query
            PreparedStatement posted = conn.prepareStatement("INSERT INTO file (file_name,file_content) " +
                    "VALUE ('"+var1+"', '"+var2+"')");
            //Executing Query
            posted.executeUpdate();
            System.out.println("[Database.postFile] Successfully uploaded " + var1 + " to database.");
        }catch (Exception e){
            System.out.println("[Database.postFile] Unable to upload " + var1 + " to database.");
        }
    } // end post()

    /**
     * Retrieves all words and counts from the database, and puts them into an Observable List
     * that will be presented in the GUI.
     * @param conn
     * @return ObservableList<Word>
     */
    public static ObservableList<Word> readWords(Connection conn){
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
            System.out.println("[Database.read()] Words successfully retrieved from database.");
        }

        return list;
    } // end read()

    /**
     * Retrieves all Text files from the database, and puts them into an Observable List
     * that will be presented in the GUI.
     * @param conn
     * @return ObservableList<Word>
     */
    public static ObservableList<TextFile> readFiles(Connection conn){
        ObservableList<TextFile> list = FXCollections.observableArrayList();
        try{
            //Creating Query
            PreparedStatement statement = conn.prepareStatement("SELECT file_name,file_content FROM file");
            //Executing Query
            ResultSet result = statement.executeQuery();

            int cnt = 0;
            while (result.next()){
                TextFile tf = new TextFile(result.getString("file_name"), result.getString("file_content"));
                list.add(tf);
                cnt++;
            }

            //Sorting the Observable List
            Collections.sort(list, Collections.reverseOrder());

            System.out.println("[Database.read()] " + cnt + " TextFile(s) successfully retrieved from database.");

        }catch (Exception e){
            System.out.println(e);
        }

        return list;
    } // end read()


    /**
     * Used to clear all records in the word table.
     * @param conn
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

    /**
     * Used to clear all records in the file table.
     * @param conn
     * @throws Exception
     */
    public static void clearFiles(Connection conn) throws Exception {
        Statement stmt = conn.createStatement();

        // Use TRUNCATE
        String sql = "TRUNCATE file";
        // Execute deletion
        stmt.executeUpdate(sql);
        // Use DELETE
        sql = "DELETE FROM file";
        // Execute deletion
        stmt.executeUpdate(sql);

        System.out.println("[Database.clearFile] Successfully cleared all files from database.");

    } // end clearTable()

} // end Database
