package factory.factoryMethod;

/**
 * ClassName: Client
 * Package: factory.factoryMethod
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午3:32
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        AmericanCoffeeFactory factory = new AmericanCoffeeFactory();
        store.setFactory(factory);
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());

    }
}
