package factory.before;

/**
 * ClassName: Coffee
 * Package: factory.before
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午2:48
 * @Version 1.0
 */
public abstract class Coffee {

    public abstract String getName();

    public void addsugar(){
        System.out.println("加糖");
    }
    public void addmilk(){
        System.out.println("加奶");
    }
}
