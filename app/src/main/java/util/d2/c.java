package util.d2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: UrlUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static a a(String str) {
        a aVar;
        if (TextUtils.isEmpty(str) || str.indexOf(63) <= -1) {
            aVar = null;
        } else {
            String substring = str.substring(str.indexOf(63) + 1);
            int indexOf = substring.indexOf(35);
            aVar = indexOf > -1 ? b(substring.substring(0, indexOf)) : b(substring);
        }
        return aVar == null ? new a() : aVar;
    }

    public static a b(String str) {
        a aVar = new a();
        try {
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                    if (split2 != null && split2.length == 2) {
                        aVar.a(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return aVar;
    }

    public static String a(String str, String str2) throws IOException {
        URL url = new URL(str);
        if (str2.isEmpty() || url.getQuery().isEmpty()) {
            return str;
        }
        if (!str.contains("&" + str2)) {
            if (!str.contains("?" + str2)) {
                return str;
            }
        }
        return str.replace(str2, "");
    }
}
