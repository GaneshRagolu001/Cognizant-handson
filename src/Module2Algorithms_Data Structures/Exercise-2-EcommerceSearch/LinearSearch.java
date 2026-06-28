public class LinearSearch {

    public static Product search(Product[] products, int id) {
        if (products == null || products.length == 0) {
            return null;
        }

        for (int i = 0; i < products.length; i++) {
            Product currentProduct = products[i];

            if (currentProduct != null && currentProduct.getProductId() == id) {
                return currentProduct;
            }
        }

        return null;
    }
}
