package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dy {
    private static Vector<Pair<String, Long>> a = new Vector<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<String, Long> f416a = new ConcurrentHashMap<>();

    public static String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (a) {
            for (int i2 = 0; i2 < a.size(); i2++) {
                Pair<String, Long> pairElementAt = a.elementAt(i2);
                sb.append((String) pairElementAt.first);
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(pairElementAt.second);
                if (i2 < a.size() - 1) {
                    sb.append(";");
                }
            }
            a.clear();
        }
        return sb.toString();
    }
}
