package product.manager.dao.category;

import product.manager.config.ConnectionSingleton;
import product.manager.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    Connection connection = ConnectionSingleton.getConnection();


//    public static void main(String[] args) {
//        CategoryService categoryService = new CategoryService();
//        System.out.println(categoryService.findAll());
//        Category category = new Category(4, "Loại E");
//        categoryService.insert(category);
//        categoryService.update(category);
//        categoryService.delete(4);
//        System.out.println(categoryService.findById(1));
//    }


    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from category");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idC");
                String name = rs.getString("name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public boolean insert(Category category) {
        boolean rowInsert = false;
        try {
            PreparedStatement ps = connection.prepareStatement("insert into category(name) value (?)");
            ps.setString(1, category.getName());

            rowInsert = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean update(Category category) {
        boolean rowUpdate = false;
        try {
            PreparedStatement ps = connection.prepareStatement("update category set name=? where idC=?");
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            rowUpdate = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from category where idC=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from category where idC=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                category = new Category(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

}
