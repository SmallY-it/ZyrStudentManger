package Utile;

import java.sql.*;

public class JdbcUtil {
    private String dbUrl="jdbc:mysql://172.16.0.20:3306/Java_Test?useUnicode=true&characterEncoding=UTF-8";
    private String dbUserName="root";
    private String dbPassword="000000";
    private String jdbcName="com.mysql.jdbc.Driver";
    /**
     * @author Ysz
     * @date 2021/11/13 19:03
     * @return:
     * 获取数据库连接对象
     **/
    public Connection GetConn(){
        try {
            Class.forName(jdbcName);
            Connection conn= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Statement statement(Connection connection){
        try {
            Statement statement=connection.createStatement();
            return statement;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @author Ysz
     * @date 2021/11/13 19:10
     * @return:ResultSet
     * 用于返回数据库的查询结果对象
     **/
    public ResultSet SelectresultSet(Connection connection,Statement statement ,String sql){

        try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public boolean UpdataDb(Connection connection,Statement statement ,String sql){

        try {
            statement=connection.createStatement();
            int rs=statement.executeUpdate(sql);
            if (rs==1){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    public void closeLink(Connection connection ,ResultSet resultSet){
        if (connection !=null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (resultSet !=null){
            try {
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
