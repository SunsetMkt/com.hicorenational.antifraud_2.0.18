package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.push.C4100bb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.k */
/* loaded from: classes2.dex */
public class C4388k {

    /* renamed from: a */
    private static final Map<String, Long> f16709a = new HashMap();

    /* renamed from: a */
    public static boolean m16114a(byte[] bArr, String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
            String m13883a = C4100bb.m13883a(bArr);
            if (!TextUtils.isEmpty(m13883a)) {
                synchronized (f16709a) {
                    if (f16709a.get(m13883a + str) != null) {
                        z = true;
                    } else {
                        f16709a.put(m13883a + str, Long.valueOf(SystemClock.elapsedRealtime()));
                    }
                    m16113a();
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static void m16113a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(f16709a.size());
        for (Map.Entry<String, Long> entry : f16709a.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > C2084a.f6122d) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f16709a.remove((String) it.next());
        }
    }
}
