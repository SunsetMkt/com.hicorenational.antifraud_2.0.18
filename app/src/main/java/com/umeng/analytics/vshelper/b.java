package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.bm;

/* compiled from: RealTimeDebugSwitch.java */
/* loaded from: classes2.dex */
public class b implements bm {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10589a = "RealTimeDebugSwitch";

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f10590b;

    @Override // com.umeng.analytics.pro.bm
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bm
    public void a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    @Override // com.umeng.analytics.pro.bm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.app.Activity r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.b.a(android.app.Activity, android.os.Bundle):void");
    }

    @Override // com.umeng.analytics.pro.bm
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bm
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.bm
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.bm
    public void c() {
    }

    @Override // com.umeng.analytics.pro.bm
    public void c(Activity activity) {
        f10590b++;
    }

    @Override // com.umeng.analytics.pro.bm
    public void d(Activity activity) {
        f10590b--;
    }

    @Override // com.umeng.analytics.pro.bm
    public void e(Activity activity) {
    }

    public static boolean d() {
        return f10590b > 0;
    }
}
