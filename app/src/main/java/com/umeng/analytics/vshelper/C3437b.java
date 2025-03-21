package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.InterfaceC3356bm;

/* compiled from: RealTimeDebugSwitch.java */
/* renamed from: com.umeng.analytics.vshelper.b */
/* loaded from: classes2.dex */
public class C3437b implements InterfaceC3356bm {

    /* renamed from: a */
    private static final String f12326a = "RealTimeDebugSwitch";

    /* renamed from: b */
    private static volatile int f12327b;

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: a */
    public void mo10999a() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: a */
    public void mo11000a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo11001a(android.app.Activity r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.C3437b.mo11001a(android.app.Activity, android.os.Bundle):void");
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: b */
    public void mo11002b() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: b */
    public void mo11003b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: b */
    public void mo11004b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: c */
    public void mo11005c() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: c */
    public void mo11006c(Activity activity) {
        f12327b++;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: d */
    public void mo11007d(Activity activity) {
        f12327b--;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3356bm
    /* renamed from: e */
    public void mo11008e(Activity activity) {
    }

    /* renamed from: d */
    public static boolean m11456d() {
        return f12327b > 0;
    }
}
