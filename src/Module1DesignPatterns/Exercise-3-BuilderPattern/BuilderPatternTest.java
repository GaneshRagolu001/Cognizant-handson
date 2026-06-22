public class BuilderPatternTest {

    public static void main(String[] args) {


        Pizza margherita = new Pizza.Builder()
                .setSize("Medium")
                .setCrust("Thin Crust")
                .setCheese(true)
                .build();

        System.out.println("\n--- Margherita Pizza ---");
        System.out.println(margherita);

        Pizza pepperoni = new Pizza.Builder()
                .setSize("Large")
                .setCrust("Thick Crust")
                .setCheese(true)
                .setPepperoni(true)
                .build();

        System.out.println("\n--- Pepperoni Pizza ---");
        System.out.println(pepperoni);

        Pizza veggie = new Pizza.Builder()
                .setSize("Small")
                .setCrust("Gluten Free")
                .setCheese(true)
                .setMushrooms(true)
                .build();

        System.out.println("\n--- Veggie Pizza ---");
        System.out.println(veggie);


    }
}
