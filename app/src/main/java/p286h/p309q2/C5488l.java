package p286h.p309q2;

import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: KotlinReflectionNotSupportedError.kt */
/* renamed from: h.q2.l */
/* loaded from: classes2.dex */
public class C5488l extends Error {
    public C5488l() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public C5488l(@InterfaceC5817e String str) {
        super(str);
    }

    public C5488l(@InterfaceC5817e String str, @InterfaceC5817e Throwable th) {
        super(str, th);
    }

    public C5488l(@InterfaceC5817e Throwable th) {
        super(th);
    }
}
