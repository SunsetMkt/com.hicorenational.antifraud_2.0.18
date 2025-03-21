package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ar */
/* loaded from: classes2.dex */
public class RunnableC3155ar implements Runnable {

    /* renamed from: a */
    private final Handler f10603a;

    /* renamed from: b */
    private final String f10604b;

    /* renamed from: c */
    private long f10605c;

    /* renamed from: d */
    private final long f10606d;

    /* renamed from: e */
    private boolean f10607e = true;

    /* renamed from: f */
    private long f10608f;

    RunnableC3155ar(Handler handler, String str, long j2) {
        this.f10603a = handler;
        this.f10604b = str;
        this.f10605c = j2;
        this.f10606d = j2;
    }

    /* renamed from: a */
    public void m9998a() {
        if (this.f10607e) {
            this.f10607e = false;
            this.f10608f = SystemClock.uptimeMillis();
            this.f10603a.postAtFrontOfQueue(this);
        }
    }

    /* renamed from: b */
    public boolean m10000b() {
        return !this.f10607e && SystemClock.uptimeMillis() > this.f10608f + this.f10605c;
    }

    /* renamed from: c */
    public int m10001c() {
        if (this.f10607e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f10608f < this.f10605c ? 1 : 3;
    }

    /* renamed from: d */
    public Thread m10002d() {
        return this.f10603a.getLooper().getThread();
    }

    /* renamed from: e */
    public String m10003e() {
        return this.f10604b;
    }

    /* renamed from: f */
    public void m10004f() {
        this.f10605c = this.f10606d;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10607e = true;
        m10004f();
    }

    /* renamed from: a */
    public void m9999a(long j2) {
        this.f10605c = j2;
    }
}
