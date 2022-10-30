/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Order.Order;
import Model.Order.OrderDetail;
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
                    + "  FROM [Orders_HE151186] where email = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOid(rs.getInt("order_id"));
                o.setMail(email);
                o.setDate(rs.getDate("order_date"));
                OrderDetailDAO aO = new OrderDetailDAO();
                o.setOd(aO.getListODByOid(o.getOid()));
                double total = 0;
                for (OrderDetail od : o.getOd()) {
                    total += (od.getPrice() * od.getQuantity());
                }
                o.setTotalmoney(total);
                orders.add(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public void InsertOrder(Order order) {
        try {
            String sql = "INSERT INTO [Orders_HE151186]\n"
                    + "           ([email]\n"
                    + "           ,[order_date]\n"
                    + "           ,[totalmoney])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,convert(date,GETDATE())\n"
                    + "           ,?)";
            PreparedStatement ps = ps(sql);
            ps.setString(1, order.getMail());
            ps.setDouble(2, order.getTotalmoney());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
    }

    public void deleteOrder(int oid) {
        try {
            String sql = "DELETE FROM [Orders_HE151186]\n"
                    + "      WHERE order_id = ?\n"
                    + "DELETE FROM [OrderDetails_HE151186]\n"
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
