package com.bumptech.glide.p137r;

/* compiled from: RequestCoordinator.java */
/* renamed from: com.bumptech.glide.r.e */
/* loaded from: classes.dex */
public interface InterfaceC1826e {

    /* compiled from: RequestCoordinator.java */
    /* renamed from: com.bumptech.glide.r.e$a */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        a(boolean z) {
            this.isComplete = z;
        }

        boolean isComplete() {
            return this.isComplete;
        }
    }

    /* renamed from: a */
    boolean mo4805a();

    /* renamed from: b */
    void mo4807b(InterfaceC1825d interfaceC1825d);

    /* renamed from: c */
    boolean mo4810c(InterfaceC1825d interfaceC1825d);

    /* renamed from: d */
    boolean mo4812d(InterfaceC1825d interfaceC1825d);

    /* renamed from: e */
    void mo4813e(InterfaceC1825d interfaceC1825d);

    /* renamed from: f */
    boolean mo4814f(InterfaceC1825d interfaceC1825d);

    InterfaceC1826e getRoot();
}
