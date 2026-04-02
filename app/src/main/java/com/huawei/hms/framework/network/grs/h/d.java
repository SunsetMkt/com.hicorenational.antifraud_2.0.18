package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final Map<String, a> a = new ConcurrentHashMap(16);

    public static class a {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f4683b;

        public a(long j2, long j3) {
            this.a = j2;
            this.f4683b = j3;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.f4683b <= this.a;
        }
    }

    public static a a(String str) {
        Logger.v("RequestUtil", "map size of get is before: " + a.size());
        a aVar = a.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + a.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        Logger.v("RequestUtil", "map size of put is before: " + a.size());
        a.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + a.size());
    }
}
