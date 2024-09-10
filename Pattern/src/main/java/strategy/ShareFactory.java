package strategy;

import java.util.HashMap;

/**
 * ClassName: ShareFactory
 * Package: strategy
 * Description:
 *
 * @Author zbc
 * @Create 2024/9/7 下午3:58
 * @Version 1.0
 */

public class ShareFactory {
    enum ShareType{
        SINGLE("single", "单商品"),
        ORDER("order", "订单");

        private String code;
        private String desc;

        ShareType(String code, String desc){
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    private static final HashMap<String, ShareStrategy> map = new HashMap<>();
    static {
        map.put("order", new OrderItemShare());
    }

    public static ShareStrategy getShareStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return map.get(type);
    }

    public static void main(String[] args) {
        String shareType = "order";
        ShareStrategy shareStrategy = ShareFactory.getShareStrategy(shareType);
        shareStrategy.shareAlgorithm("order");
    }

}
