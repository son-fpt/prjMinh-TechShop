/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Account.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Account.User;

public class UserDAO extends DBContext {

    public User updateCusInfor(String name, String email, String phone, boolean gender) throws Exception {
        String sql = "UPDATE [User_HE151186]\n"
                + "   SET "
                + "      [name] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE [email] = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(4, email);
            st.setString(1, name);
            st.setBoolean(2, gender);
            st.setString(3, phone);
            st.executeUpdate();
            return getUser(email);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return null;
    }

    public ArrayList<User> getUsers() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "select name,gender,email,phone,address,dob,r.r_name\n"
                    + "from [User_HE151186] as u JOIN [Role_HE151186] AS r ON r.r_id = u.r_id  ";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getDate("dob"));
                Role r = new Role();
                r.setName(rs.getString("r_name"));
                user.setRole(r);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return users;
    }

    public User getUser(String email) throws Exception {
        String sql = "SELECT u.email, u.name, u.gender, u.phone,\n"
                + "u.address, u.dob, u.password, r.r_name,r.r_id\n"
                + "from [User_HE151186] as u join [Role_HE151186] as r on u.r_id=r.r_id\n"
                + "where email = ? ";
        try {

            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setEmail(email);
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getDate("dob"));
                user.setPassword(rs.getString("password"));
                Role r = new Role();
                r.setId(rs.getInt("r_id"));
                r.setName(rs.getString("r_name"));
                user.setRole(r);
                close();
                return user;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return null;
    }

    public User updateUserByEmail(User c) throws Exception {
        if (getUser(c.getEmail()) == null) {
            return null;
        }
        String sql = "UPDATE [User_HE151186]\n"
                + "   SET [name] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[dob] = ?\n"
                + " WHERE email like ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, c.getName());
            st.setBoolean(2, c.isGender());
            st.setString(3, c.getPhone());
            st.setString(4, c.getAddress());
            st.setDate(5, c.getDob());
            st.setString(6, c.getEmail());
            st.executeUpdate();
            close();
            return getUser(c.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

        return null;
    }

    public void insertUser(User user) {
        try {
            String sql = "INSERT INTO [User_HE151186]\n"
                    + "           ([email]\n"
                    + "           ,[name]\n"
                    + "           ,[gender]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[dob]\n"
                    + "           ,[password]\n"
                    + "           ,[r_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setString(1, user.getEmail());
            stm.setString(2, user.getName());
            stm.setBoolean(3, user.isGender());
            stm.setString(4, user.getPhone());
            stm.setString(5, user.getAddress());
            stm.setDate(6, user.getDob());
            stm.setString(7, user.getPassword());
            stm.setInt(8, user.getRole().getId());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void updateRole(String email, int role) {
        try {
            String sql = "UPDATE [User_HE151186]\n"
                    + "   SET [r_id] = ?\n"
                    + " WHERE email = ?";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setInt(1, role);
            stm.setString(2, email);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public ArrayList<User> getAllCustomer(Boolean gender) throws Exception {
        ArrayList<User> customers = new ArrayList<>();
        try {
            String sql = "SELECT [email]\n"
                    + "      ,[name]\n"
                    + "      ,[gender]\n"
                    + "      ,[phone]\n"
                    + "      ,[address]\n"
                    + "      ,[dob]\n"
                    + "  FROM [User_HE151186] as u join Role_HE151186 as r on u.r_id=r.r_id\n"
                    + "  WHERE r.[r_name]='Guest' ";
            if (gender != null) {
                sql += " AND [gender] = '" + gender + "' ";
            }
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getDate("dob"));
                customers.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return customers;
    }

    public User getCustomerByEmail(String email) throws Exception {
        String sql = "SELECT [email]\n"
                + "      ,[name]\n"
                + "      ,[gender]\n"
                + "      ,[phone]\n"
                + "      ,[address]\n"
                + "      ,[dob]\n"
                + "  FROM [User_HE151186] as u join Role_HE151186 as r on u.r_id=r.r_id\n"
                + "  WHERE r.[r_name]='Guest' and email like ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getDate("dob"));
                close();
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return null;
    }

}
