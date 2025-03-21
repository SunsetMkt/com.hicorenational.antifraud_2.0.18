package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.bh;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f8859a = new b();

    public synchronized void a(int i2, int i3, byte[] bArr, a aVar, boolean z, String str) {
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            bh a2 = ah.a(e.G.u, i2, bArr);
            if (a2 != null) {
                e eVar = e.G;
                a2.f9323b = eVar.w;
                if (!TextUtils.isEmpty(eVar.R)) {
                    a2.f9326e = eVar.R;
                }
                if (a2.f9332k != null) {
                    a2.f9332k.put("G6", eVar.x);
                    a2.f9332k.put("G10", "1.4.5");
                    a2.f9332k.put("G3", "" + eVar.z);
                    a2.f9332k.put("G11", String.valueOf(eVar.y));
                    a2.f9332k.put("G7", "" + b2.m());
                    a2.f9332k.put("G8", "" + b2.k());
                    a2.f9332k.put("G9", "" + b2.l());
                    a2.f9332k.put("G2", String.valueOf(com.tencent.bugly.beta.global.a.a(e.G.u)));
                    a2.f9332k.put("G12", String.valueOf(eVar.q < 0 ? 0 : eVar.q));
                    a2.f9332k.put("A21", "" + b2.g());
                    a2.f9332k.put("A22", "" + b2.h());
                    a2.f9332k.put("G13", "" + eVar.L);
                    a2.f9332k.put("G14", "" + eVar.M);
                    a2.f9332k.put("G15", "" + eVar.O);
                    a2.f9332k.put("G17", "" + b2.x());
                    a2.f9332k.put("C01", "" + b2.H());
                    a2.f9332k.put("G18", "" + b2.g());
                    a2.f9332k.put("strategyType", "" + i3);
                    a2.f9332k.put("strategyRequestManner", "" + z);
                    Map<String, String> B = b2.B();
                    if (B != null && B.size() > 0) {
                        for (Map.Entry<String, String> entry : B.entrySet()) {
                            a2.f9332k.put("C03_" + entry.getKey(), entry.getValue());
                        }
                    }
                    an.c("app version is: [%s.%s], [deviceId:%s], channel: [%s], buildNo: [%s], base tinkerId:[%s], patch tinkerId:[%s], patch version:[%s], strategyType:[%s]", eVar.z, Integer.valueOf(eVar.y), b2.h(), a2.f9326e, Integer.valueOf(eVar.q), eVar.L, eVar.M, eVar.O, Integer.valueOf(i3));
                    HashMap hashMap = new HashMap();
                    hashMap.put("grayStrategyUpdateTime", e.G.H.f8854b + "");
                    if (z) {
                        ak.a().a(1002, a2.f9328g, ah.a((Object) a2), str, str, aVar, 0, 1, true, hashMap);
                    } else {
                        ak.a().a(1002, a2.f9328g, ah.a((Object) a2), str, str, (aj) aVar, false, (Map<String, String>) hashMap);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!an.a(th)) {
                th.printStackTrace();
            }
            aVar.a(i2, null, 0L, 0L, false, "sendRequest failed");
        }
    }

    public synchronized void a(w wVar, boolean z) {
        if (wVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVar);
        x xVar = new x(arrayList);
        try {
            a(803, -1, ah.a((m) xVar), new a(2, 803, xVar, Boolean.valueOf(z)), false, e.G.H.f8853a.f9351d);
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(x xVar, boolean z) {
        if (xVar == null) {
            return;
        }
        try {
            a(803, -1, ah.a((m) xVar), new a(2, 803, xVar, Boolean.valueOf(z)), false, e.G.H.f8853a.f9351d);
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
        }
    }
}
