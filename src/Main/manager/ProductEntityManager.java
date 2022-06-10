package Main.manager;

import Main.App;
import Main.entities.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductEntityManager {

    public static List<ProductEntity> SelectAll() throws SQLException {
        try(Connection c = App.getConnection()) {
            String sql = "SELECT * FROM Product";
            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery(sql);

            List<ProductEntity> list = new ArrayList<>();

            while(rs.next()){
                list.add(new ProductEntity(
                        rs.getInt("ID"),
                        rs.getString("Title"),
                        rs.getString("ProductType"),
                        rs.getString("Description"),
                        rs.getString("Image")
                ));
            }
            return list;
        }
    }

    public static void insert(ProductEntity product) throws SQLException {
        try(Connection c = App.getConnection()) {
            String sql = "INSERT INTO Product(Title,ProductType,Description,Image) VALUES(?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, product.getTitle());
            ps.setString(2, product.getProductType());
            ps.setString(3, product.getDescription());
            ps.setString(4, product.getImagePath());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();

            while(keys.next()){
                product.setId(keys.getInt(1));
            }
        }
    }
}
