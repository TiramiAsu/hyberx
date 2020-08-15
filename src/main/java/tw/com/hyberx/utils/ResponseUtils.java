/*
 * 
 * 
 * 
 * 
 * 
 * &copy;TiramiAsu
 * 
 */
package tw.com.hyberx.utils;

import static tw.com.hyberx.utils.tools.StatusCode.*;

import tw.com.hyberx.utils.tools.StatusCode;

/**
 * <pre>
 * [回應工具] 2019-12-24 21:52
 * </pre>
 * 
 * @author TiramiAsu (Email)
 */
public class ResponseUtils {

	public static final int OK = Okey.getCode();
	public static final int SUCCESS = Success_Access.getCode();
	public static final int UNAUTHORIZED = Unauthorized.getCode();
	public static final int VALIDATE_FAIL = Validate_Fail.getCode();
	public static final int ERROR_DATABASE = Error_Database.getCode();
	public static final int ERROR_INPUT = Error_Input.getCode();
	public static final int ERROR_PARSE = Error_Parse.getCode();
	public static final int ERROR_INTERNAL = Error_Internal.getCode();
	public static final int ERROR_UNKNOWN = Error_Unknown.getCode();

	public static final String MSG_OK = Okey.getMsg();
	public static final String MSG_SUCCESS = Success_Access.getMsg();
	public static final String MSG_UNAUTHORIZED = Unauthorized.getMsg();
	public static final String MSG_VALIDATE_FAIL = Validate_Fail.getMsg();
	public static final String MSG_ERROR_DATABASE = Error_Database.getMsg();
	public static final String MSG_ERROR_INPUT = Error_Input.getMsg();
	public static final String MSG_ERROR_PARSE = Error_Parse.getMsg();
	public static final String MSG_ERROR_INTERNAL = Error_Internal.getMsg();
	public static final String MSG_ERROR_UNKNOWN = Error_Unknown.getMsg();
	
	public static final String TOKEN = "";
	
	public static String getMessage(int code) {
		for (StatusCode s : StatusCode.values()) {
			if (s.getCode() == code) {
				return s.getMsg();
			}
		}
		return MSG_ERROR_UNKNOWN;
	}
	
}
