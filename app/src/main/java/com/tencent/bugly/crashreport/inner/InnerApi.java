package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.crashreport.crash.C3128d;
import com.tencent.bugly.proguard.C3151an;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i2, String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C3151an.m9923e("post cocos2d-x fail args null", new Object[0]);
        } else if (i2 != 5 && i2 != 6) {
            C3151an.m9923e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i2));
        } else {
            C3151an.m9915a("post cocos2d-x crash %s %s", str, str2);
            C3128d.m9739a(Thread.currentThread(), i2, str, str2, str3, null);
        }
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str == null || str2 == null || str3 == null) {
            C3151an.m9923e("post h5 fail args null", new Object[0]);
        } else {
            C3151an.m9915a("post h5 crash %s %s", str, str2);
            C3128d.m9739a(thread, 8, str, str2, str3, map);
        }
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            C3151an.m9923e("post u3d fail args null", new Object[0]);
        }
        C3151an.m9915a("post u3d crash %s %s", str, str2);
        C3128d.m9739a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
