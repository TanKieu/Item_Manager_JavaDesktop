/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.daos;
import java.sql.Connection;
import hoadnt.dtos.UserDTO;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author winnh
 */
public class UserDAO {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return (Connection) DriverManager.getConnection("jdbc:sqlserver://SE141107\\SQLEXPRESS:1433; databaseName= ItemManagement;user=sa; password=123");
    }
    public static String getUserByUserName(String userID, String pass)throws Exception{
        try(Connection c = openConnection(); PreparedStatement ps= c.prepareStatement("Select userID from tblUsers where userID=? COLLATE SQL_Latin1_General_CP1_CS_AS and password=? COLLATE SQL_Latin1_General_CP1_CS_AS");){
            ps.setString(1, userID);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getString("userID");
            }
            return null;
        }
    }
}
