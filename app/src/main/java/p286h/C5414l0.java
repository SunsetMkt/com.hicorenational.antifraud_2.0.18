package p286h;

import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;

/* compiled from: AssertionsJVM.kt */
/* renamed from: h.l0 */
/* loaded from: classes2.dex */
class C5414l0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22149a(boolean z) {
        if (C5227e2.f20082a && !z) {
            throw new AssertionError("Assertion failed");
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final void m22150a(boolean z, InterfaceC5495a<? extends Object> interfaceC5495a) {
        if (C5227e2.f20082a && !z) {
            throw new AssertionError(interfaceC5495a.invoke());
        }
    }
}
