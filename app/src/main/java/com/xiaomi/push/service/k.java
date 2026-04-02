package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private static final Map<String, Long> a = new HashMap();

    public static boolean a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String strA = com.xiaomi.push.bb.a(bArr);
            if (!TextUtils.isEmpty(strA)) {
                synchronized (a) {
                    if (a.get(strA + str) != null) {
                        z = true;
                    } else {
                        a.put(strA + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }

    private static void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(a.size());
        for (Map.Entry<String, Long> entry : a.entrySet()) {
            if (jElapsedRealtime - entry.getValue().longValue() > com.heytap.mcssdk.constant.a.f3868d) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a.remove((String) it.next());
        }
    }
}
