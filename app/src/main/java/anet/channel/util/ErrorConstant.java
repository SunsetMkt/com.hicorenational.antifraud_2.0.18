package anet.channel.util;

import android.util.SparseArray;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ErrorConstant {
    public static final int ERROR_ACCS_CUSTOM_FRAME_CB_NULL = -105;
    public static final int ERROR_AUTH_EXCEPTION = -302;
    public static final int ERROR_CONNECT_EXCEPTION = -406;
    public static final int ERROR_CONN_TIME_OUT = -400;
    public static final int ERROR_DATA_LENGTH_NOT_MATCH = -206;
    public static final int ERROR_DATA_TOO_LARGE = -303;
    public static final int ERROR_EXCEPTION = -101;
    public static final int ERROR_GET_PROCESS_NULL = -108;
    public static final int ERROR_HOST_NOT_VERIFY_ERROR = -403;
    public static final int ERROR_IO_EXCEPTION = -404;
    public static final int ERROR_NO_NETWORK = -200;
    public static final int ERROR_NO_STRATEGY = -203;

    @Deprecated
    public static final int ERROR_OPEN_CONNECTION_NULL = -407;
    public static final int ERROR_PARAM_ILLEGAL = -102;
    public static final int ERROR_REMOTE_CALL_FAIL = -103;
    public static final int ERROR_REQUEST_CANCEL = -204;
    public static final int ERROR_REQUEST_FAIL = -201;
    public static final int ERROR_REQUEST_FORBIDDEN_IN_BG = -205;
    public static final int ERROR_REQUEST_TIME_OUT = -202;
    public static final int ERROR_SESSION_INVALID = -301;
    public static final int ERROR_SOCKET_TIME_OUT = -401;
    public static final int ERROR_SSL_ERROR = -402;
    public static final int ERROR_TNET_EXCEPTION = -300;
    public static final int ERROR_TNET_REQUEST_FAIL = -304;
    public static final int ERROR_UNKNOWN = -100;
    public static final int ERROR_UNKNOWN_HOST_EXCEPTION = -405;
    public static final int SC_OK = 200;
    private static SparseArray<String> errorMsgMap = new SparseArray<>();

    static {
        errorMsgMap.put(200, "\u8bf7\u6c42\u6210\u529f");
        errorMsgMap.put(-100, "\u672a\u77e5\u9519\u8bef");
        errorMsgMap.put(-101, "\u53d1\u751f\u5f02\u5e38");
        errorMsgMap.put(-102, "\u975e\u6cd5\u53c2\u6570");
        errorMsgMap.put(-103, "\u8fdc\u7a0b\u8c03\u7528\u5931\u8d25");
        errorMsgMap.put(-105, "ACCS\u81ea\u5b9a\u4e49\u5e27\u56de\u8c03\u4e3a\u7a7a");
        errorMsgMap.put(ERROR_GET_PROCESS_NULL, "\u83b7\u53d6Process\u5931\u8d25");
        errorMsgMap.put(ERROR_NO_NETWORK, "\u65e0\u7f51\u7edc");
        errorMsgMap.put(ERROR_NO_STRATEGY, "\u65e0\u7b56\u7565");
        errorMsgMap.put(ERROR_REQUEST_TIME_OUT, "\u8bf7\u6c42\u8d85\u65f6");
        errorMsgMap.put(ERROR_REQUEST_CANCEL, "\u8bf7\u6c42\u88ab\u53d6\u6d88");
        errorMsgMap.put(ERROR_REQUEST_FORBIDDEN_IN_BG, "\u8bf7\u6c42\u540e\u53f0\u88ab\u7981\u6b62");
        errorMsgMap.put(ERROR_DATA_LENGTH_NOT_MATCH, "\u8bf7\u6c42\u6536\u5230\u7684\u6570\u636e\u957f\u5ea6\u4e0eContent-Length\u4e0d\u5339\u914d");
        errorMsgMap.put(ERROR_TNET_EXCEPTION, "Tnet\u5c42\u629b\u51fa\u5f02\u5e38");
        errorMsgMap.put(ERROR_SESSION_INVALID, "Session\u4e0d\u53ef\u7528");
        errorMsgMap.put(ERROR_AUTH_EXCEPTION, "\u9274\u6743\u5f02\u5e38");
        errorMsgMap.put(ERROR_DATA_TOO_LARGE, "\u81ea\u5b9a\u4e49\u5e27\u6570\u636e\u8fc7\u5927");
        errorMsgMap.put(ERROR_TNET_REQUEST_FAIL, "Tnet\u8bf7\u6c42\u5931\u8d25");
        errorMsgMap.put(ERROR_CONN_TIME_OUT, "\u8fde\u63a5\u8d85\u65f6");
        errorMsgMap.put(ERROR_SOCKET_TIME_OUT, "Socket\u8d85\u65f6");
        errorMsgMap.put(ERROR_SSL_ERROR, "SSL\u5931\u8d25");
        errorMsgMap.put(ERROR_HOST_NOT_VERIFY_ERROR, "\u57df\u540d\u672a\u8ba4\u8bc1");
        errorMsgMap.put(-404, "IO\u5f02\u5e38");
        errorMsgMap.put(ERROR_UNKNOWN_HOST_EXCEPTION, "\u57df\u540d\u4e0d\u80fd\u89e3\u6790");
        errorMsgMap.put(ERROR_CONNECT_EXCEPTION, "\u8fde\u63a5\u5f02\u5e38");
    }

    public static String formatMsg(int i2, String str) {
        return StringUtils.concatString(getErrMsg(i2), Constants.COLON_SEPARATOR, str);
    }

    public static String getErrMsg(int i2) {
        return StringUtils.stringNull2Empty(errorMsgMap.get(i2));
    }
}
