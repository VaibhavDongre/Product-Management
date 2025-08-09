import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();

    public void addProduct(Product p){
/*      products.add(p);
*/
        db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.getAll();
    }

    public Product getProduct(String name){
        return db.getProduct(name);

    }

    public List<Product> getByPlace(String name){
        return db.getByPlace(name);

    }

    public List<Product> getProductWithText(String str){
        String text = str.toLowerCase();
        List<Product> prods = new ArrayList<>();

        return db.getByText(text);
    }
}
