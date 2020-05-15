package com.test.mysql;

import com.test.mysql.mapper.User;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @ClassName ExcoteMysql
 * @Description ExcoteMysql
 * @Author liyz
 * @Date 2020/5/15 9:31
 * @Version 1.0
 */
public class ExcoteMysql {

    public <T> T query(String sql,Object param){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
        Connection connection = null;
        Statement statement = null;
        User user = new User();
        try {
            Class.forName(resourceBundle.getString("jdbc.driver"));
            connection = DriverManager.getConnection(resourceBundle.getString("jdbc.url"), resourceBundle.getString("user.name"), resourceBundle.getString("user.powwer"));
            statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery("select * from t_user where id =1");
            ResultSet resultSet = statement.executeQuery(String.format(sql,param));

            while (resultSet.next()) {
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPhone(resultSet.getString("phone"));
                user.setTest(resultSet.getString("test"));
            }
            System.out.println(user.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
