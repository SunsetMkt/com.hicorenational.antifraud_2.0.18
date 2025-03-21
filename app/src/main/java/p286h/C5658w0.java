package p286h;

import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5535f0;

/* compiled from: Synchronized.kt */
/* renamed from: h.w0 */
/* loaded from: classes2.dex */
class C5658w0 extends C5630v0 {
    @InterfaceC5426f
    /* renamed from: a */
    private static final <R> R m23222a(Object obj, InterfaceC5495a<? extends R> interfaceC5495a) {
        R invoke;
        synchronized (obj) {
            try {
                invoke = interfaceC5495a.invoke();
                C5535f0.m22474b(1);
            } catch (Throwable th) {
                C5535f0.m22474b(1);
                C5535f0.m22471a(1);
                throw th;
            }
        }
        C5535f0.m22471a(1);
        return invoke;
    }
}
