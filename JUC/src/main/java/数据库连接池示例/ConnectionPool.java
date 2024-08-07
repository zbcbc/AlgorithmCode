package 数据库连接池示例;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * ClassName: ConnectionPool
 * Package: 数据库连接池示例
 * Description:
 *  连接池的定义
 * @Author zbc
 * @Create 2024/7/30 下午4:44
 * @Version 1.0
 */
public class ConnectionPool {
    // 双向队列维护连接
    private LinkedList<Connection> pool = new LinkedList<>();

    // 构造函数 初始化连接的最大上限
    public ConnectionPool(int initialSize){
        if(initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    // 将连接放回连接池
    public void releaseConnection(Connection connection) {
        if (connection != null){
            synchronized (pool){
                // 连接释放后需要进行通知，这样其他消费者可以感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    // 超时-等待模式 获取连接
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            // 完全超时
            if (mills <= 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                // 结束时间
                long future = System.currentTimeMillis() + mills;
                // 剩余时间
                long remaining = mills;
                while(pool.isEmpty() && remaining > 0){
                    pool.wait(remaining);
                    //剩余等待时间
                    remaining = future - System.currentTimeMillis();
                }
                //队列为空 or 超时
                Connection res = null;
                if(!pool.isEmpty()){
                    res = pool.removeFirst();
                }
                return res;
            }
        }
    }
}
