package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.hatool.e1 */
/* loaded from: classes.dex */
public class C2408e1 {
    /* renamed from: a */
    public static String m7096a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2)) {
            return m7099a(str, str2, str3) ? str2 : str4;
        }
        C2452v.m7390f("hmsSdk", "checkStrParameter() Parameter verification failure! Parameter:" + str);
        return str4;
    }

    /* renamed from: a */
    public static boolean m7097a(String str) {
        return !m7098a(C2085b.f6170k, str, 256);
    }

    /* renamed from: a */
    public static boolean m7098a(String str, String str2, int i2) {
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            str3 = "checkString() Parameter is empty : ";
        } else {
            if (str2.length() <= i2) {
                return true;
            }
            sb = new StringBuilder();
            str3 = "checkString() Failure of parameter length check! Parameter:";
        }
        sb.append(str3);
        sb.append(str);
        C2452v.m7390f("hmsSdk", sb.toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m7099a(String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
            str4 = "checkString() Parameter is null! Parameter:";
        } else {
            if (Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            }
            sb = new StringBuilder();
            str4 = "checkString() Parameter verification failure! Parameter:";
        }
        sb.append(str4);
        sb.append(str);
        C2452v.m7390f("hmsSdk", sb.toString());
        return false;
    }

    /* renamed from: a */
    public static boolean m7100a(Map<String, String> map) {
        String str;
        if (map == null || map.size() == 0) {
            str = "onEvent() mapValue has not data.so,The data will be empty";
        } else if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
            str = "checkMap() the key can't be constants or _constants";
        } else {
            if (map.size() <= 2048 && map.toString().length() <= 204800) {
                return true;
            }
            str = "checkMap Map data is too big! size: " + map.size() + " length: " + map.toString().length();
        }
        C2452v.m7390f("hmsSdk", str);
        return false;
    }
}
