package com.scwang.smartrefresh.layout.p192e;

/* compiled from: DelayedRunnable.java */
/* renamed from: com.scwang.smartrefresh.layout.e.a */
/* loaded from: classes.dex */
public class RunnableC2888a implements Runnable {

    /* renamed from: a */
    public long f9114a;

    /* renamed from: b */
    private Runnable f9115b;

    public RunnableC2888a(Runnable runnable, long j2) {
        this.f9115b = runnable;
        this.f9114a = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f9115b != null) {
                this.f9115b.run();
                this.f9115b = null;
            }
        } catch (Throwable th) {
            if (th instanceof NoClassDefFoundError) {
                return;
            }
            th.printStackTrace();
        }
    }
}
