package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4607f;

/* compiled from: MaybeContains.java */
/* renamed from: g.a.y0.e.c.h */
/* loaded from: classes2.dex */
public final class C4857h<T> extends AbstractC4518k0<Boolean> implements InterfaceC4607f<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18615a;

    /* renamed from: b */
    final Object f18616b;

    /* compiled from: MaybeContains.java */
    /* renamed from: g.a.y0.e.c.h$a */
    static final class a implements InterfaceC4559v<Object>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Boolean> f18617a;

        /* renamed from: b */
        final Object f18618b;

        /* renamed from: c */
        InterfaceC4552c f18619c;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, Object obj) {
            this.f18617a = interfaceC4524n0;
            this.f18618b = obj;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18619c.dispose();
            this.f18619c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18619c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18619c = EnumC4592d.DISPOSED;
            this.f18617a.onSuccess(false);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18619c = EnumC4592d.DISPOSED;
            this.f18617a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18619c, interfaceC4552c)) {
                this.f18619c = interfaceC4552c;
                this.f18617a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(Object obj) {
            this.f18619c = EnumC4592d.DISPOSED;
            this.f18617a.onSuccess(Boolean.valueOf(C4601b.m18285a(obj, this.f18618b)));
        }
    }

    public C4857h(InterfaceC4588y<T> interfaceC4588y, Object obj) {
        this.f18615a = interfaceC4588y;
        this.f18616b = obj;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        this.f18615a.mo18100a(new a(interfaceC4524n0, this.f18616b));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4607f
    public InterfaceC4588y<T> source() {
        return this.f18615a;
    }
}
