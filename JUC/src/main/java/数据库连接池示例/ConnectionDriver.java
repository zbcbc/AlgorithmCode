package 数据库连接池示例;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: ConnectionDriver
 * Package: 数据库连接池示例
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/30 下午5:01
 * @Version 1.0
 */
public class ConnectionDriver implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("commit")) {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        return null;
    }

    // 创建一个 connection 的代理，在commit时休眠100ms
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[] {Connection.class} , new ConnectionHandler());
    }
}

