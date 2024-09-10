package factory.factoryMethod2;

/**
 * ClassName: Share
 * Package: factory.factoryMethod2
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午3:54
 * @Version 1.0
 */
public interface Share {
    // 获取分享类型
    String getShareFunctionType();

    // shareName
    String mainProcess(String shareName);
}
