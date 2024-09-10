package factory.factoryMethod;

/**
 * ClassName: CoffeeStore
 * Package: factory.factoryMethod
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午3:26
 * @Version 1.0
 */
public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addmilk();
        coffee.addsugar();
        return coffee;
    }
}
