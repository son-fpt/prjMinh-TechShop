/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnect.DBContext;
import Model.Brand.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOBrand extends DBContext {

    public List<Brand> getAll() {
        List<Brand> list = new ArrayList<>();
        String sql = "SELECT [brand_id]\n"
                + "      ,[brand_name]\n"
                + "      ,[brand_description]\n"
                + "  FROM [Brand_HE151186]";
        try {
            PreparedStatement st = ps(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Brand(rs.getString("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("brand_description")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Brand getBrandById(String id) {
        String sql = "SELECT [brand_id]\n"
                + "      ,[brand_name]\n"
                + "      ,[brand_description]\n"
                + "  FROM [Brand_HE151186] WHERE brand_id = ?";
        try {
            PreparedStatement st = ps(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Brand b = new Brand();
                b.setId(rs.getString(1));
                b.setName(rs.getString(2));
                b.setDes(rs.getString(3));
                return b;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
        return null;
    }

    public void insert(Brand b) {
        String sql = "INSERT INTO [Brand_HE151186]\n"
                + "           ([brand_id]\n"
                + "           ,[brand_name]\n"
                + "           ,[brand_description])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = ps(sql);
            st.setString(1, b.getId());
            st.setString(2, b.getName());
            st.setString(3, b.getDes());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public void update(Brand b) {
        String sql = "update Brand_HE151186 set brand_name =?, brand_description =? where brand_id=?";
        try {
            PreparedStatement st = ps(sql);
            st.setString(1, b.getName());
            st.setString(2, b.getDes());
            st.setString(3, b.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public void delete(String id) {
        String sql = "delete from Brand_HE151186 where brand_id =?";
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

    public static void main(String[] args) {
        DAOBrand d = new DAOBrand();
//        System.out.println(d.getAll().get(0).getName());
        System.out.println(d.getBrandById("lg"));
    }

}
