package com.taobao.accs;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ErrorCode {
    public static final int ACCS_DISABLEED = -17;
    public static final int APPKEY_NULL = -14;
    public static final int APPRECEIVER_NULL = -16;
    public static final int APPSECRET_NULL = -15;
    public static final int APP_NOT_BIND = 300;
    public static final int AUTH_EXCEPTION = -7;
    public static final int AUTH_PARAM_ERROR = -6;
    public static final int CON_DISCONNECTED = -10;
    public static final int DM_APPKEY_INVALID = 303;
    public static final int DM_DEVICEID_INVALID = 302;
    public static final int DM_PACKAGENAME_INVALID = 304;
    public static final int DM_TAIR_ERROR = 102;
    public static final int MESSAGE_HOST_NULL = -5;
    public static final int MESSAGE_QUEUE_FULL = 70008;
    public static final int MESSAGE_TOO_LARGE = -4;
    public static final int NETWORK_FAIL = -1;
    public static final int NO_NETWORK = -13;
    public static final int PARAMETER_ERROR = -2;
    public static final int PING_TIME_OUT = -12;
    public static final int REQ_TIME_OUT = -9;
    public static final int SERVICE_NOT_AVAILABLE = -3;
    public static final int SERVIER_ANTI_BRUSH = 70022;
    public static final int SERVIER_HIGH_LIMIT = 70021;
    public static final int SERVIER_HIGH_LIMIT_BRUSH = 70023;
    public static final int SERVIER_LOW_LIMIT = 70020;
    public static final int SESSION_NULL = -11;
    public static final int SUCCESS = 200;
    public static final int UNKNOWN_ERROR = -8;

    /* compiled from: Taobao */
    public enum INIT_ERROR {
        NO_NETWORK,
        APPKEY_NULL,
        APPSECRET_NULL,
        APPRECEIVER_NULL,
        REQ_TIME_OUT,
        CONN_INVALID,
        NO_CONNECTTION,
        UNKNOWN_ERROR,
        SERVER_TAIR_ERROR,
        SERVER_DEVICEID_INVALID,
        SERVER_APPKEY_INVALID,
        SERVER_PACKAGENAME_INVALID,
        SUCCESS;

        public int getErrorCode() {
            return ordinal() + 1000;
        }
    }

    public static INIT_ERROR convertError(int i2) {
        INIT_ERROR init_error = INIT_ERROR.UNKNOWN_ERROR;
        if (i2 == -301) {
            return INIT_ERROR.CONN_INVALID;
        }
        if (i2 == -11) {
            return INIT_ERROR.NO_CONNECTTION;
        }
        if (i2 == 102) {
            return INIT_ERROR.SERVER_TAIR_ERROR;
        }
        if (i2 == 200) {
            return INIT_ERROR.SUCCESS;
        }
        if (i2 == -9) {
            return INIT_ERROR.REQ_TIME_OUT;
        }
        if (i2 == -8) {
            return init_error;
        }
        switch (i2) {
            case -16:
                return INIT_ERROR.APPRECEIVER_NULL;
            case -15:
                return INIT_ERROR.APPSECRET_NULL;
            case -14:
                return INIT_ERROR.APPKEY_NULL;
            case -13:
                return INIT_ERROR.NO_NETWORK;
            default:
                switch (i2) {
                    case 302:
                        return INIT_ERROR.SERVER_DEVICEID_INVALID;
                    case 303:
                        return INIT_ERROR.SERVER_APPKEY_INVALID;
                    case 304:
                        return INIT_ERROR.SERVER_PACKAGENAME_INVALID;
                    default:
                        return init_error;
                }
        }
    }

    public static boolean isChannelError(int i2) {
        return i2 == -1 || i2 == -9 || i2 == -11 || i2 == -7;
    }
}
