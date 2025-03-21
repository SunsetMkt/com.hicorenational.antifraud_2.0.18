package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.proguard.AbstractC3188m;
import com.tencent.bugly.proguard.C3145ah;
import com.tencent.bugly.proguard.C3148ak;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3172bh;
import com.tencent.bugly.proguard.C3198w;
import com.tencent.bugly.proguard.C3199x;
import com.tencent.bugly.proguard.InterfaceC3147aj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.upgrade.b */
/* loaded from: classes2.dex */
public class C3099b {

    /* renamed from: a */
    public static C3099b f9999a = new C3099b();

    /* renamed from: a */
    public synchronized void m9372a(int i2, int i3, byte[] bArr, C3098a c3098a, boolean z, String str) {
        C3113a m9532b = C3113a.m9532b();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            C3172bh m9849a = C3145ah.m9849a(C3082e.f9867G.f9919u, i2, bArr);
            if (m9849a != null) {
                C3082e c3082e = C3082e.f9867G;
                m9849a.f10662b = c3082e.f9921w;
                if (!TextUtils.isEmpty(c3082e.f9885R)) {
                    m9849a.f10665e = c3082e.f9885R;
                }
                if (m9849a.f10671k != null) {
                    m9849a.f10671k.put("G6", c3082e.f9922x);
                    m9849a.f10671k.put("G10", "1.4.5");
                    m9849a.f10671k.put("G3", "" + c3082e.f9924z);
                    m9849a.f10671k.put("G11", String.valueOf(c3082e.f9923y));
                    m9849a.f10671k.put("G7", "" + m9532b.m9580m());
                    m9849a.f10671k.put("G8", "" + m9532b.m9578k());
                    m9849a.f10671k.put("G9", "" + m9532b.m9579l());
                    m9849a.f10671k.put("G2", String.valueOf(C3078a.m9321a(C3082e.f9867G.f9919u)));
                    m9849a.f10671k.put("G12", String.valueOf(c3082e.f9915q < 0 ? 0 : c3082e.f9915q));
                    m9849a.f10671k.put("A21", "" + m9532b.m9573g());
                    m9849a.f10671k.put("A22", "" + m9532b.m9575h());
                    m9849a.f10671k.put("G13", "" + c3082e.f9879L);
                    m9849a.f10671k.put("G14", "" + c3082e.f9880M);
                    m9849a.f10671k.put("G15", "" + c3082e.f9882O);
                    m9849a.f10671k.put("G17", "" + m9532b.m9591x());
                    m9849a.f10671k.put("C01", "" + m9532b.m9542H());
                    m9849a.f10671k.put("G18", "" + m9532b.m9573g());
                    m9849a.f10671k.put("strategyType", "" + i3);
                    m9849a.f10671k.put("strategyRequestManner", "" + z);
                    Map<String, String> m9536B = m9532b.m9536B();
                    if (m9536B != null && m9536B.size() > 0) {
                        for (Map.Entry<String, String> entry : m9536B.entrySet()) {
                            m9849a.f10671k.put("C03_" + entry.getKey(), entry.getValue());
                        }
                    }
                    C3151an.m9921c("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", c3082e.f9924z, Integer.valueOf(c3082e.f9923y), m9532b.m9575h(), m9849a.f10665e, Integer.valueOf(c3082e.f9915q), c3082e.f9879L, c3082e.f9880M, c3082e.f9882O, Integer.valueOf(i3));
                    HashMap hashMap = new HashMap();
                    hashMap.put("grayStrategyUpdateTime", C3082e.f9867G.f9875H.f9994b + "");
                    if (z) {
                        C3148ak.m9863a().m9884a(1002, m9849a.f10667g, C3145ah.m9855a((Object) m9849a), str, str, c3098a, 0, 1, true, hashMap);
                    } else {
                        C3148ak.m9863a().m9886a(1002, m9849a.f10667g, C3145ah.m9855a((Object) m9849a), str, str, (InterfaceC3147aj) c3098a, false, (Map<String, String>) hashMap);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
            c3098a.mo9371a(i2, null, 0L, 0L, false, "sendRequest failed");
        }
    }

    /* renamed from: a */
    public synchronized void m9373a(C3198w c3198w, boolean z) {
        if (c3198w == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c3198w);
        C3199x c3199x = new C3199x(arrayList);
        try {
            m9372a(803, -1, C3145ah.m9854a((AbstractC3188m) c3199x), new C3098a(2, 803, c3199x, Boolean.valueOf(z)), false, C3082e.f9867G.f9875H.f9993a.f10703d);
        } catch (Throwable th) {
            if (!C3151an.m9919b(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m9374a(C3199x c3199x, boolean z) {
        if (c3199x == null) {
            return;
        }
        try {
            m9372a(803, -1, C3145ah.m9854a((AbstractC3188m) c3199x), new C3098a(2, 803, c3199x, Boolean.valueOf(z)), false, C3082e.f9867G.f9875H.f9993a.f10703d);
        } catch (Throwable th) {
            if (!C3151an.m9919b(th)) {
                th.printStackTrace();
            }
        }
    }
}
