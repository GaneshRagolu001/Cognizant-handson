public class InventoryTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(201, "Rice", 200, 55.0));
        System.out.println();

        manager.addProduct(new Product(202, "Sugar", 150, 42.0));
        System.out.println();

        manager.addProduct(new Product(203, "Cooking Oil", 80, 120.0));
        System.out.println();

        manager.displayProducts();

        manager.updateProduct(202, "Brown Sugar", 100, 60.0);
        System.out.println();

        manager.displayProducts();

        manager.deleteProduct(203);
        System.out.println();

        manager.displayProducts();
    }
}
