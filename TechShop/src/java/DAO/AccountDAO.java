/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account.Role;
import Model.Account.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccountDAO extends DAO.DBConnect.DBContext {

    public int getPermission(String username, String url)
    {
        try {
            String sql = "select count(*) as Total from [User] as u join [Role] as r ON u.r_id = r.r_id join Role_Feature as rf ON rf.r_id = r.r_id\n" +
                    "join Feature as f ON f.f_id = rf.f_id\n" +
                    "where u.email = ? and f.url = ?";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                return rs.getInt("Total");
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public String getPassword(String email) throws Exception {
        try {
            String sql = "SELECT password FROM [User] WHERE email = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String a = rs.getString("password");
                close();

                return a;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }

    public void changePassword(String email, String newPassword) throws Exception {
        String sql = "UPDATE [User]\n"
                + "   SET [password] = ?"
                + "    WHERE email=?";

        try {
            PreparedStatement stm = ps(sql);
            stm.setString(1, newPassword);
            stm.setString(2, email);
            stm.executeUpdate(); //INSERT UPDATE DELETE
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            close();
        }

    }
   
    public User getAccount(String username, String password) {
        try {
            String sql = "SELECT  u.[email],u.[name],u.[password]\n"
                    + "      ,u.r_id,r.r_name\n"
                    + "    FROM [User] u inner join Role r on u.r_id = r.r_id\n"
                    + "                     WHERE u.email = ? AND u.password = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User a = new User();
                
                a.setEmail(rs.getString("email"));
                a.setName(rs.getString("name"));
                a.setPassword(rs.getString("password"));
                Role r = new Role();
                r.setId(rs.getInt("r_id"));
                r.setName(rs.getString("r_name"));
                a.setRole(r);
                close();
                return a;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }
    
    public void insertAccount(User u) {
        String sql1 = "INSERT INTO [User]\n"
                + "           ([email]\n"
                + "           ,[name]\n"
                + "           ,[gender]\n"
                + "           ,[phone]\n"
                + "           ,[address]\n"
                + "           ,[dob]\n"
                + "           ,password,r_id)\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?,?)";

        try {
            PreparedStatement stm1 = ps(sql1);
            stm1.setString(1, u.getEmail());
            stm1.setString(2, u.getName());
            stm1.setBoolean(3, u.isGender());
            stm1.setString(4, u.getPhone());
            stm1.setString(5, u.getAddress());
            stm1.setDate(6, u.getDob());
            stm1.setString(7, u.getPassword());
            stm1.setInt(8, 3);
            stm1.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
    }

    public User getEmail(String email) {
        try {
            String sql = "Select password from [User] WHERE email = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User a = new User();
                a.setPassword(rs.getString("password"));

                close();

                return a;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }

    public void updatePass(User a) {
        String sql = "UPDATE [User]\n"
                + "   SET [password] = ?\n"
                + " WHERE email = ?";

        try {
            PreparedStatement stm = ps(sql);
            stm.setString(1, a.getPassword());
            stm.setString(2, a.getEmail());
            stm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            close();
        }
    }

}
