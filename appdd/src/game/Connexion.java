package game;

import characters.*;
import stuff.*;
import utils.Utils;

import java.sql.*;

public class Connexion {

    private Utils utl;
    private Connection con;

    public Connexion() {

        this.utl = new Utils();
        this.con = null;

    }

    /**
     * Connect to MariaDB
     * @throws SQLException
     */
    public void Connexion() throws SQLException {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/dandd", "root", "hell0w0rld");

        } catch (ClassNotFoundException e) {
            System.out.print(e);
        }

    }

    /**
     * List all saved chars.
     * @return
     * @throws SQLException
     */
    public int displaySaves() throws SQLException {
        Statement stmt = con.createStatement ();
        String query = "select * from Hero";
        boolean status = stmt.execute(query);
        int searchChoice = 0;

        if(status) {
            ResultSet rs = stmt.getResultSet();
            int i = 1;
            while (rs.next()) {
                utl.print("(" + i + ") " + rs.getString("name") + " - class type : " + rs.getString("type"));
                i += 1;
            }

        }
        return searchChoice = utl.intQuestion("Choose a char");
    }

    /**
     * Return loaded char.
     * @param playerChar
     * @return
     * @throws SQLException
     */
    public Characters loadChar(Characters playerChar) throws SQLException {

        playerChar = null;

        int choice = displaySaves();
        Statement stmt = con.createStatement ();
        String query = "select * from Hero";
        boolean status = stmt.execute(query);
        int searchChoice = 0;

        if(status) {
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){

                searchChoice = rs.getInt("id");

                if(searchChoice == choice) {

                    String searchClass = rs.getString("type");

                    switch(searchClass) {
                        case "Warrior":
                            playerChar = new Warrior(rs.getString("name"), new Default(), new Shield(), new Default());
                            break;
                        case "Sorcerer":
                            playerChar = new Sorcerer(rs.getString("name"), new Default(), new Filter(), new Default());
                            break;
                        case "Coconut":
                            playerChar = new Coconut(rs.getString("name"), new Default(), new CoconutSkin(), new Default());
                            break;

                    }
                    playerChar.setCharPosition(rs.getInt("position"));
                }

            }

            rs.close();
        } else {
            utl.print("Empty : no saved game");
        }
        con.close();
        return playerChar;
    }

}

/**
 * finally {
 *             try{
 *                 if(con != null) con.close();
 *             } catch (Exception ex){}
 *         }
 */