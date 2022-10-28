/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBContext {

    protected Connection connection = null;

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    protected Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        return DriverManager.getConnection(url, userID, password);
    }


    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/


    private final String serverName = "LocalHost";
    private final String dbName = "PRJ301_SE1650_TranNhatMinh_HE151186";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";









    public PreparedStatement ps(String sql) throws Exception {
        connection = getConnection();
        return connection.prepareStatement(sql);
    }

    public boolean psExecute(String sql) throws Exception {
        connection = getConnection();
        return connection.prepareStatement(sql).execute();
    }

    public ResultSet rs(String sql) throws Exception {
        return ps(sql).executeQuery();
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {

            System.out.println(ex);
        }
        


    }

//
    public static void main(String[] args) {
        try {
            DBContext dBContext = new DBContext();
            if (dBContext.getConnection() != null) {
                System.out.println("ket noi thanh cong");
            } else {
                System.out.println("ket noi that bai");
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
