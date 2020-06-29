/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.utils.enums;

/**
 * [InfoAPI]
 * <p>
 * - CRUD 定義
 * 
 * @author  Asu
 * @since   2020-06-27 11:04
 * @version 
 */
public enum InfoAPI {

    _ADD("add", "add", "新增"),
    _MODIFY("modify", "modify", "修改"),
    _REMOVE("remove", "remove", "刪除"),
    _SEARCH("search", "search", "查詢"),
    _FIND("find", "find", "修改"),
    _CANCEL("cancel", "search", "取消"); // 同等回到查詢

    private String symbol;
    private String url;
    private String name;

    private InfoAPI(String symbol, String url, String name) {
        this.symbol = symbol;
        this.url = url;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
