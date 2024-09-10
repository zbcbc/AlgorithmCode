package 责任链;

/**
 * ClassName: Handler
 * Package: 责任链
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/7 下午4:36
 * @Version 1.0
 */
public abstract class Handler {
    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handleRequest(Integer times);
}
