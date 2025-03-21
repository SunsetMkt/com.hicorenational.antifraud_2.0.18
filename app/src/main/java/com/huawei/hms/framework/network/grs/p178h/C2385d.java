package com.huawei.hms.framework.network.grs.p178h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.h.d */
/* loaded from: classes.dex */
public class C2385d {

    /* renamed from: a */
    private static final Map<String, a> f7442a = new ConcurrentHashMap(16);

    /* renamed from: com.huawei.hms.framework.network.grs.h.d$a */
    public static class a {

        /* renamed from: a */
        private final long f7443a;

        /* renamed from: b */
        private final long f7444b;

        public a(long j2, long j3) {
            this.f7443a = j2;
            this.f7444b = j3;
        }

        /* renamed from: a */
        public boolean m6983a() {
            return SystemClock.elapsedRealtime() - this.f7444b <= this.f7443a;
        }
    }

    /* renamed from: a */
    public static a m6981a(String str) {
        Logger.m6801v("RequestUtil", "map size of get is before: " + f7442a.size());
        a aVar = f7442a.get(str);
        Logger.m6801v("RequestUtil", "map size of get is after: " + f7442a.size());
        return aVar;
    }

    /* renamed from: a */
    public static void m6982a(String str, a aVar) {
        Logger.m6801v("RequestUtil", "map size of put is before: " + f7442a.size());
        f7442a.put(str, aVar);
        Logger.m6801v("RequestUtil", "map size of put is after: " + f7442a.size());
    }
}
