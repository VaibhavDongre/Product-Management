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
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }

        return null;
    }

    public List<Product> getByPlace(String name){
        List<Product> result = new ArrayList<>();
        for(Product p : products){
            if(p.getPlace().equalsIgnoreCase(name))
                result.add(p);
        }
        return result;
    }

    public List<Product> getProductWithText(String str){
        String text = str.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(text) || type.contains(text) || place.contains(text))
                 prods.add(p);
        }

        return prods;
    }
}
