package factory.factoryMethod;

/**
 * ClassName: AmericanCoffeeFactory
 * Package: factory.factoryMethod
 * Description:
 *  美式咖啡工厂对象，专门用来生产美式咖啡
 * @Author zbc
 * @Create 2024/9/4 下午3:28
 * @Version 1.0
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
