package i.y2;

import i.m2.f;
import i.q2.e;

/* JADX INFO: compiled from: Process.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "ProcessKt")
public final class a {
    @f
    private static final Void a(int i2) {
        System.exit(i2);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
