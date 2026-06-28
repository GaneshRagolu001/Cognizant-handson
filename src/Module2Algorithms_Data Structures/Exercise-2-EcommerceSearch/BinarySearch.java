public class BinarySearch {

    public static Product search(Product[] products, int id) {
        if (products == null || products.length == 0) {
            return null;
        }

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            Product midProduct = products[mid];

            if (midProduct == null) {
                return null;
            }

            int midId = midProduct.getProductId();

            if (midId == id) {
                return midProduct;
            }

            if (midId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
