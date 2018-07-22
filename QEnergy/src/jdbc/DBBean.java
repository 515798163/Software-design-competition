package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DBBean {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Properties pr = new Properties();
    private DBBean(){}
    static {
        try{
            pr.load(DBBean.class.getClassLoader().getResourceAsStream("config/db.properties"));
            driver=pr.getProperty("driver");
            url=pr.getProperty("url");
            user=pr.getProperty("username");
            password=pr.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,user,password);
    }

    //补充代码
    public static void close(Statement stmt, Connection conn)
    {
        try{
            stmt.close();
            conn.close();
        }
        catch(Exception e){}
    }
}
