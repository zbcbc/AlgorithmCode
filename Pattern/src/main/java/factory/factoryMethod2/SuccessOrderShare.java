package factory.factoryMethod2;

/**
 * ClassName: SuccessOrderShare
 * Package: factory.factoryMethod2
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午4:12
 * @Version 1.0
 */
//@Component
public class SuccessOrderShare implements Share{
    @Override
    public String getShareFunctionType() {
        return ShareFactory.EnumShareType.SUCCESS_ORDER.getName();
    }

    @Override
    public String mainProcess(String shareName) {
        // 处理分享业务的业务逻辑代码
        return shareName;
    }

}
