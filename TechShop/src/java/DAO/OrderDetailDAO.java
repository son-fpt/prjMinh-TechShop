/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Order.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDetailDAO extends DBContext {

    public ArrayList<OrderDetail> getListODByOid(int oid) {
        ArrayList<OrderDetail> orders = new ArrayList<>();
        try {
            String sql = "SELECT [order_id]\n"
                    + "      ,[product_id]\n"
                    + "      ,[quantity]\n"
                    + "      ,[price]\n"
                    + "  FROM [OrderDetails_HE151186] where order_id = ?";
            PreparedStatement ps = ps(sql);
            ps.setInt(1, oid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail od = new OrderDetail();
                od.setOid(oid);
                od.setPid(rs.getString("product_id"));
                DAOProduct p = new DAOProduct();
                od.setP(p.getProById(od.getPid()));
                od.setPrice(rs.getDouble("price"));
                od.setQuantity(rs.getInt("quantity"));
                orders.add(od);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public void InsertOD(OrderDetail od) {
        try {
            String sql = "INSERT INTO [OrderDetails_HE151186]\n"
                    + "           ([order_id]\n"
                    + "           ,[product_id]\n"
                    + "           ,[quantity]\n"
                    + "           ,[price])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement ps = ps(sql);
            ps.setInt(1, od.getOid());
            ps.setString(2, od.getPid());
            ps.setInt(3, od.getQuantity());
            ps.setDouble(4, od.getPrice());
            System.out.println(sql);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }
}
