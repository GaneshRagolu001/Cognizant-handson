public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Adding Sugar");
    }
}
