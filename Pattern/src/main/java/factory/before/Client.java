package factory.before;

/**
 * ClassName: Client
 * Package: factory.before
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午2:52
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}
