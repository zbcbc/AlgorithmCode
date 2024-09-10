package factory.lockAOPFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: MyLock
 * Package: factory.lockAOPFactory
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/5 下午1:50
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyLock {
    String name();
    long waitTime() default 1;
    long leaseTime() default -1;
    TimeUnit unit() default TimeUnit.SECONDS;

    MyLockType lockType() default MyLockType.RE_ENTRANT_LOCK;
}
