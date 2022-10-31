/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Order.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO extends DBContext {

    public ArrayList<Order> getOrderByUser(String email) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT [order_id]\n"
                    + "      ,[email]\n"
                    + "      ,[order_date]\n"
                    + "      ,[totalmoney]\n"
                    + "     ,[status]\n"
                    + "  FROM [Orders_HE151186] where email = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOid(rs.getInt("order_id"));
                o.setMail(email);
                OrderDetailDAO od = new OrderDetailDAO();
                o.setOd(od.getListODByOid(o.getOid()));
                o.setDate(rs.getDate("order_date"));
                o.setTotalmoney(rs.getDouble("totalmoney"));
                o.setStatus(rs.getBoolean("status"));
                orders.add(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }
    
    public Order getTotalOrder( String mail){
        try {
            String sql = "SELECT [order_id]\n"
                    + "      ,[email]\n"
                    + "      ,[order_date]\n"
                    + "      ,[totalmoney]\n"
                    + "     ,[status]\n"
                    + "  FROM [Orders_HE151186] where order_date = convert(date,GETDATE())\n"
                    + "And email = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOid(rs.getInt("order_id"));
                o.setMail(rs.getString("email"));
                o.setDate(rs.getDate("order_date"));
                o.setTotalmoney(rs.getDouble("totalmoney"));
                o.setStatus(rs.getBoolean("status"));
                OrderDetailDAO od = new OrderDetailDAO();
                o.setOd(od.getListODByOid(o.getOid()));
                return o;
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void InsertOrder(Order order) {
        try {
            String sql = "INSERT INTO [Orders_HE151186]\n"
                    + "           ([email]\n"
                    + "           ,[order_date]\n"
                    + "           ,[totalmoney])\n"
                    + "           ,[status]\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,convert(date,GETDATE())\n"
                    + "           ,?"
                    + "           ,?)";
            PreparedStatement ps = ps(sql);
            ps.setString(1, order.getMail());
            ps.setDouble(2, order.getTotalmoney());
            ps.setBoolean(3, false);
            System.out.println(sql);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void UpdateTotalprice(double price, int oid) {
        try {
            String sql = "UPDATE [Orders_HE151186]\n"
                    + "   SET [totalmoney] = ?\n"
                    + " WHERE order_id = ?";
            PreparedStatement ps = ps(sql);
            ps.setDouble(1, price);
            ps.setInt(2, oid);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
    
    public void UpdatePayStatus(boolean status, int oid) {
        try {
            String sql = "UPDATE [Orders_HE151186]\n"
                    + "   SET [status] = ?\n"
                    + " WHERE order_id = ?";
            PreparedStatement ps = ps(sql);
            ps.setBoolean(1, status);
            ps.setInt(2, oid);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void deleteOrder(int oid) {
        try {
            String sql = "DELETE FROM [OrderDetails_HE151186]\n"
                    + "      WHERE order_id = ?\n"
                    + "DELETE FROM [Orders_HE151186]\n"
                    + "      WHERE order_id = ?";
            PreparedStatement ps = ps(sql);
            ps.setInt(1, oid);
            ps.setInt(2, oid);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
}
