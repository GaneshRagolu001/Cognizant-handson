public class BubbleSort {

    public static void sort(Order[] orders) {
        if (orders == null || orders.length < 2) {
            return;
        }

        int n = orders.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                Order current = orders[j];
                Order next = orders[j + 1];

                if (current.getTotalPrice() > next.getTotalPrice()) {
                    orders[j] = next;
                    orders[j + 1] = current;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
