package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4606e;

/* compiled from: MaybeFromCompletable.java */
/* renamed from: g.a.y0.e.c.j0 */
/* loaded from: classes2.dex */
public final class C4864j0<T> extends AbstractC4533s<T> implements InterfaceC4606e {

    /* renamed from: a */
    final InterfaceC4513i f18630a;

    /* compiled from: MaybeFromCompletable.java */
    /* renamed from: g.a.y0.e.c.j0$a */
    static final class a<T> implements InterfaceC4491f, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18631a;

        /* renamed from: b */
        InterfaceC4552c f18632b;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.f18631a = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18632b.dispose();
            this.f18632b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18632b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f18632b = EnumC4592d.DISPOSED;
            this.f18631a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.f18632b = EnumC4592d.DISPOSED;
            this.f18631a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18632b, interfaceC4552c)) {
                this.f18632b = interfaceC4552c;
                this.f18631a.onSubscribe(this);
            }
        }
    }

    public C4864j0(InterfaceC4513i interfaceC4513i) {
        this.f18630a = interfaceC4513i;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18630a.mo17074a(new a(interfaceC4559v));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4606e
    public InterfaceC4513i source() {
        return this.f18630a;
    }
}
