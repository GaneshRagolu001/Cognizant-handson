public class SortingTest {

    public static void main(String[] args) {
        Order[] orders = getSampleOrders();

        System.out.println("========= ORIGINAL ORDERS =========");
        System.out.println();
        printOrders(orders);
        System.out.println("===============================");
        System.out.println();

        BubbleSort.sort(orders);
        System.out.println("========= BUBBLE SORT =========");
        System.out.println();
        printOrders(orders);
        System.out.println("===============================");
        System.out.println();

        orders = getSampleOrders();

        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("========= QUICK SORT =========");
        System.out.println();
        printOrders(orders);
    }

    private static Order[] getSampleOrders() {
        return new Order[]{
            new Order(501, "Anil", 3200.0),
            new Order(502, "Divya", 980.0),
            new Order(503, "Suresh", 7500.0),
            new Order(504, "Meena", 5100.0),
            new Order(505, "Vijay", 2400.0)
        };
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            if (order != null) {
                System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + (int) order.getTotalPrice());
                System.out.println();
            }
        }
    }
}
