/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.utils;

import static tw.com.hyberx.utils.enums.InfoAPI._ADD;
import static tw.com.hyberx.utils.enums.InfoAPI._CANCEL;
import static tw.com.hyberx.utils.enums.InfoAPI._REMOVE;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.ui.Model;

import tw.com.hyberx.utils.enums.InfoAPI;

/**
 * [ControllerUtil]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-27 11:01
 * @version 
 */
public class ControllerUtil {

    public static final String _URL = "/hyberx/mvc/";

    // 拼湊 url
    private static String assembleURL(String controllerName, InfoAPI symbolApi) {
        return _URL + controllerName + "/" + symbolApi.getUrl();
    }

    // 解析 api 成 map
    public static Map<String, Object> setAPIMap(String controllerName, InfoAPI... apis) {
        Map<String, Object> map = new TreeMap<>();
        for (InfoAPI sa : apis) {
            map.put(sa.getSymbol() + "Url", assembleURL(controllerName, sa));
            map.put(sa.getSymbol() + "Name", sa.getName());
        }
        return map;
    }

    // 設定 api 到 model
    public static void setAPI(Model model, String controllerName, InfoAPI... apis) {
        model.addAttribute("apis", setAPIMap(controllerName, apis));
    }

    // test
    public static void main(String[] args) {
        // assembleApi
        System.out.println(ControllerUtil.assembleURL("student", _REMOVE));

        System.out.println(">>>");

        // Map
        Map<String, Object> map = new TreeMap<>();
        map = setAPIMap("student", _ADD, _CANCEL);
        System.out.println(map.get("addUrl"));
        System.out.println(map.get("cancelUrl"));
        System.out.println(map.get("addName"));
        System.out.println(map.get("cancelName"));
    }
}
