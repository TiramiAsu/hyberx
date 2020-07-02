/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.utils.bean;

import java.util.Map;
import java.util.TreeMap;

/**
 * [API]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-27 11:29
 * @version 
 */
public class API {

    private Map<String, Object> apis = new TreeMap<>();

    public API() {}

    public API(Map<String, Object> apis) {
        this.apis = apis;
    }

    public Map<String, Object> getApis() {
        return apis;
    }

    public void setApis(Map<String, Object> apis) {
        this.apis = apis;
    }
}
