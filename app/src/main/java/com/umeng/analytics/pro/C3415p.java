package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* compiled from: CrashHandler.java */
/* renamed from: com.umeng.analytics.pro.p */
/* loaded from: classes2.dex */
public class C3415p implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f12234a;

    /* renamed from: b */
    private InterfaceC3419t f12235b;

    public C3415p() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f12234a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    public void m11361a(InterfaceC3419t interfaceC3419t) {
        this.f12235b = interfaceC3419t;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m11360a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f12234a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f12234a.uncaughtException(thread, th);
    }

    /* renamed from: a */
    private void m11360a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f12235b.mo10760a(th);
        } else {
            this.f12235b.mo10760a(null);
        }
    }
}
