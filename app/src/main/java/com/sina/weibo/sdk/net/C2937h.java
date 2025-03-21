package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* renamed from: com.sina.weibo.sdk.net.h */
/* loaded from: classes.dex */
public final class C2937h {

    /* renamed from: q */
    private HashMap<String, String> f9324q = new HashMap<>();

    /* renamed from: g */
    public final String m8860g() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : this.f9324q.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String str2 = this.f9324q.get(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public final void put(String str, String str2) {
        this.f9324q.put(str, str2);
    }
}
