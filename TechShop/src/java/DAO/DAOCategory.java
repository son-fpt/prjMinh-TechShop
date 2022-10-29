/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Category.Category;
import DAO.DBConnect.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCategory extends DBContext {

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [cate_id]\n"
                + "      ,[cate_name]\n"
                + "      ,[cate_description]\n"
                + "  FROM [Category_HE151186]";
        try {
            PreparedStatement st = ps(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString("cate_id"),
                        rs.getString("cate_name"),
                        rs.getString("cate_description")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCateById(String id) {
        String sql = "SELECT [cate_id]\n"
                + "      ,[cate_name]\n"
                + "      ,[cate_description]\n"
                + "  FROM [Category_HE151186] WHERE cate_id = ?";
        try {
            PreparedStatement st = ps(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setId(rs.getString(1));
                c.setName(rs.getString(2));
                c.setDes(rs.getString(3));
                return c;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert(Category c) {
        String sql = "INSERT INTO [Category_HE151186]\n"
                + "           ([cate_id]\n"
                + "           ,[cate_name]\n"
                + "           ,[cate_description])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = ps(sql);
            st.setString(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getDes());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public void update(Category c) {
        String sql = "update Category_HE151186 set cate_name =?, cate_description =? where cate_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDes());
            st.setString(3, c.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public void delete(String id) {
        String sql = "delete from Category_HE151186 where cate_id =?";
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
        DAOCategory d = new DAOCategory();
        List<Category> list = d.getAll();
        for (Category category : list) {
            System.out.println(category.toString());
        }
    }
}
