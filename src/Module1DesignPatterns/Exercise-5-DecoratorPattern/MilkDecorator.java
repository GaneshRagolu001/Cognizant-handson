public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Adding Milk");
    }
}
