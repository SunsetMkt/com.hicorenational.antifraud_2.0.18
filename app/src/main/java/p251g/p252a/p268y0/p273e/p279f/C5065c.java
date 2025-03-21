package p251g.p252a.p268y0.p273e.p279f;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;

/* compiled from: SingleContains.java */
/* renamed from: g.a.y0.e.f.c */
/* loaded from: classes2.dex */
public final class C5065c<T> extends AbstractC4518k0<Boolean> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19679a;

    /* renamed from: b */
    final Object f19680b;

    /* renamed from: c */
    final InterfaceC4573d<Object, Object> f19681c;

    /* compiled from: SingleContains.java */
    /* renamed from: g.a.y0.e.f.c$a */
    final class a implements InterfaceC4524n0<T> {

        /* renamed from: a */
        private final InterfaceC4524n0<? super Boolean> f19682a;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
            this.f19682a = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19682a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19682a.onSubscribe(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                this.f19682a.onSuccess(Boolean.valueOf(C5065c.this.f19681c.mo18210a(t, C5065c.this.f19680b)));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19682a.onError(th);
            }
        }
    }

    public C5065c(InterfaceC4530q0<T> interfaceC4530q0, Object obj, InterfaceC4573d<Object, Object> interfaceC4573d) {
        this.f19679a = interfaceC4530q0;
        this.f19680b = obj;
        this.f19681c = interfaceC4573d;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        this.f19679a.mo17490a(new a(interfaceC4524n0));
    }
}
