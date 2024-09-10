package factory.factoryMethod;

/**
 * ClassName: LatteeCoffeeFactory
 * Package: factory.factoryMethod
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午3:29
 * @Version 1.0
 */
public class LatteeCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
