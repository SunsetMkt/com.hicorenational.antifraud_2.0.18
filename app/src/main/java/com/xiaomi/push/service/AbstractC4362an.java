package com.xiaomi.push.service;

/* renamed from: com.xiaomi.push.service.an */
/* loaded from: classes2.dex */
public abstract class AbstractC4362an {

    /* renamed from: A */
    public static String f16581A = "ext_auth_method";

    /* renamed from: B */
    public static String f16582B = "ext_security";

    /* renamed from: C */
    public static String f16583C = "ext_kick";

    /* renamed from: D */
    public static String f16584D = "ext_client_attr";

    /* renamed from: E */
    public static String f16585E = "ext_cloud_attr";

    /* renamed from: F */
    public static String f16586F = "ext_pkg_name";

    /* renamed from: G */
    public static String f16587G = "ext_notify_id";

    /* renamed from: H */
    public static String f16588H = "ext_clicked_button";

    /* renamed from: I */
    public static String f16589I = "ext_notify_type";

    /* renamed from: J */
    public static String f16590J = "ext_session";

    /* renamed from: K */
    public static String f16591K = "sig";

    /* renamed from: L */
    public static String f16592L = "ext_notify_title";

    /* renamed from: M */
    public static String f16593M = "ext_notify_description";

    /* renamed from: N */
    public static String f16594N = "ext_messenger";

    /* renamed from: O */
    public static String f16595O = "title";

    /* renamed from: P */
    public static String f16596P = "description";

    /* renamed from: Q */
    public static String f16597Q = "notifyId";

    /* renamed from: R */
    public static String f16598R = "dump";

    /* renamed from: a */
    public static String f16599a = "1";

    /* renamed from: b */
    public static String f16600b = "2";

    /* renamed from: c */
    public static String f16601c = "3";

    /* renamed from: d */
    public static String f16602d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e */
    public static String f16603e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f */
    public static String f16604f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g */
    public static String f16605g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h */
    public static String f16606h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i */
    public static String f16607i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j */
    public static String f16608j = "com.xiaomi.push.FORCE_RECONN";

    /* renamed from: k */
    public static String f16609k = "com.xiaomi.push.RESET_CONN";

    /* renamed from: l */
    public static String f16610l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* renamed from: m */
    public static String f16611m = "com.xiaomi.push.SEND_STATS";

    /* renamed from: n */
    public static String f16612n = "com.xiaomi.push.HANDLE_FCM_MSG";

    /* renamed from: o */
    public static String f16613o = "com.xiaomi.push.APP_NOTIFY_MSG";

    /* renamed from: p */
    public static String f16614p = "com.xiaomi.push.CHANGE_HOST";

    /* renamed from: q */
    public static String f16615q = "com.xiaomi.push.PING_TIMER";

    /* renamed from: r */
    public static String f16616r = "com.xiaomi.push.APP_CHANNEL_SWITCH";

    /* renamed from: s */
    public static String f16617s = "ext_user_id";

    /* renamed from: t */
    public static String f16618t = "ext_user_server";

    /* renamed from: u */
    public static String f16619u = "ext_user_res";

    /* renamed from: v */
    public static String f16620v = "ext_chid";

    /* renamed from: w */
    public static String f16621w = "ext_receive_time";

    /* renamed from: x */
    public static String f16622x = "ext_broadcast_time";

    /* renamed from: y */
    public static String f16623y = "ext_sid";

    /* renamed from: z */
    public static String f16624z = "ext_token";

    /* renamed from: a */
    public static String m15982a(int i2) {
        switch (i2) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i2);
        }
    }
}
