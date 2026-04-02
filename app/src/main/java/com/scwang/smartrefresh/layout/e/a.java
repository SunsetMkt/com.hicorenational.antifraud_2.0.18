package com.scwang.smartrefresh.layout.e;

/* JADX INFO: compiled from: DelayedRunnable.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f5612b;

    public a(Runnable runnable, long j2) {
        this.f5612b = runnable;
        this.a = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f5612b != null) {
                this.f5612b.run();
                this.f5612b = null;
            }
        } catch (Throwable th) {
            if (th instanceof NoClassDefFoundError) {
                return;
            }
            th.printStackTrace();
        }
    }
}
