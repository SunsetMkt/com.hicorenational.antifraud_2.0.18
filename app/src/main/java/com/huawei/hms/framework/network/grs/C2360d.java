package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.d */
/* loaded from: classes.dex */
public class C2360d {

    /* renamed from: a */
    private static final Map<String, C2359c> f7350a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private static final Object f7351b = new Object();

    /* renamed from: a */
    public static C2359c m6844a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f7351b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            C2359c c2359c = f7350a.get(context.getPackageName() + uniqueCode);
            if (c2359c == null) {
                Logger.m6799i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                C2359c c2359c2 = new C2359c(context, grsBaseInfo);
                f7350a.put(context.getPackageName() + uniqueCode, c2359c2);
                return c2359c2;
            }
            if (c2359c.m6842a((Object) new C2359c(grsBaseInfo))) {
                return c2359c;
            }
            Logger.m6799i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
            C2359c c2359c3 = new C2359c(context, grsBaseInfo);
            f7350a.put(context.getPackageName() + uniqueCode, c2359c3);
            return c2359c3;
        }
    }
}
