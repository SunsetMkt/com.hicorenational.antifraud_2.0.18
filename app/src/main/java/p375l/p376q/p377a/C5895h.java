package p375l.p376q.p377a;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.AbstractC4533s;
import p375l.C5884m;
import p375l.C5885n;
import p375l.InterfaceC5874c;

/* compiled from: RxJava2CallAdapterFactory.java */
/* renamed from: l.q.a.h */
/* loaded from: classes2.dex */
public final class C5895h extends InterfaceC5874c.a {

    /* renamed from: a */
    @Nullable
    private final AbstractC4516j0 f21356a;

    /* renamed from: b */
    private final boolean f21357b;

    private C5895h(@Nullable AbstractC4516j0 abstractC4516j0, boolean z) {
        this.f21356a = abstractC4516j0;
        this.f21357b = z;
    }

    /* renamed from: a */
    public static C5895h m24868a() {
        return new C5895h(null, false);
    }

    /* renamed from: b */
    public static C5895h m24870b() {
        return new C5895h(null, true);
    }

    /* renamed from: a */
    public static C5895h m24869a(AbstractC4516j0 abstractC4516j0) {
        if (abstractC4516j0 != null) {
            return new C5895h(abstractC4516j0, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // p375l.InterfaceC5874c.a
    /* renamed from: a */
    public InterfaceC5874c<?, ?> mo24752a(Type type, Annotation[] annotationArr, C5885n c5885n) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> m24750a = InterfaceC5874c.a.m24750a(type);
        if (m24750a == AbstractC4474c.class) {
            return new C5894g(Void.class, this.f21356a, this.f21357b, false, true, false, false, false, true);
        }
        boolean z3 = m24750a == AbstractC4519l.class;
        boolean z4 = m24750a == AbstractC4518k0.class;
        boolean z5 = m24750a == AbstractC4533s.class;
        if (m24750a != AbstractC4469b0.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type m24751a = InterfaceC5874c.a.m24751a(0, (ParameterizedType) type);
        Class<?> m24750a2 = InterfaceC5874c.a.m24750a(m24751a);
        if (m24750a2 == C5884m.class) {
            if (m24751a instanceof ParameterizedType) {
                type2 = InterfaceC5874c.a.m24751a(0, (ParameterizedType) m24751a);
                z = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (m24750a2 == C5892e.class) {
            if (m24751a instanceof ParameterizedType) {
                type2 = InterfaceC5874c.a.m24751a(0, (ParameterizedType) m24751a);
                z = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
        } else {
            type2 = m24751a;
            z = false;
            z2 = true;
            return new C5894g(type2, this.f21356a, this.f21357b, z, z2, z3, z4, z5, false);
        }
        z2 = false;
        return new C5894g(type2, this.f21356a, this.f21357b, z, z2, z3, z4, z5, false);
    }
}
