import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductService service = new ProductService();

//        Product p = new Product("Asus Tuf", "Laptop", "Brown Table", 2023);
//
//        service.addProduct(p);

//        service.addProduct(new Product("Asus Tuf", "Laptop", "Brown Table", 2023));
//        service.addProduct(new Product("Asus Notebook", "Laptop", "Brown Table", 2015));
//        service.addProduct(new Product("Redmi 12 5G", "Phone", "Black Table", 2023));
//        service.addProduct(new Product("Redmi Y1", "Phone", "Drawer", 2015));
//        service.addProduct(new Product("Charger 33W", "Charger", "Drawer", 2030));
//        service.addProduct(new Product("iball 16GB Pendant", "Pendrive", "Cupboard Drawer", 2023));
//        service.addProduct(new Product("Sandisk 32GB", "Pendrive", "Cupboard Drawer", 2023));

        List<Product> products = service.getAllProducts();
        for(Product p : products){
            System.out.println(p);
        }
        System.out.println("=====================================================================================================");
//
//        System.out.println("A particular product");
//
//        Product p = service.getProduct("Redmi Y1");
//        System.out.println(p);
//
//        System.out.println("=====================================================================================================");
//
//        System.out.println("Get product by its place");
//        List<Product> p1 = service.getByPlace("Drawer");
//        for(Product p2 : p1){
//            System.out.println(p2);
//        }
//
//        System.out.println("=====================================================================================================");
//        System.out.println("A particular text");
//
//        List<Product> prods = service.getProductWithText("brown");
//        for(Product product : prods){
//            System.out.println(product);
//        }

    }
}