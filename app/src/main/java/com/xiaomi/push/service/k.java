package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f13424a = new HashMap();

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String a2 = com.xiaomi.push.bb.a(bArr);
            if (!TextUtils.isEmpty(a2)) {
                synchronized (f13424a) {
                    if (f13424a.get(a2 + str) != null) {
                        z = true;
                    } else {
                        f13424a.put(a2 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }

    private static void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(f13424a.size());
        for (Map.Entry<String, Long> entry : f13424a.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > com.heytap.mcssdk.constant.a.f5800d) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f13424a.remove((String) it.next());
        }
    }
}
