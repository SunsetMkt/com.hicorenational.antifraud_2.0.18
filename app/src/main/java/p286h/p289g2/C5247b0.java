package p286h.p289g2;

import java.util.Iterator;
import p286h.C5715y1;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Iterators.kt */
/* renamed from: h.g2.b0 */
/* loaded from: classes2.dex */
class C5247b0 extends C5241a0 {
    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> Iterator<T> m19553a(@InterfaceC5816d Iterator<? extends T> it) {
        C5544i0.m22546f(it, "$this$iterator");
        return it;
    }

    /* renamed from: a */
    public static final <T> void m19554a(@InterfaceC5816d Iterator<? extends T> it, @InterfaceC5816d InterfaceC5506l<? super T, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(it, "$this$forEach");
        C5544i0.m22546f(interfaceC5506l, "operation");
        while (it.hasNext()) {
            interfaceC5506l.invoke(it.next());
        }
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Iterator<C5295r0<T>> m19555b(@InterfaceC5816d Iterator<? extends T> it) {
        C5544i0.m22546f(it, "$this$withIndex");
        return new C5301t0(it);
    }
}
