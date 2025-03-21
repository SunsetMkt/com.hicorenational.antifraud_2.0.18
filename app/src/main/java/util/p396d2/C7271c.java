package util.p396d2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: UrlUtils.java */
/* renamed from: util.d2.c */
/* loaded from: classes2.dex */
public class C7271c {
    /* renamed from: a */
    public static C7269a m26330a(String str) {
        C7269a c7269a;
        if (TextUtils.isEmpty(str) || str.indexOf(63) <= -1) {
            c7269a = null;
        } else {
            String substring = str.substring(str.indexOf(63) + 1);
            int indexOf = substring.indexOf(35);
            c7269a = indexOf > -1 ? m26331b(substring.substring(0, indexOf)) : m26331b(substring);
        }
        return c7269a == null ? new C7269a() : c7269a;
    }

    /* renamed from: b */
    public static C7269a m26331b(String str) {
        C7269a c7269a = new C7269a();
        try {
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                    if (split2 != null && split2.length == 2) {
                        c7269a.m26321a(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return c7269a;
    }

    /* renamed from: a */
    public static String m26329a(String str, String str2) throws IOException {
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
