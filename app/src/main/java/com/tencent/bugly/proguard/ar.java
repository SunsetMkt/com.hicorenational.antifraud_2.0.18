package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ar implements Runnable {
    private final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f6436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6437e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6438f;

    ar(Handler handler, String str, long j2) {
        this.a = handler;
        this.f6434b = str;
        this.f6435c = j2;
        this.f6436d = j2;
    }

    public void a() {
        if (this.f6437e) {
            this.f6437e = false;
            this.f6438f = SystemClock.uptimeMillis();
            this.a.postAtFrontOfQueue(this);
        }
    }

    public boolean b() {
        return !this.f6437e && SystemClock.uptimeMillis() > this.f6438f + this.f6435c;
    }

    public int c() {
        if (this.f6437e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f6438f < this.f6435c ? 1 : 3;
    }

    public Thread d() {
        return this.a.getLooper().getThread();
    }

    public String e() {
        return this.f6434b;
    }

    public void f() {
        this.f6435c = this.f6436d;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6437e = true;
        f();
    }

    public void a(long j2) {
        this.f6435c = j2;
    }
}
