package strategy;

/**
 * ClassName: OrderItemShare
 * Package: strategy
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/7 下午3:57
 * @Version 1.0
 */
public class OrderItemShare implements ShareStrategy{
    @Override
    public void shareAlgorithm(String param) {
        System.out.println("订单分享");
    }
}
