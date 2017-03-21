package by.bsuir.jobproject.util;
/**
 * Created by AR on 12.03.2017.
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DAO {

    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "user";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PROPERTIES_FILE = "/db.properties";

    private Connection connection;

    protected Connection getConnection(){
        if (connection != null)
            return connection;

        InputStream inputStream = DAO.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String url = properties.getProperty(PROPERTY_URL);
            String driver = properties.getProperty(PROPERTY_DRIVER);
            String user = properties.getProperty(PROPERTY_USERNAME);
            String password = properties.getProperty(PROPERTY_PASSWORD);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            throw new DAOException(e);
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
//Пробросить екс выше, метод протект,не статик
        return connection;
    }

    protected void closeConnection(Connection toBeClosed) {
        if (toBeClosed == null)
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}