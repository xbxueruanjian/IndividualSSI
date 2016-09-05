package xn.core.data.enums;

/**
 * @Description: 序列号TABLE_NAME
 * @author zhangjs
 * @date 2016年8月18日 下午6:27:45
 */
public enum SeqEnum {

    PIG("PP_L_PIG"),
    BILL("PP_M_BILL");
    
    private final String tableName;

    SeqEnum(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
