package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.b;

/* JADX INFO: loaded from: classes2.dex */
public class NnApiDelegate implements b, AutoCloseable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f13016b = 0;
    private long a = createDelegate();

    private static native long createDelegate();

    @Override // org.tensorflow.lite.b
    public long c() {
        return this.a;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.a != 0) {
            this.a = 0L;
        }
    }
}
