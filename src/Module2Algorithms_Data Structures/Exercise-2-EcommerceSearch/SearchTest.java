public class SearchTest {

    public static void main(String[] args) {
        Product[] products = {
            new Product(301, "Chair", "Furniture"),
            new Product(302, "Desk", "Furniture"),
            new Product(303, "Fan", "Appliances"),
            new Product(304, "Lamp", "Appliances"),
            new Product(305, "Table", "Furniture")
        };

        System.out.println("========= LINEAR SEARCH =========");
        System.out.println();
        System.out.println("Searching Product ID : 303");
        System.out.println();

        Product result1 = LinearSearch.search(products, 303);
        if (result1 != null) {
            System.out.println("Product Found");
            System.out.println();
            System.out.println("ID : " + result1.getProductId());
            System.out.println();
            System.out.println("Name : " + result1.getProductName());
            System.out.println();
            System.out.println("Category : " + result1.getCategory());
        } else {
            System.out.println("Product Not Found");
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println("========= BINARY SEARCH =========");
        System.out.println();
        System.out.println("Searching Product ID : 304");
        System.out.println();

        Product result2 = BinarySearch.search(products, 304);
        if (result2 != null) {
            System.out.println("Product Found");
            System.out.println();
            System.out.println("ID : " + result2.getProductId());
            System.out.println();
            System.out.println("Name : " + result2.getProductName());
            System.out.println();
            System.out.println("Category : " + result2.getCategory());
        } else {
            System.out.println("Product Not Found");
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println("Searching Product ID : 999");
        System.out.println();

        Product result3 = BinarySearch.search(products, 999);
        if (result3 != null) {
            System.out.println("Product Found");
            System.out.println();
            System.out.println("ID : " + result3.getProductId());
            System.out.println();
            System.out.println("Name : " + result3.getProductName());
            System.out.println();
            System.out.println("Category : " + result3.getCategory());
        } else {
            System.out.println("Product Not Found");
        }
    }
}
