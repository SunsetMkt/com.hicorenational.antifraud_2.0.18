package com.huawei.hms.opendevice;

/* compiled from: TaskWrapper.java */
/* renamed from: com.huawei.hms.opendevice.o */
/* loaded from: classes.dex */
public class RunnableC2477o implements Runnable {

    /* renamed from: a */
    private final Runnable f7675a;

    public RunnableC2477o(Runnable runnable) {
        this.f7675a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f7675a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
            }
        }
    }
}
