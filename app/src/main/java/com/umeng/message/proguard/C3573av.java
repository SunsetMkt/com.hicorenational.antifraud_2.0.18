package com.umeng.message.proguard;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.umeng.message.proguard.av */
/* loaded from: classes2.dex */
public final class C3573av {
    /* renamed from: a */
    public static String m12307a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
