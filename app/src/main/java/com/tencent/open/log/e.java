package com.tencent.open.log;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends Tracer {
    public static final e a = new e();

    @Override // com.tencent.open.log.Tracer
    protected void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 8 || i2 != 16) {
        }
    }
}
