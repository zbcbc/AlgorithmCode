package factory.factoryMethod2;

import java.util.List;

/**
 * ClassName: ShareFactory
 * Package: factory.factoryMethod2
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/4 下午3:56
 * @Version 1.0
 */
//@Component
public class ShareFactory {
//    @Autowired
    private List<Share> shareFunctionList;

    public Share getShareFunction(String type){
        for (Share shareFunction : shareFunctionList) {
            if(shareFunction.getShareFunctionType().equals(type)) {
                return shareFunction;
            }
        }
        return null;
    }

    public enum EnumShareType{
        SUCCESS_ORDER("successOrder");
        private String name;

        EnumShareType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
