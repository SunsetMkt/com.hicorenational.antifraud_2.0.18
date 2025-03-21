package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import p286h.p323z2.C5736h0;

/* renamed from: com.xiaomi.push.az */
/* loaded from: classes2.dex */
public class C4097az {
    /* renamed from: a */
    public static String m13846a(String str) {
        try {
            return String.valueOf(C4096ay.m13843a(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e2) {
            AbstractC4022b.m13349a("CloudCoder.hash4SHA1 ", e2);
            throw new IllegalStateException("failed to SHA1");
        } catch (NoSuchAlgorithmException e3) {
            AbstractC4022b.m13349a("CloudCoder.hash4SHA1 ", e3);
            throw new IllegalStateException("failed to SHA1");
        } catch (Exception e4) {
            AbstractC4022b.m13349a("CloudCoder.hash4SHA1 ", e4);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    /* renamed from: a */
    public static String m13847a(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            boolean z = true;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str3);
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                if (!z) {
                    sb.append(C5736h0.f20714c);
                }
                sb.append(str4);
                z = false;
            }
            return m13846a(sb.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }
}
