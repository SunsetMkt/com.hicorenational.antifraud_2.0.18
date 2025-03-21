package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.InterfaceC6076b;

/* loaded from: classes2.dex */
public class NnApiDelegate implements InterfaceC6076b, AutoCloseable {

    /* renamed from: b */
    private static final long f21693b = 0;

    /* renamed from: a */
    private long f21694a = createDelegate();

    private static native long createDelegate();

    @Override // org.tensorflow.lite.InterfaceC6076b
    /* renamed from: c */
    public long mo25139c() {
        return this.f21694a;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.f21694a != 0) {
            this.f21694a = 0L;
        }
    }
}
