/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Account.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RoleDAO extends DBContext{
    public ArrayList<Role> getRoles(){
        ArrayList<Role> roles = new ArrayList<>();
        try {
            String sql = "select r_id,r_name from [Role]";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Role r = new Role();
                r.setId(rs.getInt("r_id"));
                r.setName(rs.getString("r_name"));
                roles.add(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return roles;
    }
    public Role getRoles(int id){
        try {
            String sql = "select r_id,r_name from [Role]\n"
                    + "where r_id = ? ";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Role r = new Role();
                r.setId(rs.getInt("r_id"));
                r.setName(rs.getString("r_name"));
                return r;
            }
        } catch (Exception ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            close();
        }
        return null;
    }
    
    public void updateAccountRole(int role,int id){
        try {
            String sql = "UPDATE [Account]\n"
                    + "   SET [r_id] = ?\n"
                    + " WHERE email = (select email from [User]\n"
                    + "where id = ?)";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setInt(1, role);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
    }

}
