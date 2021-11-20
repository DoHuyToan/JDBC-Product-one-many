package product.manager.dao.product;

import product.manager.config.ConnectionSingleton;
import product.manager.dao.category.CategoryService;
import product.manager.model.Category;
import product.manager.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private Connection connection = ConnectionSingleton.getConnection();
    private CategoryService categoryService = new CategoryService();



//    public static void main(String[] args) {
//        ProductService productService = new ProductService();
//        Category category = new Category(1,"Loại A");
//        Product product = new Product(6, "Xiaomi", 15000, 10, "yellow", "halfnew", category );
//        productService.insert(product);
//        System.out.println(productService.findAll());
//        productService.update(product);
//        productService.delete(6);
//        System.out.println(productService.findById(1));
//    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idP");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int idC = rs.getInt("idC");
                Category category = categoryService.findById(idC);
                productList.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean insert(Product product) {
        boolean rowInsert = false;
        try {
            PreparedStatement ps = connection.prepareStatement("insert into product (name, price, quantity, color, description) value (?,?,?,?,?)");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescription());
            rowInsert = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public boolean update(Product product) {
        boolean rowUpdate = false;
        try {
            PreparedStatement ps = connection.prepareStatement("update product set name=?, price=?, quantity=?, color=?, description=?, idC=? where idP=?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getCategory().getId());
            ps.setInt(7, product.getId());
            rowUpdate = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from product where idP=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from product where idP=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int idC = rs.getInt("idC");
                Category category = categoryService.findById(idC);
                product= new Product(name, price, quantity, color, description, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
