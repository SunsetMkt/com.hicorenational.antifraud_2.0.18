package p286h.p309q2.p311t;

import java.util.List;
import p286h.InterfaceC5610t0;
import p286h.p320w2.C5678s;
import p286h.p320w2.InterfaceC5662c;
import p286h.p320w2.InterfaceC5664e;
import p286h.p320w2.InterfaceC5665f;
import p286h.p320w2.InterfaceC5666g;
import p286h.p320w2.InterfaceC5668i;
import p286h.p320w2.InterfaceC5669j;
import p286h.p320w2.InterfaceC5670k;
import p286h.p320w2.InterfaceC5673n;
import p286h.p320w2.InterfaceC5674o;
import p286h.p320w2.InterfaceC5675p;
import p286h.p320w2.InterfaceC5676q;

/* compiled from: ReflectionFactory.java */
/* renamed from: h.q2.t.i1 */
/* loaded from: classes2.dex */
public class C5545i1 {

    /* renamed from: a */
    private static final String f20381a = "kotlin.jvm.functions.";

    /* renamed from: a */
    public InterfaceC5662c m22555a(Class cls) {
        return new C5582t(cls);
    }

    /* renamed from: a */
    public InterfaceC5666g m22557a(C5529d0 c5529d0) {
        return c5529d0;
    }

    /* renamed from: a */
    public InterfaceC5668i m22558a(AbstractC5568q0 abstractC5568q0) {
        return abstractC5568q0;
    }

    /* renamed from: a */
    public InterfaceC5669j m22559a(AbstractC5581s0 abstractC5581s0) {
        return abstractC5581s0;
    }

    /* renamed from: a */
    public InterfaceC5670k m22560a(AbstractC5585u0 abstractC5585u0) {
        return abstractC5585u0;
    }

    /* renamed from: a */
    public InterfaceC5673n m22561a(AbstractC5595z0 abstractC5595z0) {
        return abstractC5595z0;
    }

    /* renamed from: a */
    public InterfaceC5674o m22562a(AbstractC5524b1 abstractC5524b1) {
        return abstractC5524b1;
    }

    /* renamed from: a */
    public InterfaceC5675p m22563a(AbstractC5530d1 abstractC5530d1) {
        return abstractC5530d1;
    }

    /* renamed from: b */
    public InterfaceC5662c m22567b(Class cls) {
        return new C5582t(cls);
    }

    /* renamed from: c */
    public InterfaceC5665f m22569c(Class cls, String str) {
        return new C5591x0(cls, str);
    }

    /* renamed from: a */
    public InterfaceC5662c m22556a(Class cls, String str) {
        return new C5582t(cls);
    }

    /* renamed from: b */
    public InterfaceC5662c m22568b(Class cls, String str) {
        return new C5582t(cls);
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public String m22566a(AbstractC5547j0 abstractC5547j0) {
        return m22565a((InterfaceC5523b0) abstractC5547j0);
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public String m22565a(InterfaceC5523b0 interfaceC5523b0) {
        String obj = interfaceC5523b0.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith(f20381a) ? obj.substring(21) : obj;
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: a */
    public InterfaceC5676q m22564a(InterfaceC5664e interfaceC5664e, List<C5678s> list, boolean z) {
        return new C5566p1(interfaceC5664e, list, z);
    }
}
