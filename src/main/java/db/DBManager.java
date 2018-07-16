package db;

import root.ProjectProperties;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private final Connection connection;
    private String table_name;

    private static class DBManagerHolder {
        private static final DBManager instance = new DBManager();
    }

    public static DBManager getInstance() {
        return DBManagerHolder.instance;
    }

    private DBManager() {
        this.table_name = ProjectProperties.getInstance().getRds_table_name();
        this.connection = SqliteConnection.getInstance().getConnection();
    }

    public ArrayList<TwitterLink> select(String query) {
        try {
            Statement statement = connection.createStatement();
            String statementQuery = "SELECT * FROM " + table_name +
                    " WHERE DESCRIPTION LIKE '%" + query + "%' " +
                    "OR CONTENT LIKE '%" + query + "%' " +
                    "OR TRACK LIKE '%" + query + "%'";
            System.out.println(statementQuery);
            ResultSet result = statement
                        .executeQuery(statementQuery);
            return parseResult(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TwitterLink> selectAll() {
        try {
            Statement statement = connection.createStatement();
            String statementQuery = "SELECT * FROM " + table_name;
            System.out.println(statementQuery);
            ResultSet result = statement
                    .executeQuery(statementQuery);
            return parseResult(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TwitterLink> parseResult(ResultSet rs) {
        ArrayList<TwitterLink> list = new ArrayList<TwitterLink>();
        try {
            while (rs.next())
            {
                String title = rs.getString(3);
                String content = rs.getString(4);
                String url = rs.getString(5);
                String image_url =rs.getString(6);
                String description = rs.getString(7);
                long timestamp = rs.getLong(8);
                TwitterLink twitterLink = new TwitterLink(title, content, image_url, url, description, timestamp);
                list.add(twitterLink);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }
}
