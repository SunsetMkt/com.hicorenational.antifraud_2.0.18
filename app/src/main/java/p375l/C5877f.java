package p375l;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import p375l.InterfaceC5874c;

/* compiled from: DefaultCallAdapterFactory.java */
/* renamed from: l.f */
/* loaded from: classes2.dex */
final class C5877f extends InterfaceC5874c.a {

    /* renamed from: a */
    static final InterfaceC5874c.a f21197a = new C5877f();

    /* compiled from: DefaultCallAdapterFactory.java */
    /* renamed from: l.f$a */
    class a implements InterfaceC5874c<Object, InterfaceC5873b<?>> {

        /* renamed from: a */
        final /* synthetic */ Type f21198a;

        a(Type type) {
            this.f21198a = type;
        }

        @Override // p375l.InterfaceC5874c
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public InterfaceC5873b<?> mo24748a(InterfaceC5873b<Object> interfaceC5873b) {
            return interfaceC5873b;
        }

        @Override // p375l.InterfaceC5874c
        /* renamed from: a */
        public Type mo24749a() {
            return this.f21198a;
        }
    }

    C5877f() {
    }

    @Override // p375l.InterfaceC5874c.a
    /* renamed from: a */
    public InterfaceC5874c<?, ?> mo24752a(Type type, Annotation[] annotationArr, C5885n c5885n) {
        if (InterfaceC5874c.a.m24750a(type) != InterfaceC5873b.class) {
            return null;
        }
        return new a(C5887p.m24856b(type));
    }
}
