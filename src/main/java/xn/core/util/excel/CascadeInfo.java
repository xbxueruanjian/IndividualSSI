package xn.core.util.excel;

/**
 * @Description: 级联下拉框隐藏域列信息
 * @author zhangjs
 * @date 2016年9月2日 上午9:46:37
 */
public class CascadeInfo {

    // 隐藏域当前列别名
    private String alias;

    // 当前列的INDEX(XML中一致)
    private String index;

    // 隐藏域当前下拉框对应的数据长度
    private int size;

    // 上一级列的INDEX(XML中一致)
    private String supIndex;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSupIndex() {
        return supIndex;
    }

    public void setSupIndex(String supIndex) {
        this.supIndex = supIndex;
    }

}
