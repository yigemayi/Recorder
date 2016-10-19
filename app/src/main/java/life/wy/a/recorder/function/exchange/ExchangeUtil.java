package life.wy.a.recorder.function.exchange;

/**
 * Created by wangying on 2016/10/18.
 */

public class ExchangeUtil {

//    http://api.k780.com:88/?app=finance.rate&scur=USD&tcur=CNY&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4";

    private static final String BASE_URL = "http://api.k780.com:88/?app=finance.rate&";

    private static final String APP_KEY_USER = "21317";

    private static final String SIGN_USER = "137085a3579af2267ed1eba6d5c43075";

    private static final String SCUR = "scur=";

    private static final String TCUR = "tcur=";

    private static final String APP_KEY = "appkey=";

    private static final String SIGN = "sign=";

    private static final String FORMAT = "format=";


    /**
     * 获取请求的URL
     *
     * @param source
     * @param target
     * @return
     */
    public static String getRequestUrlString(String source, String target) {

        return createUrlString(source, target).toString();
    }

    /**
     * @param source
     * @param target
     * @param format
     * @return
     */
    public static String getRequestUrlString(String source, String target, String format) {
        StringBuilder stringBuilder = createUrlString(source, target);
        stringBuilder.append("&")
                .append(FORMAT).append(format);
        return stringBuilder.toString();

    }

    // 内部必备参数构造
    private static StringBuilder createUrlString(String source, String target) {
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        stringBuilder.append(SCUR).append(source)
                .append("&")
                .append(TCUR).append(target)
                .append("&")
                .append(APP_KEY).append(APP_KEY_USER)
                .append("&")
                .append(SIGN).append(SIGN_USER);
        return stringBuilder;
    }


}
