package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.dy */
/* loaded from: classes2.dex */
public class C4177dy {

    /* renamed from: a */
    private static Vector<Pair<String, Long>> f15059a = new Vector<>();

    /* renamed from: a */
    private static ConcurrentHashMap<String, Long> f15060a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m14577a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f15059a) {
            for (int i2 = 0; i2 < f15059a.size(); i2++) {
                Pair<String, Long> elementAt = f15059a.elementAt(i2);
                sb.append((String) elementAt.first);
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(elementAt.second);
                if (i2 < f15059a.size() - 1) {
                    sb.append(";");
                }
            }
            f15059a.clear();
        }
        return sb.toString();
    }
}
