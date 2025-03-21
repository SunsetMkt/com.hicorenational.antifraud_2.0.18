package p375l.p376q.p377a;

import java.lang.reflect.Type;
import javax.annotation.Nullable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.EnumC4468b;
import p375l.InterfaceC5873b;
import p375l.InterfaceC5874c;

/* compiled from: RxJava2CallAdapter.java */
/* renamed from: l.q.a.g */
/* loaded from: classes2.dex */
final class C5894g<R> implements InterfaceC5874c<R, Object> {

    /* renamed from: a */
    private final Type f21347a;

    /* renamed from: b */
    @Nullable
    private final AbstractC4516j0 f21348b;

    /* renamed from: c */
    private final boolean f21349c;

    /* renamed from: d */
    private final boolean f21350d;

    /* renamed from: e */
    private final boolean f21351e;

    /* renamed from: f */
    private final boolean f21352f;

    /* renamed from: g */
    private final boolean f21353g;

    /* renamed from: h */
    private final boolean f21354h;

    /* renamed from: i */
    private final boolean f21355i;

    C5894g(Type type, @Nullable AbstractC4516j0 abstractC4516j0, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f21347a = type;
        this.f21348b = abstractC4516j0;
        this.f21349c = z;
        this.f21350d = z2;
        this.f21351e = z3;
        this.f21352f = z4;
        this.f21353g = z5;
        this.f21354h = z6;
        this.f21355i = z7;
    }

    @Override // p375l.InterfaceC5874c
    /* renamed from: a */
    public Type mo24749a() {
        return this.f21347a;
    }

    @Override // p375l.InterfaceC5874c
    /* renamed from: a */
    public Object mo24748a(InterfaceC5873b<R> interfaceC5873b) {
        AbstractC4469b0 c5889b = this.f21349c ? new C5889b(interfaceC5873b) : new C5890c(interfaceC5873b);
        AbstractC4469b0 c5893f = this.f21350d ? new C5893f(c5889b) : this.f21351e ? new C5888a(c5889b) : c5889b;
        AbstractC4516j0 abstractC4516j0 = this.f21348b;
        if (abstractC4516j0 != null) {
            c5893f = c5893f.m16825c(abstractC4516j0);
        }
        return this.f21352f ? c5893f.m16759a(EnumC4468b.LATEST) : this.f21353g ? c5893f.m16651C() : this.f21354h ? c5893f.m16649B() : this.f21355i ? c5893f.m16942p() : c5893f;
    }
}
