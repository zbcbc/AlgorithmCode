package factory.before;

/**
 * ClassName: CoffeeStore
 * Package: factory.before
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午2:50
 * @Version 1.0
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if ("latte".equals(type)){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("没有这种咖啡");
        }

        coffee.addmilk();
        coffee.addsugar();
        return coffee;
    }
}
