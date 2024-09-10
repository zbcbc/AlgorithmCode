package 责任链;

/**
 * ClassName: FirstInterview
 * Package: 责任链
 * Description:
 *
 */
public class FirstInterview extends Handler{
    @Override
    public void handleRequest(Integer times) {
        if(times == 1){
            System.out.println("一面" + times);
        }
        handler.handleRequest(times);
    }
}
