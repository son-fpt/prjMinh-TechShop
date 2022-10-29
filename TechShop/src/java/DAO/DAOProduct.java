/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Product.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOProduct extends DBContext {

    DAOBrand b = new DAOBrand();
    DAOTechnology t = new DAOTechnology();
    DAOCategory c = new DAOCategory();

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [product_id]\n"
                + "      ,[product_name]\n"
                + "      ,[product_image]\n"
                + "      ,[brand_id]\n"
                + "      ,[product_size]\n"
                + "      ,[product_price]\n"
                + "      ,[product_description]\n"
                + "      ,[tech_id]\n"
                + "      ,[cate_id]\n"
                + "  FROM [Product_HE151186]";
        try {
            PreparedStatement st = ps(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getString("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_image"),
                        b.getBrandById(rs.getString("brand_id")),
                        t.getTechById(rs.getString("tech_id")),
                        c.getCateById(rs.getString("cate_id")),
                        rs.getInt("product_size"),
                        rs.getDouble("product_price"),
                        rs.getString("product_description")));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void delete(String id) {
        String sql = "delete from Product_HE151186 where product_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public Product getProById(String id) {

        String sql = "select * from Product_HE151186 where product_id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString("product_id"));
                p.setName(rs.getString("product_name"));
                p.setImage(rs.getString("product_image"));
                p.setBrand(b.getBrandById(rs.getString("brand_id")));
                p.setCate(c.getCateById(rs.getString("cate_id")));
                p.setTech(t.getTechById(rs.getString("tech_id")));
                p.setSize(rs.getInt("product_size"));
                p.setPrice(rs.getDouble("product_price"));
                p.setDes(rs.getString("product_description"));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
        return null;
    }

    public void insert(Product p) {
        String sql = "INSERT INTO [Product_HE151186]\n"
                + "           ([product_id]\n"
                + "           ,[product_name]\n"
                + "           ,[product_image]\n"
                + "           ,[brand_id]\n"
                + "           ,[product_size]\n"
                + "           ,[product_price]\n"
                + "           ,[product_description]\n"
                + "           ,[tech_id]\n"
                + "           ,[cate_id])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getId());
            st.setString(2, p.getName());
            st.setString(3, p.getImage());
            st.setString(4, p.getBrand().getId());
            st.setInt(5, p.getSize());
            st.setDouble(6, p.getPrice());
            st.setString(7, p.getDes());
            st.setString(8, p.getTech().getId());
            st.setString(9, p.getCate().getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public void update(Product p) {
        String sql = "UPDATE [Product_HE151186]\n"
                + "   SET [product_name] = ?\n"
                + "      ,[product_image] = ?\n"
                + "      ,[brand_id] = ?\n"
                + "      ,[product_size] = ?\n"
                + "      ,[product_price] = ?\n"
                + "      ,[product_description] = ?\n"
                + "      ,[tech_id] = ?\n"
                + "      ,[cate_id] = ?"
                + "   WHERE product_id =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getImage());
            st.setString(7, p.getTech().getId());
            st.setString(8, p.getCate().getId());
            st.setString(3, p.getBrand().getId());
            st.setInt(4, p.getSize());
            st.setDouble(5, p.getPrice());
            st.setString(6, p.getDes());
            st.setString(9, p.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public List<Product> searchProduct(String bid_raw, String cid_raw, String tid_raw) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [product_id]\n"
                + "      ,[product_name]\n"
                + "      ,[product_image]\n"
                + "      ,[brand_id]\n"
                + "      ,[product_size]\n"
                + "      ,[product_price]\n"
                + "      ,[product_description]\n"
                + "      ,[tech_id]\n"
                + "      ,[cate_id]\n"
                + "FROM [Product_HE151186]\n";
        // 1 trong 3 truong can search ton tai thi them where vao cau lenh
        if (!"".equals(bid_raw) || !"".equals(cid_raw) || !"".equals(tid_raw)) {
            sql += "WHERE ";
        }
        // neu 1 truong brand ton tai
        if (!"".equals(bid_raw)) {
            sql += " [brand_id] = '" + bid_raw + "'\n";
        }
        // neu brandd va category ton tai
        if (!"".equals(bid_raw) && !"".equals(cid_raw)) {
            sql += "AND [cate_id] = '" + cid_raw + "'\n";
        }
        // neu chi category ton tai
        else if ("".equals(bid_raw) && !"".equals(cid_raw)) {
            sql += " [cate_id] = '" + cid_raw + "'\n";
        }
        // neu 1 trong 2 truong brand, cate ton tai va truong tech ton tai
        if ((!"".equals(bid_raw) || !"".equals(cid_raw)) && !"".equals(tid_raw)) {
            sql += "AND [tech_id] = '" + tid_raw + "'";
        }
        // neu chi truong technology ton tai
        else if ("".equals(bid_raw) && "".equals(cid_raw) && !"".equals(tid_raw)) {
            sql += "[tech_id] = '" + tid_raw + "'";
        }
        try {
            PreparedStatement st = ps(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString("product_id"),
                        rs.getString("product_name"),
                        rs.getString("product_image"),
                        b.getBrandById(rs.getString("brand_id")),
                        t.getTechById(rs.getString("tech_id")),
                        c.getCateById(rs.getString("cate_id")),
                        rs.getInt("product_size"),
                        rs.getDouble("product_price"),
                        rs.getString("product_description")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
