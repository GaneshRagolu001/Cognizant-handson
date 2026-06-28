import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> products;

    public InventoryManager() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product already exists.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product Added Successfully.");
        }
    }

    public void updateProduct(int id, String name, int quantity, double price) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product Updated Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public void deleteProduct(int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Product Deleted Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory Empty");
            return;
        }
        System.out.println("========== INVENTORY ==========");
        System.out.println();
        for (Product product : products.values()) {
            System.out.println(product);
            System.out.println();
        }
    }
}
