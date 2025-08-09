import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection con = null;

    public ProductDB(){
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/vaibhav","postgres", "#J@mesbond007");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product p)  {
        String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4, p.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product";
        try{
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public Product getProduct(String text){
        Product product = null;
        String query = "SELECT name, type, place, warranty FROM product WHERE name = ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, text);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                product = new Product();
                product.setName(rs.getString(1));
                product.setType(rs.getString(2));
                product.setPlace(rs.getString(3));
                product.setWarranty(rs.getInt(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product> getByPlace(String place){
        List<Product> products = new ArrayList<>();
        String query = "SELECT name, type, place, warranty FROM product where place = ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, place);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getByText(String text) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT name, type, place, warranty FROM product " +
                "WHERE LOWER(name) LIKE ? " +
                "OR LOWER(type) LIKE ? " +
                "OR LOWER(place) LIKE ?";
        try {
            PreparedStatement st = con.prepareStatement(query);
            String searchPattern = "%" + text.toLowerCase() + "%";
            st.setString(1, searchPattern);
            st.setString(2, searchPattern);
            st.setString(3, searchPattern);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setPlace(rs.getString("place"));
                p.setWarranty(rs.getInt("warranty"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


}
