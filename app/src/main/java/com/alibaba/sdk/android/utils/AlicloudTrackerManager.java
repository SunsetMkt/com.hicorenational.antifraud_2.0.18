package com.alibaba.sdk.android.utils;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.crashdefend.C1568b;
import com.alibaba.sdk.android.utils.crashdefend.C1569c;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AlicloudTrackerManager {

    /* renamed from: a */
    private static AlicloudTrackerManager f4027a;

    /* renamed from: a */
    private C1565a f4028a = new C1565a();

    /* renamed from: a */
    private C1568b f4029a;

    /* renamed from: b */
    private Map<String, AlicloudTracker> f4030b;

    private AlicloudTrackerManager(Application application) {
        this.f4029a = null;
        HashMap hashMap = new HashMap(4);
        hashMap.put("kVersion", "2.0.0");
        hashMap.put(Constants.KEY_PACKAGE_NAME, application.getPackageName());
        this.f4028a.m3600a(application, hashMap);
        this.f4030b = new HashMap();
        this.f4029a = C1568b.m3604a(application, this.f4028a);
    }

    public static synchronized AlicloudTrackerManager getInstance(Application application) {
        synchronized (AlicloudTrackerManager.class) {
            if (application == null) {
                return null;
            }
            if (f4027a == null) {
                f4027a = new AlicloudTrackerManager(application);
            }
            return f4027a;
        }
    }

    public AlicloudTracker getTracker(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + str2;
        if (this.f4030b.containsKey(str3)) {
            return this.f4030b.get(str3);
        }
        AlicloudTracker alicloudTracker = new AlicloudTracker(this.f4028a, str, str2);
        this.f4030b.put(str3, alicloudTracker);
        return alicloudTracker;
    }

    public boolean registerCrashDefend(String str, String str2, int i2, int i3, SDKMessageCallback sDKMessageCallback) {
        if (this.f4029a == null) {
            return false;
        }
        C1569c c1569c = new C1569c();
        c1569c.f4051a = str;
        c1569c.f4054b = str2;
        c1569c.f4048a = i2;
        c1569c.f4052b = i3;
        return this.f4029a.m3616a(c1569c, sDKMessageCallback);
    }

    public void unregisterCrashDefend(String str, String str2) {
        this.f4029a.m3617b(str, str2);
    }
}
