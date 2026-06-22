public class DecoratorPatternTest {

    public static void main(String[] args) {



        System.out.println("\n--- Order 1: Basic Coffee ---");

        Coffee basicCoffee = new BasicCoffee();
        basicCoffee.prepare();

        System.out.println("\n--- Order 2: Coffee + Milk ---");

        Coffee milkCoffee = new MilkDecorator(new BasicCoffee());
        milkCoffee.prepare();

        System.out.println("\n--- Order 3: Coffee + Milk + Sugar ---");

        Coffee sweetMilkCoffee = new SugarDecorator(
                new MilkDecorator(
                        new BasicCoffee()
                )
        );
        sweetMilkCoffee.prepare();


    }
}
